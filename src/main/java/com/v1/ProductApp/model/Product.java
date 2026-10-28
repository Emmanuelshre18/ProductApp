package com.v1.ProductApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)//it autogenerate unique ID, so we don't have to generate it
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Product name is required")
    private String name;

    private String description;

    private BigDecimal price;

    private int quantity;

}
