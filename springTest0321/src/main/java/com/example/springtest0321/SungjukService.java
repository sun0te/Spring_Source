package com.example.springtest0321;

import java.util.ArrayList;
import java.util.HashMap;

public interface SungjukService {
	ArrayList<SungjukVO> getSungjukList(); 
	int insertSungjuk(SungjukVO sungjuk); 
	
	public HashMap<String, String> getSungjukData(String hakbun);
	public ArrayList<HashMap<String,String>> getSungjukData2();
	
	public SungjukVO selectSungjuk(String hakbun);
	public int updateSungjuk(SungjukVO sungjuk); 
	public int deleteSungjuk(String hakbun); 
	public int countSungjuk();
	
}
