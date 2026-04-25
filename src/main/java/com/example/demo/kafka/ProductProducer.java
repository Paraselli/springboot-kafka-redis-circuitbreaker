package com.example.demo.kafka;
import com.example.demo.model.Product;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service
public class ProductProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    public ProductProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendProductEvent(Product product) {
        kafkaTemplate.send("product-topic", product);
    }
}