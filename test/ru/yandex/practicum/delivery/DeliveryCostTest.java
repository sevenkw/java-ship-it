package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeliveryCostTest {

    @Test
    void standardParcelCostTest() {
        StandardParcel sp = new StandardParcel("Телефон", 5, "Москва", 10);
        assertEquals(10, sp.calculateDeliveryCost());
    }

    @Test
    void fragileParcelCostTest() {
        FragileParcel fp = new FragileParcel("Ваза", 3, "СПб", 12);
        assertEquals(12, fp.calculateDeliveryCost());
    }

    @Test
    void perishableParcelCostTest() {
        PerishableParcel pp = new PerishableParcel("Пирог", 2, "Казань", 5, 3);
        assertEquals(6, pp.calculateDeliveryCost());
    }

    @Test
    void zeroWeightCostTest() {
        StandardParcel sp = new StandardParcel("Пустая", 0, "Москва", 1);
        assertEquals(0, sp.calculateDeliveryCost());
    }
}