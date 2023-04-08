package com.mysite.testspring0322;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class SungjukServiceImpl implements SungjukService {

	SungjukMapper mapper;
	
	public SungjukServiceImpl (SungjukMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public ArrayList<SungjukVO> getSungjukList() {
		// TODO Auto-generated method stub
		ArrayList<SungjukVO> sungjuklist = mapper.getSungjukList();
		return sungjuklist;
	}

	@Override
	public int insertSungjuk(SungjukVO sungjuk) {
		sungjuk.ProcessSungjuk(); 
		//System.out.println("insertSungjuk : " + sungjuk);
		int res = mapper.insertSungjuk(sungjuk);
		return res;
	}
	
	//============================================================
	
//	@Override
//	public SungjukVO selectSungjuk2(HashMap<String, String> map) {
//		SungjukVO vo = mapper.selectSungjuk2(map);
//		return vo;
//	}
	
	@Override
	public SungjukVO selectSungjuk2(String hakbun, String irum) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("hakbun",  hakbun);
		map.put("irum",  irum);
		SungjukVO vo = mapper.selectSungjuk2(map);
		return vo;
	}
	
	@Override
	public HashMap<String, String> getSungjukData(String hakbun) {
		HashMap<String, String> vo = mapper.getSungjukData(hakbun);
		return vo;
	}
	
	@Override
	public ArrayList<HashMap<String,String>> getSungjukData2(){
		ArrayList<HashMap<String,String>> sungjuklist = mapper.getSungjukData2();
		return sungjuklist;
	}
	
	@Override
	public ArrayList<SungjukDTO> getSungjukList3() {
		ArrayList<SungjukDTO> sungjuklist = mapper.getSungjukList3();
		return sungjuklist;
	}
	
	@Override
	public SungjukDTO getSungjukData3(String hakbun) {
		SungjukDTO vo = mapper.getSungjukData3(hakbun);
		return vo;
	}

	//============================================================
	
	@Override
	public SungjukVO selectSungjuk(String hakbun) {
		SungjukVO vo = mapper.selectSungjuk(hakbun);
		return vo;
	}

	@Override
	public int updateSungjuk(SungjukVO sungjuk) { //학번 이름 국어 영어 수학
		sungjuk.ProcessSungjuk(); //총점, 평균 등급 계산
		int res = mapper.updateSungjuk(sungjuk);
		return  res;
	}

	@Override
	public int deleteSungjuk(String hakbun) {
		int res = mapper.deleteSungjuk(hakbun);
		return  res;
	}

	@Override
	public int countSungjuk() {
		int res = mapper.countSungjuk();
		return  res;
	}

}
