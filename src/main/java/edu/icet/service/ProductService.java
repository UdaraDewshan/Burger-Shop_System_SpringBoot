package edu.icet.service;

import edu.icet.model.dto.ProductDTO;
import edu.icet.model.entity.Product;
import edu.icet.repository.Productrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    final Productrepository productrepository;

    public String addProduct(ProductDTO productDTO) {

        List<Product> products =productrepository.findAll();
        String genarateId = "P001";
        int genIntId = 1;
        for (Product product:products){
            if (product.getProId().equals(genarateId)){
                genIntId++;
                genarateId = String.format("P%03d",genIntId);
            }else{
                break;
            }
        }

        Product product = new Product(
                genarateId,
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
                     product.getProId(),
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

    public List<ProductDTO> getAll() {
        List<Product> products = productrepository.findAll();
        ArrayList<ProductDTO> productDTOS = new ArrayList<>();

        for (Product p1 : products){
            ProductDTO productDTO = new ProductDTO(
                    p1.getProId(),
                    p1.getName(),
                    p1.getPrice(),
                    p1.getQuantity(),
                    p1.getIsAvailable()
            );
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }

    public String updateProduct(ProductDTO productDTO, String id) {
        List<Product> products = productrepository.findAll();
        for(Product p1: products){
            if(p1.getProId().equals(id)){
                productrepository.save(new Product(
                        id,
                        productDTO.getName(),
                        productDTO.getPrice(),
                        productDTO.getQuantity(),
                        productDTO.getIsAvailable()
                ));
                return "Product Update Success";
            }
        }
        return "Product Update UnSuccess";
    }
}
