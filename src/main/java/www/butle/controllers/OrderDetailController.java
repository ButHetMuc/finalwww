package www.butle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import www.butle.services.OrderDetailServices;

@Controller
@RequestMapping("/detail")
public class OrderDetailController {
    private OrderDetailServices services;

    @Autowired
    public OrderDetailController(OrderDetailServices services) {
        this.services = services;
    }
}
