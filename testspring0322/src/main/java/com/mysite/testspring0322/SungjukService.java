package com.mysite.testspring0322;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

public interface SungjukService {
	ArrayList<SungjukVO> getSungjukList(); 
	int insertSungjuk(SungjukVO sungjuk); 
	
	//============================================================
	
	//public SungjukVO selectSungjuk2(HashMap<String, String> map);
	public SungjukVO selectSungjuk2(String hakbun, String irum);
	
	public HashMap<String, String> getSungjukData(String hakbun);
	public ArrayList<HashMap<String,String>> getSungjukData2();
	
	public ArrayList<SungjukDTO> getSungjukList3();
	public SungjukDTO getSungjukData3(String hakbun);
	
	//============================================================
	
	public SungjukVO selectSungjuk(String hakbun);
	public int updateSungjuk(SungjukVO sungjuk); 
	public int deleteSungjuk(String hakbun); 
	public int countSungjuk();
	
}
