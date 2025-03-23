package pro.ivanov.kafka.service.domain;

import java.math.BigDecimal;


public record CreateProductDto(
        String title,
        BigDecimal price,
        Integer quantity
) {
}
