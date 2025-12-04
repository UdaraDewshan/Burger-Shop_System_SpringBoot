package edu.icet.controller;

import lombok.RequiredArgsConstructor;
import edu.icet.model.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;
import edu.icet.service.CustomerService;

import java.util.List;

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

    @GetMapping("/getAll")
    public List<CustomerDTO> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") String id){
        return customerService.deleteCustomer(id);
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@RequestBody CustomerDTO customerDTO,@PathVariable("id")String id){
        return customerService.updateCustomer(customerDTO,id);
    }


}
