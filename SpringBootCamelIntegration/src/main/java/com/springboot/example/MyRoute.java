package com.springboot.example;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

	/**
	 * Camel starter will auto wire camel context and auto detect all the camel routes in application.
	 * Here, Route is defined
	 */
	
	@Override
	public void configure() throws Exception {

//		from("direct:firstRoute")
//			.log("message body: ${body}");
		
		//from the file endpoint to destination file endpoint
//		from("file:D://HIPPA?noop=true")
//		.to("file:D://IIB_materials");
		
		//from resource to print the xml
		from("direct:firstRoute")
		.to("file:src/main/resources/orderxmlroute/");
	}

}
