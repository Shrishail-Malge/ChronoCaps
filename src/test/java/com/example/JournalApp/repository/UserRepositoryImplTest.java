package com.example.JournalApp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryImplTest {

    @Autowired
    private UserRespositoryImpl userRespository;

    @Test
    public void find() {
        userRespository.getUsersForSA();
    }
}
