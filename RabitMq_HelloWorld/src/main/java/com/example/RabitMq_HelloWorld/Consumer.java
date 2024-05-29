package com.example.RabitMq_HelloWorld;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Consumer {
	
	public static void main(String[] args) {
		
		ConnectionFactory factory = new ConnectionFactory();
		
		try {
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			
			DeliverCallback deliverCallback = (consumerTag,delivery)->{
				String message = new String(delivery.getBody());
				
				
				
				System.out.println(" Message Received :::"+message);
				
				JSONObject jsonObject = new JSONObject(message);
				
				System.out.println(" Datatatta"+jsonObject.get("query"));
			};
			
			
			channel.basicConsume("Queue-1", true,deliverCallback, consumerTag -> {});
			
			
		} catch (IOException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
