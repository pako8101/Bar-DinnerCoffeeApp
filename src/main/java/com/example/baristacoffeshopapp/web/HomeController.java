package com.example.baristacoffeshopapp.web;

import com.example.baristacoffeshopapp.model.view.OrderViewModel;
import com.example.baristacoffeshopapp.sec.CurrentUser;
import com.example.baristacoffeshopapp.service.OrderService;
import com.example.baristacoffeshopapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class HomeController {

    private final CurrentUser currentUser;
    private final OrderService orderService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model){

        if (currentUser.getId()==null){
            return "index";
        }
        List<OrderViewModel> orders = orderService.findAllOrderOrderByPriceDesc();

        model.addAttribute("orders",orders);
        model.addAttribute("totalTime", orders
                .stream().map(orderViewModel ->  orderViewModel.getCategory().getNeededTime())
                .reduce(Integer::sum)
                .orElse(0));
        model.addAttribute("users",
                userService
                        .findAllUsersAndCountOfOrdersOrderByCountDesc());

        return "home";
    }
            @GetMapping("/about")
    public String about(){
        return "/about";
            }

            @GetMapping("/contacts")
    public String contacts(){
        return "/contacts";
            }
    @GetMapping("/quality")
    public String quality(){
        return "/quality";
    }
    @GetMapping("/newOffers")
    public String newOffers(){
        return "newOffers";
    }
}
