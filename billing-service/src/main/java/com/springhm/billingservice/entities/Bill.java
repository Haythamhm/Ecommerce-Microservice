package com.springhm.billingservice.entities;

import com.springhm.billingservice.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private Long customerId;

    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems = new ArrayList<>();

    @Transient
    private Customer customer;
}
