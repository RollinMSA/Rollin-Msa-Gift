package com.rollin.giftService.gift.serive;


import com.rollin.giftService.gift.entity.GiftEntity;

import java.util.List;
import java.util.Optional;

public interface GiftService {
    List<GiftEntity> findAllGift();

    List<GiftEntity> findGiftByName(String name);

    Optional<GiftEntity> getGiftById(Integer id);

    Optional<GiftEntity> viewCount(Integer id);

    Optional<GiftEntity> updateGiftCount(Integer id);


}
