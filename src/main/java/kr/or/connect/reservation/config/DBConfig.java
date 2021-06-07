package kr.or.connect.reservation.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DBConfig implements TransactionManagementConfigurer {
	
	// @PropertySource를 통해 properties 파일을 Environment에 로드합니다.
	private final Environment env;
	
	public DBConfig(Environment env) {
		this.env = env;
	}
	
	@Bean
	// dataSource 설정
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		
		return dataSource;
	}
	
	@Bean
	// datasource를 사용해 PlatformTransactionManager 객체를 만듭니다.
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource()); 
	}
	
	@Override
	// 사용자 간의 트랜잭션 처리를 위한 PlatformTransactionManager 설정
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManager();
	}
}
