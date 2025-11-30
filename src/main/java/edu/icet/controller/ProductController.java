package edu.icet.controller;

import edu.icet.model.dto.ProductDTO;
import edu.icet.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    final ProductService productService;

    @PostMapping("/add")
    public String addProduct(@RequestBody ProductDTO productDTO){
        return productService.addProduct(productDTO);
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id){
        return productService.deleteProduct(id);
    }


}
