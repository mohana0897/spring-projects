package com.tcl.tclempservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

public class ServletInitializer extends SpringBootServletInitializer {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TclempserviceApplication.class);
	}

}
