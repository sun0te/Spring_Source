package com.mysite.springjpa0406.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.springjpa0406.entity.Buy;

public interface BuyRepository extends JpaRepository<Buy, Integer> {
	@Modifying
	@Transactional
	@Query(value="update buy set prodname = :prodname, groupname = :groupname, price = :price, amount = :amount where num = :num", nativeQuery=true)
	void updateBuy(int num, String prodname, String groupname, int price, int amount);
}
