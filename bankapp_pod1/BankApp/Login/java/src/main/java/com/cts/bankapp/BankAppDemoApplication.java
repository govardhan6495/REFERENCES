package com.cts.bankapp;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
//@ComponentScan({"com.cts.bankapp.controller"})
public class BankAppDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAppDemoApplication.class, args);
	}
	
	

}
