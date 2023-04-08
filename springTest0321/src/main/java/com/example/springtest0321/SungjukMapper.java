package com.example.springtest0321;

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
	
	@Select("select * from sungjuk order by hakbun")
	public ArrayList<SungjukVO> getSungjukList(); 

	@Select("select * from sungjuk where hakbun=#{hakbun}")
	public SungjukVO selectSungjuk(@Param("hakbun") String hakbun); 
	
	//-----------------------------
	
	@Select("select hakbun, irum, grade from sungjuk where hakbun=#{hakbun}")
	public HashMap<String, String> getSungjukData(@Param("hakbun") String hakbun); 
	
	@Select("select hakbun, irum, grade from sungjuk order by hakbun")
	public ArrayList<HashMap<String,String>> getSungjukData2();
	
	//-----------------------------
	
	@Insert("insert into sungjuk values(#{hakbun}, #{irum}, #{kor}, #{eng}, #{math}, #{total}, #{avg}, #{grade} )")
	public int insertSungjuk(SungjukVO sungjuk); 

	@Update("update sungjuk set kor = #{kor}, eng = #{eng}, math = #{math}, total = #{total}, avg = #{avg}, grade = #{grade} where hakbun = #{hakbun}")
	public int updateSungjuk(SungjukVO sungjuk); 

	@Delete("delete from sungjuk where hakbun = #{hakbun}")
	public int deleteSungjuk(@Param("hakbun") String hakbun); 

	@Select("select count(*) from sungjuk")
	public int countSungjuk();
}
