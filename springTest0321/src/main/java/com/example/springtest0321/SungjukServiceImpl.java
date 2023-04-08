package com.example.springtest0321;

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
	
//-----------------------------
	
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

//-----------------------------
	
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
