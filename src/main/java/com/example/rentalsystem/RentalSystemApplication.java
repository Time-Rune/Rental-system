package com.example.rentalsystem;

import com.example.rentalsystem.controller.Timecounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentalSystemApplication {
	@Autowired
	static private Timecounter timecounter;

	public static void main(String[] args) {
		try {
			timecounter.start();
		}catch (NullPointerException e){
			System.out.println(e);
		}
		SpringApplication.run(RentalSystemApplication.class, args);
	}

}
