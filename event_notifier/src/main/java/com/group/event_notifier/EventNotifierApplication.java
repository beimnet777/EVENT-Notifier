package com.group.event_notifier;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventNotifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventNotifierApplication.class, args);
	}

	@Bean
   public CommandLineRunner dataLoader(HostRepository repo) {
       return args -> {
          repo.save(new Host("qwert","kasech@gmail.com","kasu","1234","2345",true,"dwfef"));
			 };

}
}
