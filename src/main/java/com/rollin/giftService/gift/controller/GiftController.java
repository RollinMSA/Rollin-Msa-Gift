package com.rollin.giftService.gift.controller;

import com.rollin.giftService.gift.entity.GiftEntity;
import com.rollin.giftService.gift.serive.GiftService;
import com.rollin.giftService.mail.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("gift")
@Slf4j
public class GiftController {
    @Autowired
    GiftService giftService;

    @GetMapping("/")
    public List<GiftEntity> getAllGift(){
        return giftService.findAllGift();
    }

    @GetMapping("/search/{name}")
    public List<GiftEntity> getGiftByName(@PathVariable String name){
        log.info(name);
        return giftService.findGiftByName(name);
    }

    @GetMapping("/{id}")
    public Optional<GiftEntity> getGiftById(@PathVariable String id){
        log.info("getGiftById 실행");
        return giftService.getGiftById(Integer.valueOf(id));
    }

    @PutMapping("/view/{id}")
    public Optional<GiftEntity> updateGiftView(@PathVariable String id) {
        log.info("/view/" + id + " 실행");
        return giftService.viewCount(Integer.valueOf(id));
    }

    // giftId 가져오기
    @PutMapping("/count/{id}")
    public Optional<GiftEntity> updateGiftCount(@PathVariable String id){
        log.info("/count/" + id + " 실행");
        return giftService.updateGiftCount(Integer.valueOf(id));
    }

}
