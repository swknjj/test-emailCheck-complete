package com.example.test;

import com.example.test.Service.MailService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@SpringBootTest
class TestApplicationTests {
    @Autowired
    private MailService mailService;

    @Test
    void contextLoads() {
    }
    
    @Test
    @DisplayName("이메일 인증 테스트")
    public void emailCheckTest() throws MessagingException, UnsupportedEncodingException {
        String email_check_code = mailService.sendEmail("lsw3674@gmail.com");
        System.out.println("email_check_code = " + email_check_code);
    }

}
