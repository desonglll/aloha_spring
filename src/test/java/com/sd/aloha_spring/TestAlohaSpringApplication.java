package com.sd.aloha_spring;

import org.springframework.boot.SpringApplication;

public class TestAlohaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.from(AlohaSpringApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
