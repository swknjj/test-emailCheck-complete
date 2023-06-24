package com.example.test.Controller;

import com.example.test.DTO.EmailAuthRequestDTO;
import com.example.test.Service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@Controller
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    @PostMapping("/memberSave/mailConfirm")
    public ResponseEntity mailConfirm(@RequestBody EmailAuthRequestDTO emailAuthRequestDTO) throws MessagingException, UnsupportedEncodingException {
        String authCode = mailService.sendEmail(emailAuthRequestDTO.getEmail());
        System.out.println("emailAuthRequestDTO = " + emailAuthRequestDTO);
        System.out.println("authCode = " + authCode);
        return new ResponseEntity<>(authCode, HttpStatus.OK);
    }

}
