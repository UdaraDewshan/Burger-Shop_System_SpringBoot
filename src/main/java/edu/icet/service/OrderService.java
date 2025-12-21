package edu.icet.service;

import edu.icet.model.dto.OrderDTO;
import edu.icet.model.dto.OrderProductDTO;
import edu.icet.model.entity.Customer;
import edu.icet.model.entity.OrderDetails;
import edu.icet.model.entity.Orders;
import edu.icet.model.entity.Product;
import edu.icet.repository.CustomerRepository;
import edu.icet.repository.OrderDetailRepository;
import edu.icet.repository.OrdersRepository;
import edu.icet.repository.Productrepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional

public class OrderService {
    private final OrdersRepository orderRepository;
    private final Productrepository productrepository;
    private final CustomerRepository customerRepository;
    private final OrderDetailRepository orderDetailRepository;

    public String addOrder(OrderDTO orderDTO) {
        try {
            Customer customer = customerRepository.findById(orderDTO.getCustomerId()).orElse(null);
            List<OrderProductDTO> orderProductsDTOList = orderDTO.getOrderProductsDTOS();
            if (customer == null || orderProductsDTOList == null) {
                return "Customer or Products Invalid or doesn't Exist..!";
            }
            String genOrderId=genOrderId();
            orderRepository.save(new Orders(
                    genOrderId,
                    customer,
                    LocalDate.now()
            ));
            for (OrderProductDTO orderProductsDTOTemp:orderProductsDTOList){
                Product product = productrepository.findById(orderProductsDTOTemp.getProductId()).orElse(null);
                if(product==null){
                    return orderProductsDTOTemp.getProductId()+" Product doesn't Exist..!";
                }
                if((product.getQuantity() - orderProductsDTOTemp.getQty()) < 0){
                    return "Not Enough Quantity in product "+orderProductsDTOTemp.getProductId()+" ..!";
                }
                orderDetailRepository.save(new OrderDetails(
                        genOrderDetailId(),
                        orderRepository.findById(genOrderId).orElse(null),
                        product,
                        orderProductsDTOTemp.getQty(),
                        orderDTO.getPrice()
                ));
                product.setQuantity(product.getQuantity() - orderProductsDTOTemp.getQty());
                productrepository.save(product);
            }

            return "Order Added Successfully..!";
        } catch (
                Exception e) {
            return e.getMessage();
        }
    }

    public String genOrderId() {
        List<Orders> ordersList = orderRepository.findAll();
        String genaratedId = "O001";
        int genIntId = 1;
        for (Orders orders : ordersList) {
            if (orders.getOrderId().equals(genaratedId)) {
                genIntId++;
                genaratedId = String.format("O%03d", genIntId);
            } else {
                break;
            }
        }
        return genaratedId;
    }

    public String genOrderDetailId() {
        List<OrderDetails> oderDetailsList = orderDetailRepository.findAll();
        String genaratedId2 = "D001";
        int genIntId2 = 1;
        for (OrderDetails orderDetails : oderDetailsList) {
            if (orderDetails.getOrderDetailsId().equals(genaratedId2)) {
                genIntId2++;
                genaratedId2 = String.format("D%03d", genIntId2);
            } else {
                break;
            }
        }
        return genaratedId2;
    }


    public String deleteOrder(String id) {
        Orders orders = orderRepository.findById(id).orElse(null);
        if (orders != null){
            List<OrderDetails> orderDetails = orderDetailRepository.findAllByOrdersId_OrderId(id);
            for (OrderDetails orderDetail : orderDetails){
                Product product = productrepository.findById(orderDetail.getProductId().getProId()).orElse(null);
                if (product == null) {
                    throw new IllegalArgumentException("Something went Wrong Try again..!");
                }
                product.setQuantity(product.getQuantity()+orderDetail.getQty());
                productrepository.save(product);
            }
            orderRepository.deleteById(id);
            return "Order Deleted Successfully..!";
        }
        return "Order Doesn't Exist..!";
    }

}
