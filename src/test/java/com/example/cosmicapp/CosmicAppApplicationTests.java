package com.example.cosmicapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CosmicAppApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void getPass(){
        getPassHash()
;    }

    @Bean
    public PasswordEncoder getPassHash( ){
        PasswordEncoder pe = new BCryptPasswordEncoder();
        System.out.println(pe.encode("admin"));
        return new BCryptPasswordEncoder();
    }

}
