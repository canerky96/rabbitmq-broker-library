package config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfiguration {

  @Value("${kaya.rabbitmq.product.queue}")
  private String queueName;

  @Value("${kaya.rabbitmq.product.exchange}")
  private String exchange;

  @Value("${kaya.rabbitmq.product.binding-key}")
  private String bindingKey;

  @Bean
  Queue queue() {
    return new Queue(queueName, false); // not durable
  }

  @Bean
  DirectExchange directExchange() {
    return new DirectExchange(exchange);
  }

  @Bean
  Binding binding(Queue queue, DirectExchange directExchange) {
    return BindingBuilder.bind(queue).to(directExchange).with(bindingKey);
  }
}
