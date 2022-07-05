package com.rollin.giftService.gift.repository;

import com.rollin.giftService.gift.entity.GiftEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiftRepository extends JpaRepository<GiftEntity,Integer> {
    public List<GiftEntity> findAll();

    public List<GiftEntity> findByNameLike(String name);
}
