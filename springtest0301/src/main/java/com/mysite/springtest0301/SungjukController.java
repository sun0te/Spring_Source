package com.mysite.springtest0301;


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
	
	@GetMapping("/getSungjukList")
//	@RequestMapping(value="/getSungjukList", method=RequestMethod.GET)
	public ArrayList<SungjukVO> getSungjukList() {
		ArrayList<SungjukVO> list = sungjukServiceImpl.getSungjukList();
		return list;
	}
	
	@GetMapping("/getSungjukList2")
	public ArrayList<HashMap<String, String>> getSungjukList2() {
		ArrayList<HashMap<String, String>> list = sungjukServiceImpl.getSungjukList2();
		return list;
	}
	
	@GetMapping("/getSungjukList3")
	public ArrayList<SungjukDTO> getSungjukList3() {
		ArrayList<SungjukDTO> list = sungjukServiceImpl.getSungjukList3();
		return list;
	}
	
	@GetMapping("/getSungjuk")
	public SungjukVO getSungjuk(@RequestParam("hakbun") String hakbun) {
		SungjukVO vo = sungjukServiceImpl.getSungjuk(hakbun);
		return vo;
	}
	
//	@GetMapping("/getSungjuk2")
//	public SungjukVO getSungjuk2(@RequestParam("hakbun") String hakbun, @RequestParam("irum") String irum) {
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("hakbun",  hakbun);
//		map.put("irum",  irum);
//		SungjukVO vo = sungjukServiceImpl.getSungjuk2(map);
//		return vo;
//	}
	@GetMapping("/getSungjuk2")
	public SungjukVO getSungjuk2(@RequestParam("hakbun") String hakbun, @RequestParam("irum") String irum) {
		SungjukVO vo = sungjukServiceImpl.getSungjuk2(hakbun, irum);
		return vo;
	}
	
	@GetMapping("/getSungjukData1")
	public HashMap<String, String> getSungjukData1(String hakbun) {
		HashMap<String, String> vo = sungjukServiceImpl.getSungjukData1(hakbun);
		return vo;
	}
	
	@GetMapping("/getSungjukData2")
	public SungjukDTO getSungjukData2(String hakbun) {
		SungjukDTO vo = sungjukServiceImpl.getSungjukData2(hakbun);
		return vo;
	}

	@PostMapping("/insertSungjuk")
//	@RequestMapping(value="/insertSungjuk", method=RequestMethod.POST)
	public int insertSungjuk(SungjukVO sungjuk) {
		System.out.println("insertSungjuk1 : " + sungjuk);
		int res = sungjukServiceImpl.insertSungjuk(sungjuk);
		return res;
	}
	
	@PostMapping("/updateSungjuk")
	public int updateSungjuk(SungjukVO sungjuk) {
		System.out.println("updateSungjuk1 : " + sungjuk);
		int res = sungjukServiceImpl.updateSungjuk(sungjuk);
		return res;
	}
	
	@GetMapping("/deleteSungjuk")
	public int deleteSungjuk(@RequestParam("hakbun") String hakbun) {
		int res = sungjukServiceImpl.deleteSungjuk(hakbun);
		return res;
	}
	
	@GetMapping("/countSungjuk")
	public int countSungjuk() {
		int res = sungjukServiceImpl.countSungjuk();
		return res;
	}
}
