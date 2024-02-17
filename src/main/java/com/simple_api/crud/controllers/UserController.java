package com.simple_api.crud.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple_api.crud.models.UserModel;
import com.simple_api.crud.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    public enum Params {
        Id
    }

    @GetMapping("/papa")
    public String papEString() {
        return new String("hello papa");
    }

    @Autowired
    UserService userService;

    @GetMapping()
    public Responses getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping()
    public Responses saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Responses getUser(@PathVariable("id") long id) {
        return this.userService.getUser(id);
    }

    @PutMapping(path = "/{id}")
    public Responses updateUser(@PathVariable("id") long id, @RequestBody UserModel user) {
        return this.userService.updateUser(user, id);
    }

    @DeleteMapping(path = "/{id}")
    public Responses deleteUser(@PathVariable("id") long id) {
        return this.userService.deleteUser(id);
    }
}
