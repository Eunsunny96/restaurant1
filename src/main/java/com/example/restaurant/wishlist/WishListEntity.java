package com.example.restaurant.wishlist;


import com.example.restaurant.db.MemoryDbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishListEntity extends MemoryDbEntity {

    private String title; //음식명
    private String category; //카테고리
    private String address;//주소
    private String readAddress;//도로명
    private String homePageLink;//홈페이지 주소
    private String imageLink;//사진
    private boolean isVisit;//방문여부
    private int visitCount;//방문횟수
    private LocalDateTime lastVisitDate; //마지막 방문일자
}
