package com.soap.consumer.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soap.consumer.calculator.Add;
import com.soap.consumer.calculator.AddResponse;
import com.soap.consumer.client.SoapClient;

@RestController
public class SoapConsumerEndpoint {
	@Autowired 
	private SoapClient service;
	
	@PostMapping("/consumer/soap")
	public AddResponse consumeSoapWebService(@RequestBody Add addRequest) {
		return service.getAddResult(addRequest);
		
	}

}
