package com.tcl.tclempservice;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduleDemo {

	@Scheduled(fixedDelay = 2500)
	public void wish() {

		System.out.println("Good morning");

	}
	
	@Scheduled(cron = "1 * * * * ?")
	public void wishDaily() {
	
		System.out.println("Good afternoon");
		
	}

}
