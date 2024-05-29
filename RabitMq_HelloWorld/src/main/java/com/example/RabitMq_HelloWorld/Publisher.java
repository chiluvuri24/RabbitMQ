package com.example.RabitMq_HelloWorld;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Publisher {
   
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		
		ConnectionFactory factory = new ConnectionFactory();
		
		Connection connection = factory.newConnection();
		
		Channel channel = connection.createChannel();
		
		String[] messages = {"first","second","third","fourth"};
		
		for(String message : messages) {			
			channel.basicPublish("", "Queue-1", false, null, message.getBytes());
		}
		
		
		channel.close();
		connection.close();
		
		
		
	}
}
