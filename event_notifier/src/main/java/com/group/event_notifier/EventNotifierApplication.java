package com.group.event_notifier;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.group.event_notifier","controller"})
public class EventNotifierApplication {

	public static void main(String[] args) {
		new File(HostController.folderDirectory).mkdir();
		SpringApplication.run(EventNotifierApplication.class, args);
	}

	// @Bean
  //  public CommandLineRunner dataLoader(HostRepository repo) {
  //      return args -> {
  //         repo.save(new Host("qwert","kasech@gmail.com","kasu","1234","2345",true,"dwfef"));
	// 		 };

}

