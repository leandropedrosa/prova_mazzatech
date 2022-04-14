package br.com.mazzatech.portal.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAMQPRabbitSender {
	private final static String SENDER_XML = "/WEB-INF/springamqp-rabbit-sender-context.xml";

	public static void main(String[] args) throws Exception {
		AmqpTemplate amqpTemplate = (AmqpTemplate) (new ClassPathXmlApplicationContext(SENDER_XML))
				.getBean("amqpTemplate");
		int messagCount = 0;
		while (messagCount < 10) {
			amqpTemplate.convertAndSend("tp.routingkey.1", "Mensagem # " + messagCount++);
		}
		System.out.println(messagCount + " mensagem(ns) enviada(s) com sucesso.");
	}
}
