package pro.ivanov.kafka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.ivanov.kafka.service.ProductService;
import pro.ivanov.kafka.service.domain.CreateProductDto;
import pro.ivanov.kafka.service.domain.error.ErrorMessage;
import pro.ivanov.kafka.service.domain.error.SendMessageException;

@RestController
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/create")
    public ResponseEntity<String> createProduct(@RequestBody CreateProductDto createProductDto) {
        var productId = productService.createProduct(createProductDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productId);
    }

    @ExceptionHandler(SendMessageException.class)
    public ResponseEntity<ErrorMessage> exception(SendMessageException ex) {
        return ResponseEntity.internalServerError()
                .body(new ErrorMessage(ex.getTimestamp(), ex.getMessage()));
    }
}
