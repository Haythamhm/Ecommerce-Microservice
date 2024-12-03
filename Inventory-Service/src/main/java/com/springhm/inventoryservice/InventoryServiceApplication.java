package com.springhm.inventoryservice;

import com.springhm.inventoryservice.entities.Product;
import com.springhm.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("computer")
                            .price(3400)
                            .quantity(4)
                    .build())
            ;productRepository.save(Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Laptop")
                            .price(4100)
                            .quantity(3)
                    .build());
            productRepository.save(Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("smartphone")
                            .price(2500)
                            .quantity(9)
                    .build());
            productRepository.findAll().forEach(product -> System.out.println(product.toString()));
        };
    }


}
