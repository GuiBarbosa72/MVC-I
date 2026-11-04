package com.techbyte.ecommerceapi.Controller;

import com.techbyte.ecommerceapi.model.products;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("produto")
    public products getProduct() {
        products p=new products("Monitor Guns N Roses" ,"Bonito e perfeito para fãs" ,3.7500);
        return p;
    }
}