package com.example.algorithm;

import com.example.algorithm.title.Algorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

@SpringBootTest
class AlgorithmApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(Algorithm.isValidBrackets("{}{}{}"));
    }

}
