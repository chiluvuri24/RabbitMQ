package com.example.RabitMq_HelloWorld.exchanges.direct;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class DirectConsumer {
  public static void main(String[] args) throws IOException, TimeoutException {
	  ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody());
			System.out.println(" Message Received :::"+message);
		};
		
		channel.basicConsume("AC", true, deliverCallback, consumerTag -> {});
		
		
		
  }
  
}
