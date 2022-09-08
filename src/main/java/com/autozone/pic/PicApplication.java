package com.autozone.pic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages = {"com.autozone"})
@Component("com.autozone")
public class PicApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicApplication.class, args);
	}

}
