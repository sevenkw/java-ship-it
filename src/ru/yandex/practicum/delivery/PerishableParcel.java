package ru.yandex.practicum.delivery;
//скоропортящаяся
public class PerishableParcel extends Parcel {
    private int timeToLive;
    private final static double BASE_RATE = 3.0;

    public PerishableParcel (String description, double weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + description + " упакована.");
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    @Override
    public double getBaseRate() {
        return BASE_RATE;
    }

    public boolean isExpired (int currentDay) {

        if (sendDay + timeToLive >= currentDay) {
            return false;
        } else {
            return true;
        }
    }

}
