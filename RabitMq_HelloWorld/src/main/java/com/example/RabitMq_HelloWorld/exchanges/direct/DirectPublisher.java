package com.example.RabitMq_HelloWorld.exchanges.direct;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class DirectPublisher {
	
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		String name = "this need to go to ac Queue";
		
		channel.basicPublish("Direct-Exchange", "ac", null, name.getBytes());
		
		channel.close();
		connection.close();
		
	}

}
