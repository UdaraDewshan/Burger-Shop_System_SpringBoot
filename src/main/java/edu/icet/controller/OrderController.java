package edu.icet.controller;

import edu.icet.model.dto.OrderDTO;
import edu.icet.service.OrderServise;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServise orderServise;

    @PostMapping("/add")
    public String addOrder(@PathVariable OrderDTO orderDTO){
        return orderServise.addOrder(orderDTO);
    }
}
