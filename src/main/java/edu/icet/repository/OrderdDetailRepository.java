package edu.icet.repository;

import edu.icet.model.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderdDetailRepository extends JpaRepository<OrderDetails,String> {
}
