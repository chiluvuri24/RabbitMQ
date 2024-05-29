package com.example.RabitMq_HelloWorld.exchanges.headers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class HeadersProducer {
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		Connection connection = connectionFactory.newConnection();
		
		Channel channel = connection.createChannel();
		
		String message = "To Queues Mobile and TV";
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("item1", "mobile");
		map.put("item2", "television");
		
		
		BasicProperties basicProperties = new BasicProperties();
		
		basicProperties.builder().headers(map).build();
		
		
		channel.basicPublish("Header-Exchange", "", basicProperties, message.getBytes());
		
		channel.close();
		connection.close();
		
	}

}
