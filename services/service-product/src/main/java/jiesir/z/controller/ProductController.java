package jiesir.z.controller;

import jakarta.validation.Valid;
import jiesir.z.entity.Product;
import jiesir.z.entity.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RestController
public class ProductController {



    public ResponseEntity<?> getProduct(Long id) {
        return null;
    }

    @PutMapping("/aa")
    public ResponseEntity<?> updateProduct(@RequestBody @Valid ProductDTO productDTO) {
        return null;
    }


}
