package edu.icet.service;

import lombok.RequiredArgsConstructor;
import edu.icet.model.dto.CustomerDTO;
import edu.icet.model.entity.Customer;
import org.springframework.stereotype.Service;
import edu.icet.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public String addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                "C001",
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getPhoneNo(),
                customerDTO.getPostalCode()
        );
        customerRepository.save(customer);
        return "Added Success";
    }

    public CustomerDTO searchCustomer(String id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        return new CustomerDTO(customer.getName(),customer.getAddress(),customer.getPhoneNo(),customer.getPostalCode());
    }


}
