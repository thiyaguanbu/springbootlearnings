package com.springboot.example.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamelController {

	
	@Autowired
	ProducerTemplate productTemplate;
	
	@RequestMapping("/")
	public void startCamel() {
		try {
			InputStream tempxml = new FileInputStream("src/main/resources/order.xml");
			//productTemplate.sendBody("direct:firstRoute", "calling Camel starter via springboot rest.. HI");
			productTemplate.sendBody("direct:firstRoute", tempxml);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
