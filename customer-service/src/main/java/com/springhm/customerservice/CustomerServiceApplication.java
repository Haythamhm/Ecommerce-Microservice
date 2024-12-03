package com.springhm.customerservice;

import com.springhm.customerservice.entities.Customer;
import com.springhm.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder()
                            .name("Mohamed").email("mohamed@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                            .name("Hamza").email("hamza@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                            .name("Brahim").email("brahim@gmail.com")
                    .build());
            customerRepository.findAll().forEach(customer -> {
                System.out.println("===================");
                System.out.println(customer.getId());
                System.out.println(customer.getName());
                System.out.println(customer.getEmail());
                System.out.println("===================");
            });
        };
    }

}
