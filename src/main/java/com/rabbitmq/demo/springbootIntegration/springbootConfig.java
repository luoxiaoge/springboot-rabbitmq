package com.rabbitmq.demo.springbootIntegration;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

// @Component
public class springbootConfig {

    static final String topicExchangeName = "spring-boot-exchange";

    static final String queueName = "spring-boot";

    /**
     * 定义一个队列
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue(queueName, false);
    }
    /**
     *  交换器
     * @return
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    /**
     *   交换器绑定队列
     * @param queue 队列
     * @param exchange 交换器
     * @return
     */
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }

    @Bean
    public   SimpleMessageListenerContainer container(ConnectionFactory ConnectionFactory,
                                                      MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setConnectionFactory(ConnectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    public  MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

}
