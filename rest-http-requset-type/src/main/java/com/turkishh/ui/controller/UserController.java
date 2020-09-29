package com.turkishh.ui.controller;

import com.turkishh.ui.model.request.UserDetailRequestModel;
import com.turkishh.ui.model.response.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;

@RestController
@RequestMapping("users")   //   http:localhost:8098/users
public class UserController {


    @GetMapping
    public String getUser() {
        return "get users was called";
    }


    @GetMapping(path = "{userId}")
    public String getUser(@PathVariable String userId) {
        return "get users was called with userId : " + userId;
    }

    @GetMapping("/list")
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page
            , @RequestParam(value = "limit", defaultValue = "50") int limit
            , @RequestParam(value = "sort", required = false) String sort) {

        return "get users was called page: " + page + " and  limit " + limit + " and sort " + sort;
    }

    @GetMapping(value = "/get/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public User getUserDetail(@PathVariable String userId) {

        User user = new User();
        user.setEmail("mehmetkilic@turkishh.com");
        user.setFirstName("Edzey");
        user.setLastName("KILIÇ");
        user.setUserId(userId);

        return user;
    }

    @GetMapping(value = "/get-user/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> getUserDetailResponseObject(@PathVariable String userId)  {

        User user = new User();
        user.setEmail("mehmetkilic@turkishh.com");
        user.setFirstName("Edzey");
        user.setLastName(null);
        user.setUserId(userId);

        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDetailRequestModel request)  {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());


        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }

}
