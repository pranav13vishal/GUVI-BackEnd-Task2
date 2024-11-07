package com.example.TASK2.Controller;

import com.example.TASK2.Product;
import com.example.TASK2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index() {
        return "index";  // Displays the main page with "Add Product" and "Display Product" options
    }

    @GetMapping("/add-product")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";  // Displays the form to add a product
    }

    @PostMapping("/add-product")
    public String addProductSubmit(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/display-products";  // Redirects to the display page after adding a product
    }

    @GetMapping("/display-products")
    public String displayProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "display-products";  // Displays all products in a table
    }
}
