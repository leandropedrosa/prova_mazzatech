package br.com.mazzatech.portal.rabbitmq;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAMQPRabbitlListenerContainer {
	public static void main(String[] args) {
        new ClassPathXmlApplicationContext("/WEB-INF/springamqp-rabbt-listener-context.xml");
	}
}
