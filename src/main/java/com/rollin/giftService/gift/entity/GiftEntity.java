package com.rollin.giftService.gift.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@Builder
@Data
@Document(collection = "gifts")
@Component
public class GiftEntity {
    @Id
    private Integer id;
    private String name;
    private Integer count;
    private Integer price;
    private String content;
    private String img;
    private Integer views;
}