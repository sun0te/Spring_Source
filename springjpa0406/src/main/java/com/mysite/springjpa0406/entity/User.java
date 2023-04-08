package com.mysite.springjpa0406.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// 해당 클래스가 엔티티 클래스임을 나타냄. 클래스 하나당 하나의 테이블이 만들어짐.
// 클래스 이름과 테이블 이름이 동일하게 맵핑된다.
// 만약 클래스의 이름과 다른 테이블 이름을 사용하고 싶다면 @Table 이노테이션을 사용하여 테이블 이름을 변경할 수 있다.
// 예 : @Table(name = "Usertbl")
@Entity
public class User {
	
	@Id //기본키 설정(필수)
	
	// @Column : 컬럼을 맵핑할 때 사용. name, nullable = false, length 설정에 사용
	// @NotNull : nullable = false 와 비슷한 어노테이션, JPA가 만든 엔티티의 필드 값이 null로 채워지는 순간에 null 체크
	// @Column(nullable=false) : 데이터베이스 쪽으로 SQL 쿼리가 도착한 순간 null 체크 (@NotNull 보다 늦게 체크)
	
	@Column(name="userid", length=8)
	private String id;
	
	@Column(length=10)
	private String name;
	
	private int birth;
	
	@Column(length=3)
	private String addr;
	
	@Column(length=13)
	private String mobile;
	
	private int height;	
	
}
