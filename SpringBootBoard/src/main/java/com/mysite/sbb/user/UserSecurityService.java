package com.mysite.sbb.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
// 스프링 시큐리티에 등록하여 사용할 UserSecutiryService는 스프링 시큐리티가 제공하는 UserDetailsService 인터페이스를 상속해서 구현해야 한다
public class UserSecurityService implements UserDetailsService {

	private final UserRepository userRepository;
	
	// 스프링 시큐리티는 loadUserByUsername 메서드에 의해 리턴된 User 객체의 비밀번호가
	// 화면으로부터 입력받은 비밀번호화 일치하는지를 검사하는 로직을 내부적으로 가지고 있다.
	// 사용자 명으로 비밀번호를 조회하여 리턴하는 메소드
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<SiteUser> _siteUser = this.userRepository.findByusername(username);
		if(_siteUser.isEmpty()) {
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
		}
		SiteUser siteUser = _siteUser.get();
		// GranteAuthority : ID, Password 기반 인증에서 UserDetailService를 통해서 조회
		List<GrantedAuthority> authorities = new ArrayList<>();
		if("admin".equals(username)) {	// 사용자명이 "admin"인 경우에는 ADMIN 권한을 부여
			// SimpleGranteAuthority : GrantedAuthority 를 상속받아 구현된 클래스, 권한만 저장
			authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
		} else {	// 그 이외의 경우에는 USER 권한을 부여
			authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
		
		} 
		return new User(siteUser.getUsername(), siteUser.getPassword(), authorities);
		
	}

}
