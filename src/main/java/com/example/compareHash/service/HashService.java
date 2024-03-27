package com.example.compareHash.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class HashService {

    public String encrypt(String passwordEncrypt, Integer rounds) {
        String bcryptHashString = BCrypt.withDefaults().hashToString(rounds, passwordEncrypt.toCharArray());
        return bcryptHashString;
    }

    public String compare(String password, String hash) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), hash);
        if (result.verified) {
            return "Password matches hash";
        } else {
            return "Password does not match hash";
        }
    }
}
