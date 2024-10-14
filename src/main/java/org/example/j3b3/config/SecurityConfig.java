package org.example.j3b3.config;

import org.example.j3b3.service.CustomOAuth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    // CustomOAuth2UserService를 주입받는 생성자
    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService) {
        this.customOAuth2UserService = customOAuth2UserService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 1. CSRF 보호 비활성화 (주로 REST API의 경우 비활성화가 적합)
        http
                .csrf((csrf) -> csrf.disable());

        // 2. Form 로그인 비활성화 (기본 제공되는 로그인 폼을 사용하지 않음)
        http
                .formLogin((login) -> login.disable());

        // 3. HTTP Basic 인증 비활성화 (기본 제공되는 HTTP Basic 인증 사용 안 함)
        http
                .httpBasic((basic) -> basic.disable());

        // 4. OAuth2 로그인 설정: 사용자 정보를 CustomOAuth2UserService에서 처리
        http
                .oauth2Login((oauth2) -> oauth2
                        .userInfoEndpoint((userInfoEndpointConfig -> userInfoEndpointConfig
                                .userService(customOAuth2UserService))));

        // 5. 경로별 접근 권한 설정
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/", "/oauth2/**", "/login/**").permitAll()  // 특정 경로는 모든 사용자가 접근 가능
                        .anyRequest().authenticated());  // 그 외의 모든 요청은 인증 필요

        // 6. 세션 관리 설정: STATELESS (세션을 사용하지 않음)
        http
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));  // JWT 같은 토큰 인증을 사용할 때 적합

        // SecurityFilterChain 반환
        return http.build();
    }
}
