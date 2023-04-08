package com.mysite.springtest0301;


import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class SungjukServiceImpl  implements SungjukService {
	SungjukMapper mapper;
	
	public SungjukServiceImpl(SungjukMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public ArrayList<SungjukVO> getSungjukList(){
		ArrayList<SungjukVO> list = mapper.getSungjukList();
		return list;
	}
	
	@Override
	public ArrayList<HashMap<String, String>> getSungjukList2() {
		ArrayList<HashMap<String, String>> list = mapper.getSungjukList2();
		return list;
	}
	
	@Override
	public ArrayList<SungjukDTO> getSungjukList3(){
		ArrayList<SungjukDTO> list = mapper.getSungjukList3();
		return list;
	}
	
	@Override
	public SungjukVO getSungjuk(String hakbun) {
		SungjukVO vo = mapper.getSungjuk(hakbun);
		return vo;
	}
	
//	@Override
//	public SungjukVO getSungjuk2(HashMap<String, String> map) {
//		SungjukVO vo = mapper.getSungjuk2(map);
//		return vo;
//	}
	@Override
	public SungjukVO getSungjuk2(String hakbun, String irum) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("hakbun",  hakbun);
		map.put("irum",  irum);
		SungjukVO vo = mapper.getSungjuk2(map);
		return vo;
	}
	
	@Override
	public HashMap<String, String> getSungjukData1(String hakbun) {
		HashMap<String, String> vo = mapper.getSungjukData1(hakbun);
		return vo;
	}
	
	@Override
	public SungjukDTO getSungjukData2(String hakbun) {
		SungjukDTO vo = mapper.getSungjukData2(hakbun);
		return vo;
	}
	
	@Override
	public int insertSungjuk(SungjukVO sungjuk) {
		sungjuk.processSungjuk();
		System.out.println("insertSungjuk2 : " + sungjuk);
		int res = mapper.insertSungjuk(sungjuk);
		return res;
	}
	
	@Override
	public int updateSungjuk(SungjukVO sungjuk) {
		sungjuk.processSungjuk();
		System.out.println("updateSungjuk2 : " + sungjuk);
		int res = mapper.updateSungjuk(sungjuk);
		return res;
	}
	
	@Override
	public int deleteSungjuk(String hakbun) {
		int res = mapper.deleteSungjuk(hakbun);
		return res;
	}
	
	@Override
	public int countSungjuk() {
		int res = mapper.countSungjuk();
		return res;
	}
	
}
