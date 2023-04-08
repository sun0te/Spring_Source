package com.mysite.springjpa0406.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Buy {
	
	@Id
	@Column(name="num")
	
	/* 4가지 생성전략
	 * 
	 * IDENTITY : DB가 직접 ID값을 계산하여 넣어주는 방법(Mysql에서 주로 사용. AUTO_INCREMENT) 
	 * SEQUENCE : @SequenceGenerator 를 사용하여 시퀀스를 생성하고 그 것을 사용하게 된다. (오라클에서 주로 사용)
	 * TABLE : 키를 생성하주는 테이블을 하나 생성하여 사용하는 전략, DB의 시퀀스를 흉내내듯이 테이블이 키값을 생성한다.
	 * AUTO : 3가지 전략 중 DB의 방언에 맞추어 적절하게 자동으로 적용해주는 방법
	 */
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//자동으로 id값 설정
	private int id;
	
	// FetchType.EAGER : 즉시 로딩
	// FetchType.LAZY : 지연로딩 - 추천
	@ManyToOne(fetch=FetchType.EAGER)	//ManyToOne : 다 대 일, oneToOne : 일 대 일, OneToMany : 일 대 다
	@JoinColumn(name="userid")	// 외래키. 실제 테이블 생성 시에 userid만 이름으로 컬럼이 만들어짐
	private User user;
	
	private String prodname;
	private String groupname;
	private int price;
	private int amount;
	
}
