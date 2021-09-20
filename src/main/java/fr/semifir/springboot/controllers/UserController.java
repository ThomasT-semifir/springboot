package fr.semifir.springboot.controllers;

import fr.semifir.springboot.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {
    @GetMapping
    public User getAllUser() {
        User user = new User("Timio", "Thomas");
        return user;
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return user;
    }

    @GetMapping("toto")
    public String findUser(@RequestParam String id) {
        return id;
    }
}
