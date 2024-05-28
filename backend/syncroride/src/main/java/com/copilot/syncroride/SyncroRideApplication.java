package com.copilot.syncroride;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SyncroRideApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyncroRideApplication.class, args);
	}

}
