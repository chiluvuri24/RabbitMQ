package com.example.RabitMq_HelloWorld.exchanges.topic;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class TopicPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		String name = "Message for Mobile and AC Queue";
		
		channel.basicPublish("Topic-Exchange", "tv.mobile.ac", null, name.getBytes());
		
		channel.close();
		connection.close();

	}

}
