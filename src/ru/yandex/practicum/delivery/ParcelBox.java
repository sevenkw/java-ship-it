package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private List<T> parcels;
    private double maxWeight;

    public ParcelBox(double maxWeight) {
        this.parcels = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    public List<T> getParcels() {
        return parcels;
    }


    public void addParcel(T parsel) {
        double total = 0;

        if (parsel == null) {
            System.out.println("В коробку нужно положить посылку");
            return;
        }

        for (T p: parcels) {
            total = total + p.weight;
        }

        if (total + parsel.weight > maxWeight) {
            System.out.println("Превышен максимально допустимый вес");
            return;
        } else {
            parcels.add(parsel);
            System.out.println("Посылка успешно добавлена в коробку");
        }
    }

    public List<T> getAllParcels() {
        return new ArrayList<>(parcels);
    }

}
