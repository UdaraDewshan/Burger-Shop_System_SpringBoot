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
public class Customer {

    @Id
    private String cusId;
    private String name;
    private String address;
    private String phoneNo;
    private String postalCode;

}
