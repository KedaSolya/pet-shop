package com.shop.petshop.controllers;


import com.shop.petshop.models.Item;
import com.shop.petshop.models.OrderInfo;
import com.shop.petshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private OrderRepository repository;
    @GetMapping("/happypaw")
    public String home() {
        return "index";
    }
    @GetMapping("/store")
    public String store(){
        return "store";
    }
    @PostMapping("/store")
    public String getOrders(@RequestParam String phoneNumber,@RequestParam String surname,
                            @RequestParam String name,@RequestParam String middleName,
                            @RequestParam String city, @RequestParam String street,
                            @RequestParam String houseNumber,@RequestParam String flatNumber,
                            @RequestParam String goods){
        String[] itemsData = goods.split(";");
        List<Item> items = new ArrayList<>();
        double sum = 0.0;
        for (String data : itemsData) {
            String[] itemData = data.split("-");
            items.add(new Item(itemData[0], Double.parseDouble(itemData[1]), Integer.parseInt(itemData[2])));
            sum += Double.parseDouble(itemData[1]);
        }
        OrderInfo order = new OrderInfo(phoneNumber,surname,name,middleName,city,street,houseNumber,flatNumber,items,sum);
        System.out.println(order.getItems());
        repository.save(order);
        return "confirmation";
    }
    @GetMapping("/confirmation")
    public String confirmation(){
        return "confirmation";
    }
    @GetMapping("/order-management")
    public String orderManagement(Model model){
        Iterable<OrderInfo> orders = repository.findAll();
        model.addAttribute("orders", orders);
        return "order-management";
    }
    @PostMapping("/order-management")
    public String deleteOrder(@RequestParam Long id,Model model){
        repository.deleteById(id);
        return orderManagement(model);
    }
}