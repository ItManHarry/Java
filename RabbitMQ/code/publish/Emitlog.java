package com.esb.queue.mq.rabbit.publish;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Emitlog {

	public static void main(String[] args){
		//创建连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		try {
			//创建连接
			Connection connection = factory.newConnection();
			//创建连接频道
			Channel channel = connection.createChannel();
			//声明交换器
			channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
			//分发消息
			String message = "";
			for(int i = 0; i < 5; i++){
				message = "ExchangeMessage-"+i+"-save-to-file2";
				channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
				System.out.println("RabbitMQ Server has sent the message(" + message + ")");
			}
			channel.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured...");
		}
	}
	
	//交换器
	private static final String EXCHANGE_NAME = "logs";
	//服务器地址
	private static final String HOST = "localhost";
}
