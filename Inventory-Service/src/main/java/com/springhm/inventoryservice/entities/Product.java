package com.springhm.inventoryservice.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Table(name = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
}
