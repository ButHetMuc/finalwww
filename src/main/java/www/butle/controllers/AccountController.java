package www.butle.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import www.butle.models.Account;
import www.butle.services.AccountServices;
import www.butle.utils.Message;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    private final AccountServices services;

    public AccountController(AccountServices services) {
        this.services = services;
    }
    @GetMapping({"","/list"})
    public ResponseEntity<List<Account>>  getAllAccounts(){
        List<Account> list = services.getAll();
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Account> add(@RequestBody Account account){
        services.add(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Message> delete(@PathVariable long id){
        return Message.getMessageResponseEntity(services.delete(id),id);
    }
    @PutMapping("/update")
    public ResponseEntity<Message> update(@RequestBody Account account){
        Account account1 = services.update(account);
        if(account1 == null){
            Message message = new Message(false,"not found");
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
        Message message = new Message(true, "updated Successful");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
