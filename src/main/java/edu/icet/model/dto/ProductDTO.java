package edu.icet.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO{
    private String id;
    private String name;
    private double price;
    private int quantity;
    private Boolean isAvailable;
}
