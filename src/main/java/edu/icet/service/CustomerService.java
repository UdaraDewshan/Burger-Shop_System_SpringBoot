package edu.icet.service;

import lombok.RequiredArgsConstructor;
import edu.icet.model.dto.CustomerDTO;
import edu.icet.model.entity.Customer;
import org.springframework.stereotype.Service;
import edu.icet.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public String addCustomer(CustomerDTO customerDTO) {



        Customer customer = new Customer(
                "C002",
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getPhoneNo(),
                customerDTO.getPostalCode()
        );
        customerRepository.save(customer);
        return "Added Success";
    }

    public CustomerDTO searchCustomer(String id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        return new CustomerDTO(customer.getName(),customer.getAddress(),customer.getPhoneNo(),customer.getPostalCode());
    }

    public List<CustomerDTO> getAll() {
         List<Customer> customers = customerRepository.findAll();
         ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();

         for (Customer c1 : customers){
             CustomerDTO customerDTO = new CustomerDTO(
                     c1.getName(),
                     c1.getAddress(),
                     c1.getPhoneNo(),
                     c1.getPostalCode()
             );
             customerDTOS.add(customerDTO);
         }
         return customerDTOS;
    }
}
