package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PerishableParcelTest {

    @Test
    void notExpiredTest() {
        PerishableParcel pp = new PerishableParcel("Пирог", 1, "Москва", 10, 5);
        assertFalse(pp.isExpired(13));
    }

    @Test
    void expiredTest() {
        PerishableParcel pp = new PerishableParcel("Пирог", 1, "Москва", 10, 5);
        assertTrue(pp.isExpired(16));
    }

    @Test
    void boundaryTest() {
        PerishableParcel pp = new PerishableParcel("Пирог", 1, "Москва", 10, 5);
        assertFalse(pp.isExpired(15));
    }
}
