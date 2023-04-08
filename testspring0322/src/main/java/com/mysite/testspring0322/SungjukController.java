package com.mysite.testspring0322;

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
	
	//============================================================
	
//	@GetMapping("selectSungjuk2")
//	public SungjukVO selectSungjuk2(@RequestParam("hakbun") String hakbun, @RequestParam("irum") String irum) {
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("hakbun", hakbun);
//		map.put("irum", irum);
//		SungjukVO vo  = sungjukServiceImpl.selectSungjuk2(map);
//		return vo;
//	}
	
	@GetMapping("selectSungjuk2")
	public SungjukVO selectSungjuk2(@RequestParam("hakbun") String hakbun, @RequestParam("irum") String irum) {
		SungjukVO vo  = sungjukServiceImpl.selectSungjuk2(hakbun, irum);
		return vo;
	}
	
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
	
	
	@GetMapping("/getSungjukList3")
	ArrayList<SungjukDTO> getSungjukList3() {
		ArrayList<SungjukDTO> sungjuklist = sungjukServiceImpl.getSungjukList3();
		return sungjuklist;
	}
	
	@GetMapping("/getSungjukData3")
	public SungjukDTO getSungjukData3(String hakbun) {
		SungjukDTO vo = sungjukServiceImpl.getSungjukData3(hakbun);
		return vo;
	}

	//============================================================
	
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
