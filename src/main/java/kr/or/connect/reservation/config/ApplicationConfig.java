package kr.or.connect.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DBConfig.class})
@ComponentScan(basePackages = {
		"kr.or.connect.reservation.dao",
		"kr.or.connect.reservation.service",
		"kr.or.connect.reservation.security",
		"kr.or.connect.reservation.mapper"
		})
public class ApplicationConfig {

}
