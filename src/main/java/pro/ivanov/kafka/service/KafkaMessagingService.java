package pro.ivanov.kafka.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pro.ivanov.kafka.service.event.ProductCreatedEvent;

import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaMessagingService {

    private static final String CREATE_PRODUCT_TOPIC = "product-created-events-topic";
    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    public void send(ProductCreatedEvent event) {
        try {
            var productId = event.getProductId();
            var result = kafkaTemplate.send(CREATE_PRODUCT_TOPIC, productId, event).get();
            log.info("Topic: {}", result.getRecordMetadata().topic());
            log.info("Partition: {}", result.getRecordMetadata().partition());
            log.info("Offset: {}", result.getRecordMetadata().offset());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
