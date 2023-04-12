package com.mysite.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration	//스프링의 환경설정 파일임을 의미하는 어노테이션
@EnableWebSecurity	// 모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만드는 어노테이션
public class SecurityConfig {
	@Bean	//아래의 코드로 Bean 객체를 생성
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers(
				new AntPathRequestMatcher("/**")).permitAll()	// 모두 인증되지 않은 요청을 허락한다는 의미
					.and()
						.headers()
						// 사이트의 콘텐츠가 다른 사이트에 포함되지 않도록 하기 위해 X-Frame-Options 헤더값을 사용하여 이를 방지한다.
						// URL 요청 시 X-Frame-Options 헤더값을 sameorigin으로 설정하여 오류가 발생하지 않는다. 
						.addHeaderWriter(new XFrameOptionsHeaderWriter(
								XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
		
					.and()
						.formLogin()
						.loginPage("/user/login")	// 스프링 시큐리티의 로그인 설정을 담당하는 부분, 로그인 페이지 url
						.defaultSuccessUrl("/question/list")	// 로그인 성공 시 이동할 url)
					
					.and()
						.logout()
						.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
						.logoutSuccessUrl("/user/login")
						.invalidateHttpSession(true)
						;
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();	//해싱함수를 이용해서 암호화하는 기능 옮겨진 객체
	}
	
	// UserSecurityService를 스프링 시큐리티에 등록하는 부분
	// AuthenticationManager 빈 생성 시 스프링의 내부 동작으로 인해 위에서 작성한 UserSecurityService와 PasswordEncoder 가 자동으로 설정된다.
	// AuthenticationManager 는 스프링 시큐리티의 인증을 담당
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
}
