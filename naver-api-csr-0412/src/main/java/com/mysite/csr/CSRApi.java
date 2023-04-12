package com.mysite.csr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CSRApi {
	
	public String psocCSR(String imgFile) {
		String clientId = "xp9j4ofc9u";             // Application Client ID";
        String clientSecret = "G7xBEXsY8xPbiyPPJyhAXOQXgvUj9T5aK5Qvt6Tu";     // Application Client Secret";
        
        StringBuffer response = null;
        try {
//            String imgFile = "샘플_1.wav";
            File voiceFile = new File(imgFile);

            String language = "Kor";        // 언어 코드 ( Kor, Jpn, Eng, Chn )
            String apiURL = "https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=" + language;	// 요청 url 설정
            URL url = new URL(apiURL);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();	// 네이버 API 연결 객체 생성
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/octet-stream");	// 헤더 설정
            conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);	// 헤더 설정
            conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);	// 헤더 설정

            OutputStream outputStream = conn.getOutputStream();	// 네이버 API 를 이용해 정보를 전송할 송신 객체 생성
            FileInputStream inputStream = new FileInputStream(voiceFile);	// 음성 파일을 읽기 위한 객체 생성
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {	// 음성파일을 읽어서 buffer에 저장
                outputStream.write(buffer, 0, bytesRead);	// buffer에 저장된 파일의 내용을 네이버 API에게 전송
            }
            outputStream.flush();
            inputStream.close();
            BufferedReader br = null;
            int responseCode = conn.getResponseCode();	// 요청에 대한 응답 코드를 구한다
            if(responseCode == 200) { // 정상 호출
            	
            	// conn.getInputStream() : 네이버 API 요청에 대한 응답 결과를 수신할 수신 객체 생성
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));	
                
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }
            String inputLine;

            if(br != null) {
                response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {	// br.readLine() : 응답 결과 수신
                    response.append(inputLine);	// 수신할 내용을 response에 저장
                }
                br.close();
                System.out.println(response.toString());
            } else {
                System.out.println("error !!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return response.toString();
	}
	
}
