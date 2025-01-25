package com.example.JournalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void testSendMail() {
        emailService.sendEmail("shrishailmalge2004@gmail.com",
                "Testing Java mail sender",
                "aur bhai kaisa hai");
    }

}
