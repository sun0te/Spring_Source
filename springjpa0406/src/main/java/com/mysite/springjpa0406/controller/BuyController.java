package com.mysite.springjpa0406.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.springjpa0406.entity.Buy;
import com.mysite.springjpa0406.service.BuyServiceImpl;

@RestController
@RequestMapping("/buy")
public class BuyController {
	
	private BuyServiceImpl buyServiceImpl;
	
	public BuyController(BuyServiceImpl buyServiceImpl) {
		super();
		this.buyServiceImpl = buyServiceImpl;
	}
	
	@RequestMapping("/insertBuy")
	public void insertBuy(@RequestParam(value="userid") String userid, Buy buy) {
		buyServiceImpl.insertBuy(userid, buy);
	}
	
	@RequestMapping("/listBuy")
	public List<Buy> listBuy() {
		return (List<Buy>)buyServiceImpl.listBuy();
	}
	
	@RequestMapping("/updateBuy")
	public void updateBuy(int num, String prodname, String groupname, int price, int amount) {
		buyServiceImpl.updateBuy(num, prodname, groupname, price, amount);
	}
	
	@RequestMapping("/deleteBuy")
	public void deleteBuy(int num) {
		buyServiceImpl.deleteBuy(num);
	}
	
	
}
