package www.butle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import www.butle.models.OrderDetail;
import www.butle.services.OrderDetailServices;

import java.util.List;

@Controller
@RequestMapping("/detail")
public class OrderDetailController {
    private OrderDetailServices services;

    @Autowired
    public OrderDetailController(OrderDetailServices services) {
        this.services = services;
    }

    @GetMapping("")
    public ResponseEntity<List<OrderDetail>> getAll(){
        List<OrderDetail> orderDetails = services.getAll();
        if(orderDetails.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }
}
