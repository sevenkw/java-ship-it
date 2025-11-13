package ru.yandex.practicum.delivery;
//хрупкая
public class FragileParcel extends Parcel implements Trackable  {

    public final static double BASE_RATE = 4;

    public FragileParcel (String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + description + " обернута в защитную пленку");
        System.out.println("Посылка " + description + " упакована");
    }

    @Override
    public double getBaseRate() {
        return  BASE_RATE;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + description + " изменила местоположение на " + newLocation);
    }
}
