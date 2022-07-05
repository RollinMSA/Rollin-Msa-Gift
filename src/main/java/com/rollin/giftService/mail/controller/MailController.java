package com.rollin.giftService.mail.controller;

import com.rollin.giftService.mail.model.MailDto;
import com.rollin.giftService.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mail")
public class MailController {

    @Autowired
    MailService mailService;

    @Autowired
    MailDto mailDto;

    @PostMapping("/send")
    public void sendMail(@RequestBody MailDto mailDto){
        mailDto.setAddress("gudwodjssl2@gmail.com");
        mailService.sendMail(mailDto);
    }
}
