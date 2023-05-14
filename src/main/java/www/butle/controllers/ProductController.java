package www.butle.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import www.butle.models.Product;
import www.butle.services.ProductServices;
import www.butle.utils.Message;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductServices services;

    public ProductController(ProductServices services) {
        this.services = services;
    }
    @GetMapping({"","/list"})
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> list = services.getAll();
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Product> add(@RequestBody Product product){
        services.add(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Message> delete(@PathVariable long id){
        return Message.getMessageResponseEntity(services.delete(id), id);
    }

    @PutMapping("/update")
    public ResponseEntity<Message> update(@RequestBody Product product){
        Product product1 = services.update(product);
        if(product1 == null){
            Message message = new Message(false,"not found");
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
        Message message = new Message(true, "updated Successful");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
