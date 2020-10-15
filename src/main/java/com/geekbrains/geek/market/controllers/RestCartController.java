package com.geekbrains.geek.market.controllers;

import com.geekbrains.geek.market.services.ProductService;
import com.geekbrains.geek.market.utils.Cart;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
public class RestCartController {
    private ProductService productService;
    private Cart cart;

    @GetMapping // /api/v1/cart
    public Cart showCartPage(HttpSession session) {
        return cart;
    }

}
