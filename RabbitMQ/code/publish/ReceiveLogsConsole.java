package com.esb.queue.mq.rabbit.publish;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class ReceiveLogsConsole {

	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
		String  queueName = channel.queueDeclare().getQueue();
		//为转发器设置队列,并绑定
		channel.queueBind(queueName, EXCHANGE_NAME, "");
		System.out.println("Output the message from the Server:");
		//指定接收者,第二个参数为自动应答,无需手动
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(queueName, true, consumer);
		String message = "";
		while(true){
			System.out.println("Get message from Server...");
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			message = new String(delivery.getBody());
			System.out.println("The message is : " + message);
		}
	}
	
	private final static String EXCHANGE_NAME = "logs";
	private static final String HOST = "localhost";
}
