package com.mysite.sbb.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
	// Optional : null 이 올 수 있는 값을 감싸는 Wrapper 클래스
	Optional<SiteUser> findByusername(String username);
}
