package br.com.mazzatech.portal.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class SpringAMQPRabbitAyncListener implements MessageListener {
	public void onMessage(Message message) {
		System.out.println("Mensagem recebida do ouvinte = " + new String(message.getBody()));
	}
}
