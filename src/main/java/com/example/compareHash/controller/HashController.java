package com.example.compareHash.controller;

import com.example.compareHash.service.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hash")
public class HashController {
    @Autowired
    private HashService hashService;

    @PostMapping("/encrypt")
    public String encrypt(@RequestParam("passwordEncrypt") String passwordEncrypt, @RequestParam("rounds") Integer rounds) {
        return hashService.encrypt(passwordEncrypt, rounds);
    }

    @PostMapping("/compare")
    public String compare(@RequestParam("password") String password, @RequestParam("hash") String hash) {
        return hashService.compare(password, hash);
    }

}
