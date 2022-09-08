package com.example.hsm_demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

//@SpringBootTest
class HsmDemoApplicationTests {

    @Test
    void contextLoads() {

    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("1233");

        System.out.println(set.add("1233"));
    }

}
