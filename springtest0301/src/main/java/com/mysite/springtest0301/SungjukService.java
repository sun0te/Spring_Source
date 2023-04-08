package com.mysite.springtest0301;


import java.util.ArrayList;
import java.util.HashMap;

public interface SungjukService {
	public ArrayList<SungjukVO> getSungjukList();
	public ArrayList<HashMap<String, String>> getSungjukList2();
	public ArrayList<SungjukDTO> getSungjukList3();
	public SungjukVO getSungjuk(String hakbun);
//	public SungjukVO getSungjuk2(HashMap<String, String> map);
	public SungjukVO getSungjuk2(String hakbun, String irum);
	public HashMap<String, String> getSungjukData1(String hakbun);
	public SungjukDTO getSungjukData2(String hakbun);
	public int insertSungjuk(SungjukVO sungjuk);
	public int updateSungjuk(SungjukVO sungjuk);
	public int deleteSungjuk(String hakbun);
	public int countSungjuk();
}
