package com.mysite.springjpa0406.service;

import java.util.List;

import com.mysite.springjpa0406.entity.Buy;

public interface BuyService {
	public Buy insertBuy(String userid, Buy buy);
	public List<Buy> listBuy();
	public Buy getBuy(int num);
	public void updateBuy(int num, String prodname, String groupname, int price, int amount);
	public void deleteBuy(int num);
	
	
}
