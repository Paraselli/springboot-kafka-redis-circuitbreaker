package com.example.demo.service;
import com.example.demo.kafka.ProductProducer;
import com.example.demo.model.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ProductProducer productProducer;
    public ProductService(RedisTemplate<String, Object> redisTemplate, ProductProducer productProducer) {
        this.redisTemplate = redisTemplate;
        this.productProducer = productProducer;
    }
    public Product saveProduct(Product product) {
        redisTemplate.opsForValue().set("product:" + product.getId(), product);
        productProducer.sendProductEvent(product);
        return product;
    }
    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackProduct")
    public Product getProduct(Long id) {
        Product product = (Product) redisTemplate.opsForValue().get("product:" + id);
        if (product == null) throw new RuntimeException("Product not found");
        return product;
    }
    public Product fallbackProduct(Long id, Exception ex) {
        return new Product(id, "Default Product", 0.0);
    }
}