package com.mysite.springtest0301;


import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface SungjukMapper {
	public ArrayList<SungjukVO> getSungjukList();
	public ArrayList<HashMap<String, String>> getSungjukList2();
	public ArrayList<SungjukDTO> getSungjukList3();
	public SungjukVO getSungjuk(@Param("hakbun") String hakbun);
	public SungjukVO getSungjuk2(HashMap<String, String> map); // 여러 개의 파라메터를 전달 받기위해 HashMap 사용
	public HashMap<String, String> getSungjukData1(@Param("hakbun") String hakbun);
	public SungjukDTO getSungjukData2(@Param("hakbun") String hakbun);
	public int insertSungjuk(SungjukVO sungjuk);
	public int updateSungjuk(SungjukVO sungjuk);
	public int deleteSungjuk(@Param("hakbun") String hakbun);
	public int countSungjuk();
}
