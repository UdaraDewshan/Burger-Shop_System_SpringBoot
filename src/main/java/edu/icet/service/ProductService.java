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

    public ProductDTO searchProduct(String id) {
         Product product = productrepository.findById(id).orElse(null);
         if (product!=null){
             return new ProductDTO(
                     product.getId(),
                     product.getName(),
                     product.getPrice(),
                     product.getQuantity(),
                     product.getIsAvailable()
             );
         }else {
             ProductDTO productDTO = new ProductDTO();
             productDTO.setName(null);
             return productDTO;
         }
    }
}
