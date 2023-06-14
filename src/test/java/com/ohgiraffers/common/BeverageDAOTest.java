package com.ohgiraffers.common;

import com.ohgiraffers.container.ContextConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {ContextConfiguration.class})
class BeverageDAOTest {

    @Autowired
    private BeverageDAO beverageDAO;

    @Test
    void testCreateBevDAO() {
        assertNotNull(beverageDAO);
    }

    @Test
    void vendingMachine() {
        // given
        String vmBev = "닥터페퍼";
        String clientBev1 = "닥터페퍼";
        int clientMoney1 = 10000;

        // when
        Beverage beverage = beverageDAO.beverageVM(vmBev);
        String result = beverageDAO.vendingMachine(clientBev1, clientMoney1);

        // then
        assertEquals(result, beverage.getBevName());
        assertThrows(IllegalArgumentException.class,() -> {
            beverageDAO.vendingMachine("닥터페퍼", 100);
        });

    }
}