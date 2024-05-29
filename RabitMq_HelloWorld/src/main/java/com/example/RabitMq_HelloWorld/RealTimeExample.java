package com.example.RabitMq_HelloWorld;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RealTimeExample {
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		JSONObject json = new JSONObject();
		json.put("fromDate", "01-Jun-2024");
		json.put("toDate",   "30-Jun-2024");
		json.put("name", "sara");
		json.put("query", "select * from data");
		
		channel.basicPublish("", "Queue-1", null, json.toString().getBytes());
		
		channel.close();
		connection.close();
		
	}

}
