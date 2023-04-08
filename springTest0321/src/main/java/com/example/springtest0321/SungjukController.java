package com.example.springtest0321;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SungjukController {
	SungjukServiceImpl sungjukServiceImpl;
	
	public SungjukController(SungjukServiceImpl sungjukServiceImpl) {
		this.sungjukServiceImpl = sungjukServiceImpl;
	}

	//@RequestMapping(value="/getSungjuklist", method=RequestMethod.GET)
	@GetMapping("/getSungjuklist")
	ArrayList<SungjukVO> getSungjukList() {
		ArrayList<SungjukVO> sungjuklist = sungjukServiceImpl.getSungjukList();
		return sungjuklist;
	}
	
	//@RequestMapping(value="/insertSungjuk", method=RequestMethod.POST)
	@PostMapping("insertSungjuk")
	public int insertSungjuk(SungjukVO sungjuk) {
		//System.out.println("insertSungjuk1 :" + sungjuk);
		int res = sungjukServiceImpl.insertSungjuk(sungjuk);
		return res;
	}
	
	@GetMapping("selectSungjuk")
	public SungjukVO selectSungjuk(@RequestParam String hakbun) {
		//System.out.println("selectSungjuk1 :" + hakbun);
		SungjukVO vo  = sungjukServiceImpl.selectSungjuk(hakbun);
		return vo;
	}
	
	//-----------------------------
	
	@GetMapping("/getSungjukData")
	public HashMap<String, String> getSungjukData(String hakbun) {
		HashMap<String, String> vo = sungjukServiceImpl.getSungjukData(hakbun);
		return vo;
	}
	
	@GetMapping("/getSungjukData2")
	public ArrayList<HashMap<String,String>> getSungjukData2(SungjukVO sungjuk) {
		ArrayList<HashMap<String,String>> vo = sungjukServiceImpl.getSungjukData2();
		return vo;
	}
	
	//-----------------------------
	
	@PostMapping("/updateSungjuk")
	public int updateSungjuk(SungjukVO sungjuk) {
		//System.out.println("updateSungjuk1 :" + sungjuk);
		int res = sungjukServiceImpl.updateSungjuk(sungjuk);
		return res;
	}
	
	@PostMapping("/deleteSungjuk")
	public int deleteSungjuk(String hakbun) {
		//System.out.println("deleteSungjuk1 :" + hakbun);
		int res = sungjukServiceImpl.deleteSungjuk(hakbun);
		return res;
	}
	
	@GetMapping("/countSungjuk")
	public int countSungjuk() {
		int res = sungjukServiceImpl.countSungjuk();
		return res;
	}
	
}
