package edu.icet.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class OrderDetails {
    @Id
    private String orderDetailsId;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Orders ordersId;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product productId;
    private int qty;
    private double price;
}
