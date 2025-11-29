package edu.icet.controller;

import lombok.RequiredArgsConstructor;
import edu.icet.model.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;
import edu.icet.service.CustomerService;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/add")
    public String addCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.addCustomer(customerDTO);
    }

    @GetMapping("/search/{id}")
    public CustomerDTO searchCustomer(@PathVariable("id") String id){
        return customerService.searchCustomer(id);
    }

}
