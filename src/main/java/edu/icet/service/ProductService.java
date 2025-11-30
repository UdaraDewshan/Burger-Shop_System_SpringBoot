package edu.icet.service;

import edu.icet.model.dto.ProductDTO;
import edu.icet.model.entity.Product;
import edu.icet.repository.Productrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    final Productrepository productrepository;

    public String addProduct(ProductDTO productDTO) {

        Product product = new Product(
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getQuantity(),
                productDTO.getIsAvailable()
        );
        productrepository.save(product);
        return "Added Success";
    }

    public String deleteProduct(String id) {
        if(productrepository.existsById(id)){
            productrepository.deleteById(id);
            return "Delete Success";
        }else {
            return "Product Not Found";
        }
    }


}
