package edu.icet.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
    private Boolean isAvailable;
}
