package com.mysite.ocr;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class OCRApi {
	
	public void processOCR(String img) {
		String secretKey = "Q3VCUVR1Y3NsUWZ4WXZCR0dCV1ZxYXZFQnRDaFV2TGI=";
		String apiURL = "https://dv5yppx7ev.apigw.ntruss.com/custom/v1/21769/7552c9f794e3a12d01e0e00586c71964a754fcf2650140f8dbad9a173bfaaa8e/infer";
		String imageFile = img;
		
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setUseCaches(false);
			con.setDoInput(true);// InputStream으로 서버로 부터 응답을 받겠다는 옵션.
			con.setDoOutput(true);// OutputStream으로 POST 데이터를 넘겨주겠다는 옵션.
			con.setReadTimeout(30000);
			con.setRequestMethod("GET");
			String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
			con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			con.setRequestProperty("X-OCR-SECRET", secretKey);
	
			JSONObject json = new JSONObject();
			json.put("version", "V2");
			json.put("requestId", UUID.randomUUID().toString());	//요청 아이디
			json.put("timestamp", System.currentTimeMillis());
			JSONObject image = new JSONObject();
			image.put("format", "jpg");
			image.put("name", "demo");	//demo는 내가 지정한 이름
			JSONArray images = new JSONArray();
			images.put(image);
			json.put("images", images);
			String postParams = json.toString();	//JSON의 객체 구조를 문자열로 postParams에 저장
	
			con.connect();	//연결작업
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());	//getOutputStream() : 데이터를 네이버 클라우드로 보낼 수 있는 전송객체 생성(챗봇과 동일)
			long start = System.currentTimeMillis();
			File file = new File(imageFile);
			writeMultiPart(wr, postParams, file, boundary);	//wr : 출력 객체
			wr.close();
	
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {  // 요청 성공
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));	//getInputStream() 정상 처리결과 송신 객체
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));	//getErrorStream() 오류 수신 객체
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) { //응답 수신, inputLine에 읽은 내용 저장
				response.append(inputLine);	//결과물 response에 대입
			}
			br.close();
			
			JSONObject responseObj = new JSONObject(response.toString());	//결과를 정돈해서 출력하기 위한 내용	
			Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
			String responseJson = gson.toJson(responseObj);
			System.out.println(responseJson);
			
			responseDataPrint(response.toString());	//responseJson으로부터 데이터 추출
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void responseDataPrint(String response) {	//response 해당 데이터 전달 받음
		 JSONObject jObject = new JSONObject(response);	//jObject 객체로 생성
			
		 
		 String version = jObject.getString("version");
		 String requestId = jObject.getString("requestId");
		 Date date = new Date(jObject.getLong("timestamp"));
		 SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd kk:mm:ss");
		 String update_date = sdf.format(date);		 
		 
		//받은 정보 출력
		 System.out.println("------------------------------------------");
		 System.out.println("version : " + version);
		 System.out.println("requestId : " + requestId);
		 System.out.println("timestamp : " + update_date);		
		 
		 JSONArray images = (JSONArray)jObject.get("images");	//이미지 정보, 네이버 OCR에 지정한 필드 들을 배열로 정리
		 JSONObject imagesObj = (JSONObject)images.get(0);

		 JSONObject title = (JSONObject)imagesObj.get("title");
		 System.out.println("------------------------------------------");
		 System.out.println("name : " + title.get("name"));
		 System.out.println("inferText : " + title.get("inferText"));
		 
		 
		 JSONArray fields = (JSONArray)imagesObj.get("fields");
		 for (int i=0; i<fields.length(); i++) {
			 JSONObject fieldsObj = (JSONObject)fields.get(i);
			 String name = fieldsObj.getString("name"); 
			 String inferText = fieldsObj.getString("inferText");	//inferText : 실제 값 (OCR에 필드마다 내가 지정한 이름들)
			 System.out.println("------------------------------------------");
			 System.out.println("name : " + name);
			 System.out.println("inferText : " + inferText);
		 }
	}
			 
	//OCR에 파일을 전송하는 과정
	private void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("--").append(boundary).append("\r\n");
		sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
		sb.append(jsonMessage);
		sb.append("\r\n");
	
		out.write(sb.toString().getBytes("UTF-8"));
		out.flush();
		if (file != null && file.isFile()) {
			out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
			StringBuilder fileString = new StringBuilder();
			fileString.append("Content-Disposition:form-data; name=\"file\"; filename=");
			fileString.append("\"" + file.getName() + "\"\r\n");
			fileString.append("Content-Type: application/octet-stream\r\n\r\n");
			out.write(fileString.toString().getBytes("UTF-8"));
			out.flush();
			
			//실제 파일을 전송하는 부분
			try (FileInputStream fis = new FileInputStream(file)) {
				byte[] buffer = new byte[8192];
				int count;
				while ((count = fis.read(buffer)) != -1) {	//파일을 읽어 buffer 배열에 저장 후 실제 읽은 문자의 갯수를 count에 반환
					out.write(buffer, 0, count);
				}
				out.write("\r\n".getBytes());
			}
	
			out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
		}
		out.flush();
	}	 
}
