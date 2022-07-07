package com.rollin.giftService.gift.serive;

import com.rollin.giftService.gift.entity.GiftEntity;
import com.rollin.giftService.gift.repository.GiftRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class GiftServiceImpl implements GiftService {

    @Autowired
    GiftRepository giftRepository;

    private JavaMailSender mailSender;

    @Override
    public List<GiftEntity> findAllGift() {
        return giftRepository.findAll() ;
    }

    @Override
    public List<GiftEntity> findGiftByName(String name) {
        log.info(name);

        return giftRepository.findByNameLike(name);
    }

    @Override
    public Optional<GiftEntity> getGiftById(Integer id) {
        return giftRepository.findById(id);
    }

    @Override
    public Optional<GiftEntity> viewCount(Integer id) {
        Optional<GiftEntity> gift=giftRepository.findById(id);
        gift.ifPresent(selectGift->{
            selectGift.setViews(selectGift.getViews()+1);

            giftRepository.save(selectGift);
        });
        log.info(String.valueOf(gift));
        return gift;
    }

    @Override
    public Optional<GiftEntity> updateGiftCount(Integer id) {
        Optional<GiftEntity> gift=giftRepository.findById(id);
        gift.ifPresent(selectGift->{
            selectGift.setCount(selectGift.getCount()+1);

            giftRepository.save(selectGift);
        });
        log.info(String.valueOf(gift));
        return gift;
    }

}
