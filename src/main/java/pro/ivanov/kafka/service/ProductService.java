package pro.ivanov.kafka.service;

import pro.ivanov.kafka.service.domain.CreateProductDto;

public interface ProductService {

    String createProduct(CreateProductDto product);
}
