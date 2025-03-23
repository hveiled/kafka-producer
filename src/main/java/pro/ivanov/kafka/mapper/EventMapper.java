package pro.ivanov.kafka.mapper;

import org.mapstruct.Mapper;
import pro.ivanov.kafka.service.domain.CreateProductDto;
import pro.ivanov.kafka.service.event.ProductCreatedEvent;

@Mapper(componentModel = "spring", config = DefaultMapperConfig.class)
public interface EventMapper {

    ProductCreatedEvent toEvent(CreateProductDto source, String productId);
}
