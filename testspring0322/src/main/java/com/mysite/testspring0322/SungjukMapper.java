package com.mysite.testspring0322;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper 
public interface SungjukMapper {
	
	public ArrayList<SungjukVO> getSungjukList(); 
	public SungjukVO selectSungjuk(@Param("hakbun") String hakbun); 

	//-----------------------------	
	
	public SungjukVO selectSungjuk2(HashMap<String, String> map); //여러 개의 파라메터를 전달 받기 위해 HashMap 사용
	
	public HashMap<String, String> getSungjukData(@Param("hakbun") String hakbun); 
	public ArrayList<HashMap<String,String>> getSungjukData2();
	
	
	public ArrayList<SungjukDTO> getSungjukList3();
	public SungjukDTO getSungjukData3(@Param("hakbun") String hakbun);
	
	
	//-----------------------------
	public int insertSungjuk(SungjukVO sungjuk); 
	public int updateSungjuk(SungjukVO sungjuk); 
	public int deleteSungjuk(@Param("hakbun") String hakbun); 
	public int countSungjuk();
}
