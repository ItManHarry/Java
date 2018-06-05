package com.esb.queue.mq.rabbit.routing;
import java.util.Random;
import java.util.UUID;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLogDirect {
	
	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		//声明转发器
		channel.exchangeDeclare(EXCHANGE_NAME, "direct");
		String service = "", message = "";
		for(int i = 0; i < 10; i++){
			service = getServiceStr();
			message = service + "_LOG_" + UUID.randomUUID().toString();
			//发送消息到转发器,指定routingkey
			channel.basicPublish(EXCHANGE_NAME, service, null, message.getBytes());
			System.out.println("Server send message : " + message);
		}
		channel.close();
		connection.close();
	}
	
	private static String getServiceStr() {
		Random random = new Random(3);
		int r = random.nextInt(3);
		return LOG_CATEGORIES[r];
	}

	private static final String HOST = "localhost";
	private static final String EXCHANGE_NAME = "exchange_direct";
	private static final String[] LOG_CATEGORIES = new String[]{"info","warning","error"};
}
