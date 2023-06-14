package com.ohgiraffers.common;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BeverageDAO {

    private final Map<String, Beverage> beverageMap;

    public BeverageDAO() {

        this.beverageMap = new HashMap<>();
        this.beverageMap.put("닥터페퍼", new Beverage("닥터페퍼", 2000));
        this.beverageMap.put("소주", new Beverage("소주", 5000));
        this.beverageMap.put("제로콜라", new Beverage("제로콜라", 3000));
    }

    public Beverage beverageVM(String bevName){
        return beverageMap.get(bevName);
    }
    public String vendingMachine (String bevName, int money) {
        Beverage beverage = beverageMap.get(bevName);
        int bevPrice = beverage.getBevPrice();


        if (bevPrice > money){
            throw new IllegalArgumentException("금액이 모자랍니다.");
        }
        return bevName;
    }
}
