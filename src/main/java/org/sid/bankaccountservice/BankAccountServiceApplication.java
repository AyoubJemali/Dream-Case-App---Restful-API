package org.sid.bankaccountservice;


import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args)	 {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository){
		return args -> {
			for (int i = 0; i < 10; i++) {
				BankAccount bankAccount=BankAccount.builder()
						.caseId(UUID.randomUUID().toString())
						.creationDate(LocalDateTime.now())
						.lastUpdateDate(LocalDateTime.now())
						.title("this the title")
						.description("descrption")
						.build();
				bankAccountRepository.save(bankAccount);
			}
		};
	}
}
