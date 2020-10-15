package com.geekbrains.geek.market.controllers;

import com.geekbrains.geek.market.entities.Order;
import com.geekbrains.geek.market.services.OrderService;
import com.geekbrains.geek.market.services.ProductService;
import com.geekbrains.geek.market.utils.Cart;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;
    private Cart cart;

    @GetMapping
    public String firstRequest(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "orders";
    }

    @PostMapping("/neworder")
    @ResponseBody
    public String confirmOrder(
            @RequestParam(name = "client") String client,
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "deliveryAddress") String deliveryAddress
                          ) {
        Order order = new Order();
        order.setClient(client);
        order.setPhone(phone);
        order.setDeliveryAddress(deliveryAddress);
        order.setPrice(cart.getPrice());
        cart.getItems().forEach(io->io.setOrder(order));
        order.setItems(cart.getItems());
        orderService.save(order);
        return "<h1>Заказ оформлен</h1><p>Ваш заказ #" + order.getId()+" оформлен успешно.<br> В ближайшее время менеджер с вами свяжется.";
    }



}
