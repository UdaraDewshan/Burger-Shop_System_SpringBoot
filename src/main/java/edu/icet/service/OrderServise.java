package edu.icet.service;

import edu.icet.model.dto.OrderDTO;
import edu.icet.repository.CustomerRepository;
import edu.icet.repository.OrderRepository;
import edu.icet.repository.OrderdDetailRepository;
import edu.icet.repository.Productrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServise {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final OrderdDetailRepository orderdDetailRepository;
    private final Productrepository productrepository;

    public String addOrder(OrderDTO orderDTO) {
        return null;
    }
}
