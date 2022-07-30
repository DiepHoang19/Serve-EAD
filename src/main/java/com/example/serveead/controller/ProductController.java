package com.example.serveead.controller;


import com.example.serveead.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v2/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {
    final ProductService productService;
    @GetMapping
    public ResponseEntity<?> findAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit,
            @RequestParam(defaultValue = "createdAt") String sortBy
    ){
        return ResponseEntity.ok(productService.findAll(page, limit, sortBy));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return ResponseEntity.ok(productService.findById(id));
    }
}
