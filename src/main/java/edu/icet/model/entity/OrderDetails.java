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
public class OrderDetails {

    @Id
    private String orderDetailId;
    private String orderId;
    private String productId;
    private String qty;

}
