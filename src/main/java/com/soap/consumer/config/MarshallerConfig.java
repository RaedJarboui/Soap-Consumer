package com.soap.consumer.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.soap.consumer.client.SOAPConnector;
@Configuration
public class MarshallerConfig {
	
	
	//transform objects to xml using jaxb Marshaller
	 @Bean
	    public Jaxb2Marshaller marshaller() {
	        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
	       
	        marshaller.setContextPath("com.soap.consumer.tempConvert");	// this is the package name specified in the <generatePackage> specified in pom.xml
	        return marshaller;
	    }

	    @Bean
	    public SOAPConnector soapConnector(Jaxb2Marshaller marshaller) {
	        SOAPConnector client = new SOAPConnector();
	        client.setDefaultUri("https://www.w3schools.com/xml/tempconvert.asmx?wsdl");
	        client.setMarshaller(marshaller);
	        client.setUnmarshaller(marshaller);
	        return client;
	    }
	
	
}
