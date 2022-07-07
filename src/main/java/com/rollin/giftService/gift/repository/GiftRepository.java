package com.rollin.giftService.gift.repository;

import com.rollin.giftService.gift.entity.GiftEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiftRepository extends MongoRepository<GiftEntity,Integer> {
    public List<GiftEntity> findAll();

    @Query("{'name': {'$regex': '?0', '$options': 'i'}}")
    public List<GiftEntity> findByNameLike(String name);
}
