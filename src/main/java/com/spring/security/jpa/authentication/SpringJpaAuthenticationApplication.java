package com.spring.security.jpa.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = {SpringJpaAuthorityRepository.class, SpringJpaUserRepository.class})
@SpringBootApplication
public class SpringJpaAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaAuthenticationApplication.class, args);
	}

}
