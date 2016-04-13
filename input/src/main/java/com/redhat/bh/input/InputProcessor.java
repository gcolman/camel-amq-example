package com.redhat.bh.input;

import java.util.Map;

import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

@Singleton
@Named("inputProcessor")
public class InputProcessor {

	public void processor(Exchange exchange) {
		Message in = exchange.getIn();
		
		StringBuilder builder = new StringBuilder();
		
		for (Map.Entry<String, Object> header : in.getHeaders().entrySet())
		{
			if (header.getValue() instanceof String)
			{
				builder.append(header.getValue());
				builder.append(System.lineSeparator());
			}
		}
		
		in.setBody(builder.toString());
		
		exchange.setIn(in);
	}

}
