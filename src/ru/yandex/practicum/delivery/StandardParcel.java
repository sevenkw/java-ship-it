package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {

    public final static double BASE_RATE = 2.0;

    public StandardParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

   @Override
    public void packageItem() {
       System.out.println("Посылка " + description + " упакована");
   }

   @Override
   public double getBaseRate() {
        return BASE_RATE;
   }


}
