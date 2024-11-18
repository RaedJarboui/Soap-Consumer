package com.soap.consumer.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.soap.consumer.tempConvert.FahrenheitToCelsius;
import com.soap.consumer.tempConvert.FahrenheitToCelsiusResponse;





	public class SOAPConnector extends WebServiceGatewaySupport {
		
		Logger log = LoggerFactory.getLogger(SOAPConnector.class);
		@Autowired
		private Jaxb2Marshaller marshaller;

		private WebServiceTemplate template;
	

	    public Object callWebService(String action, Object request){
	        //return getWebServiceTemplate().marshalSendAndReceive(url, request);
	        return getWebServiceTemplate().marshalSendAndReceive(request,new SoapActionCallback(action));
	    }

//	public FahrenheitToCelsiusResponse getFahrenheitToCelsiusResult(FahrenheitToCelsius request,String action) {
//		template = new WebServiceTemplate(marshaller);
//		FahrenheitToCelsiusResponse value = (FahrenheitToCelsiusResponse) template.marshalSendAndReceive("https://www.w3schools.com/xml/tempconvert.asmx?wsdl",
//				request);
//		log.info("value : "+ value);
//		log.info("value result : "+ value.getFahrenheitToCelsiusResult());
//
//		return value;
//	}

}
