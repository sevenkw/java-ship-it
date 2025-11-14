package ru.yandex.practicum.delivery;

public abstract class Parcel {
    protected String description;
    protected double weight;
    protected String deliveryAddress;
    protected int sendDay;

    public Parcel(String description, double weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public abstract void packageItem();

    protected abstract double getBaseRate();

    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }

    public double calculateDeliveryCost() {
        return weight * getBaseRate();
    }

}
