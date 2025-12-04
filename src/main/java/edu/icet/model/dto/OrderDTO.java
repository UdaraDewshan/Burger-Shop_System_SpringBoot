package edu.icet.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO {
    private String id;
    private String orderDetailId;
    private String customerId;
    private String productId;
    private String qty;
}
