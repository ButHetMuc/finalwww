package www.butle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import www.butle.models.Order;
import www.butle.models.Product;
import www.butle.services.OrderServices;
import www.butle.utils.Message;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    private OrderServices services;

    @Autowired
    public OrderController(OrderServices services) {
        this.services = services;
    }
    @GetMapping({"","/{id}"})
    public ResponseEntity<List<Order>> getAllOrders(@PathVariable long id){
        List<Order> list = services.getAllByAccountId(id);
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Order> add(@RequestBody Order order){
        services.add(order);
//        System.out.println(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Message> delete(@PathVariable long id){
        return Message.getMessageResponseEntity(services.delete(id), id);
    }

    @PutMapping("/update")
    public ResponseEntity<Message> update(@RequestBody Order order){
        Order order1 = services.update(order);
        if(order1 == null){
            Message message = new Message(false,"not found");
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
        Message message = new Message(true, "updated Successful");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAll(){
        List<Order> orders = services.getAll();
        if(orders.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }
}
