package com.soap.consumer.endpoint;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soap.consumer.client.SOAPConnector;
import com.soap.consumer.tempConvert.CelsiusToFahrenheit;
import com.soap.consumer.tempConvert.CelsiusToFahrenheitResponse;
import com.soap.consumer.tempConvert.FahrenheitToCelsius;
import com.soap.consumer.tempConvert.FahrenheitToCelsiusResponse;

@RestController
public class SoapConsumerEndpoint {
	@Autowired 
	private SOAPConnector service;
	
	@PostMapping("/consumer/soap")
	public FahrenheitToCelsiusResponse consumeSoapWebService(@RequestBody FahrenheitToCelsius request) {
		FahrenheitToCelsiusResponse response = (FahrenheitToCelsiusResponse) service.callWebService("https://www.w3schools.com/xml/FahrenheitToCelsius",request);
        System.out.println("FahrenheitResult : " + response.getFahrenheitToCelsiusResult().toString());
        return response;		
	}
	
    @PostMapping("/getfahrenheight")
    public CelsiusToFahrenheitResponse getFahrenheight(@RequestBody CelsiusToFahrenheit req){
        System.out.println("input " + req.getCelsius());
        CelsiusToFahrenheitResponse response = (CelsiusToFahrenheitResponse) service.callWebService("https://www.w3schools.com/xml/CelsiusToFahrenheit",req);
        System.out.println("Got Response As below ========= : ");
        System.out.println("FahrenheitResult : " + response.getCelsiusToFahrenheitResult().toString());
        return response;

    }

}
