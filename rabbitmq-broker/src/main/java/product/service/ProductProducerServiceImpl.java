package product.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import product.model.Product;

@Service
public class ProductProducerServiceImpl implements ProductProducerService {

  @Value("${kaya.rabbitmq.product.exchange}")
  private String exchange;

  @Value("${kaya.rabbitmq.product.binding-key}")
  private String bindingKey;

  @Autowired private AmqpTemplate rabbitMQTemplate;

  public void send(Product product) {
    rabbitMQTemplate.convertAndSend(exchange, bindingKey, product);
  }
}
