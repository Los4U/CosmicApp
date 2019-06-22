package com.example.cosmicapp;

import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestPass {

    @Test
    public void getPass(){
        getPassHash();
    }

    @Bean
    public PasswordEncoder getPassHash( ){
        PasswordEncoder pe = new BCryptPasswordEncoder();
        System.out.println(pe.encode("user"));
        return new BCryptPasswordEncoder();
    }


}
