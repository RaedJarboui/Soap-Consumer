package com.soap.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.soap.consumer.client.SoapClient;
@Configuration
public class MarshallerConfig {
	
	
	//transform objects to xml using jaxb Marshaller
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan("com.soap.consumer.calculator"); //scan classes from package path and bind them to xml
		return marshaller;
	}
	
	
}
