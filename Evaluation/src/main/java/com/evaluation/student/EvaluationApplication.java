package com.evaluation.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;





@ComponentScan("com.evaluation.*")  
@SpringBootApplication
public class EvaluationApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EvaluationApplication.class, args);
	}
	


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		

	}

}
