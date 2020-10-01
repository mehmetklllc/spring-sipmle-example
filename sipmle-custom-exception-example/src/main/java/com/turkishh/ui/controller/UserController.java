package com.turkishh.ui.controller;


import com.turkishh.ui.exceptions.UserServerException;
import com.turkishh.ui.model.response.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "users")
public class UserController {


    // null pointer handler
    @GetMapping(path = "{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) throws Exception {

        if(id.equals("1")){
            throw  new Exception();
        }else if (id.equals("2")){
            throw  new NullPointerException();
        }else if (id.equals("3")){
            throw  new UserServerException("id cannot be three");
        }else if (id.equals("4")){

        }
        return new ResponseEntity<User>(new User(), HttpStatus.OK);
    }



}
