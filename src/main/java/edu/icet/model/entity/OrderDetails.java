package edu.icet.model.entity;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetails {

    @Id
    private String id;
    private String orderId;
    private String productId;
    private String qty;
}
