package com.soap.consumer.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.soap.consumer.calculator.Add;
import com.soap.consumer.calculator.AddResponse;



@Component

public class SoapClient {
	
	Logger log = LoggerFactory.getLogger(SoapClient.class);
	@Autowired
	private Jaxb2Marshaller marshaller;

	private WebServiceTemplate template;

	public AddResponse getAddResult(Add request) {
		template = new WebServiceTemplate(marshaller);
		AddResponse value = (AddResponse) template.marshalSendAndReceive("http://www.dneonline.com/calculator.asmx?wsdl",
				request);
		log.info("value : "+ value);
		log.info("value result : "+ value.getAddResult());

		return value;
	}

}
