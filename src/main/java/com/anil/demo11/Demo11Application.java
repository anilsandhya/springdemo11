package com.anil.demo11;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.anil.demo11.domainobject.fileupload.IStorage;
import com.anil.demo11.domainobject.fileupload.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Demo11Application {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(Demo11Application.class, args);
		
		System.out.println("Hello World! from Demo11 Main Function.");
		System.out.println("#### Number of Beans : " + ctx.getBeanDefinitionCount());
		
		var names = ctx.getBeanDefinitionNames();
		Arrays.sort(names);
		Arrays.asList(names).forEach(System.out::println);
	}

	@Bean
	CommandLineRunner init(IStorage storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
