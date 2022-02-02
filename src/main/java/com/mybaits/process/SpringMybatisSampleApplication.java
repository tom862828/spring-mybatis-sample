package com.mybaits.process;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringMybatisSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMybatisSampleApplication.class, args);
	}

}
