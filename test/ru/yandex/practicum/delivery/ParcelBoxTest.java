package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParcelBoxTest {

    private ParcelBox<StandardParcel> box;

    @BeforeEach
    void setUp() {
        box = new ParcelBox<>(10);
    }

    @Test
    void addParcelNormal() {
        StandardParcel sp = new StandardParcel("Телефон", 5, "Москва", 1);
        box.addParcel(sp);
        assertEquals(1, box.getAllParcels().size());
    }

    @Test
    void addParcelExceedingWeight() {
        StandardParcel sp1 = new StandardParcel("Телефон", 7, "Москва", 1);
        StandardParcel sp2 = new StandardParcel("Ноутбук", 5, "Москва", 1);
        box.addParcel(sp1);
        box.addParcel(sp2);
        assertEquals(1, box.getAllParcels().size());
    }

    @Test
    void addParcelBoundaryWeight() {
        StandardParcel sp1 = new StandardParcel("Телефон", 5, "Москва", 1);
        StandardParcel sp2 = new StandardParcel("Ноутбук", 5, "Москва", 1);
        box.addParcel(sp1);
        box.addParcel(sp2);
        assertEquals(2, box.getAllParcels().size());
    }

    @Test
    void addNullParcel() {
        box.addParcel(null);
        assertEquals(0, box.getAllParcels().size());
    }
}
