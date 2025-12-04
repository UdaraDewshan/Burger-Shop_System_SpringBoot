package edu.icet.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO {
    private String orderId;
    private String orderDetailId;
    private String customerId;
    private String productId;
    private String qty;
    private LocalDate localDate;
    private double totalPrice;
}
