package pro.ivanov.kafka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.ivanov.kafka.mapper.EventMapper;
import pro.ivanov.kafka.service.domain.CreateProductDto;
import pro.ivanov.kafka.service.event.KafkaMessagingService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final KafkaMessagingService messagingService;
    private final EventMapper eventMapper;

    @Override
    public String createProduct(CreateProductDto product) {
        //TODO: save to DB
        var productId = UUID.randomUUID().toString();
        messagingService.send(eventMapper.toEvent(product, productId));
        return productId;
    }
}
