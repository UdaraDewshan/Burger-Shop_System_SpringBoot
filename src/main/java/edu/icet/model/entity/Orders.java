package edu.icet.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Orders {
    @Id
    private String orderId;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customerId;
    private LocalDate orderDate;
    @OneToMany(mappedBy = "ordersId",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderDetails> orderDetailsList;

    public Orders(String orderId, Customer customerId, LocalDate orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
    }
}