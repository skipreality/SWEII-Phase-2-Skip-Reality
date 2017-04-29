package com.swe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MainController {

	public static void main(String[] args) {
		
		SpringApplication.run(MainController.class, args);
		
	}
	
	@Component
	public class CustomizationBean implements EmbeddedServletContainerCustomizer {
	    @Override
	    public void customize(ConfigurableEmbeddedServletContainer container) {
	        container.setPort(8000);
	        // Use port of your choice that is available
	    }
	}
	
	

}
