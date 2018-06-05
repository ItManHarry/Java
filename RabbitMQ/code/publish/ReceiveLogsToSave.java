package com.esb.queue.mq.rabbit.publish;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class ReceiveLogsToSave {

	public static void main(String[] args) throws Exception{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		//声明交换器
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
		//创建一个非持久的,唯一的且自动删除的队列
		String queueName = channel.queueDeclare().getQueue();
		System.out.println("Queue name is : " + queueName);
		//为交换器指定队列,设置绑定
		channel.queueBind(queueName, EXCHANGE_NAME, "");
		//消费者
		QueueingConsumer consumer = new QueueingConsumer(channel);
		//指定接收者,第二个参数为自动应答,无需手动应答
		channel.basicConsume(queueName, true, consumer);
		String message = "";
		while(true){
			System.out.println("Get message from Server and save to the file");
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			message = new String(delivery.getBody());
			toFile(message);
		}
	}
	
	public static void toFile(String message) throws IOException{
		String path = ReceiveLogsToSave.class.getClassLoader().getResource("").getPath();
		String fileName = new SimpleDateFormat("yyyyMMdd").format(new Date());
		File file = new File(path, fileName+".txt");
		FileOutputStream fos = new FileOutputStream(file, true);
		fos.write((message+"\r\n").getBytes());
		fos.flush();
		fos.close();
	}
	
	private static final String EXCHANGE_NAME = "logs";
	private static final String HOST = "localhost";
}
