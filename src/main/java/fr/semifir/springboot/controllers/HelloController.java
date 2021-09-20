package fr.semifir.springboot.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path="api/v1/hello")
public class HelloController {

    @GetMapping
    public String hello() {
        return "hello world";
    }

    @PostMapping("{entree}")
    public String entreeUtilisateur(@PathVariable String entree){
        return entree;
    }

    @PostMapping
    public String autreEntreeUtilisateur(@RequestBody String phrase) {
        return phrase;
    }
}
