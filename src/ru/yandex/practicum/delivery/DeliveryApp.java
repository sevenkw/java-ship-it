package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();

    private static ParcelBox<StandardParcel> standardBox = new ParcelBox<>(50);
    private static ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(50);
    private static ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(50);
    private static List<Trackable> trackableParcels = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    getParselBox();
                    break;
                case 5:
                    reportAllStatus();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Показать содержимое коробок");
        System.out.println("5 — Показать статус всех трекинговых посылок");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        System.out.println("Создаем посылку");

        System.out.print("Описание: ");
        String description = scanner.nextLine();

        System.out.print("Вес (кг): ");
        double weight = Double.parseDouble(scanner.nextLine());

        System.out.print("Адрес доставки: ");
        String address = scanner.nextLine();

        System.out.print("День отправки (1-31): ");
        int sendDay = Integer.parseInt(scanner.nextLine());

        System.out.println("Какой тип посылки вы хотите отправить?");
        System.out.println("1 - стандартная 2 - хрупкая 3 - скоропортящаяся");

        int res = Integer.parseInt(scanner.nextLine());

        if (res == 1) {

            StandardParcel standart = new StandardParcel(description, weight, address, sendDay);
            allParcels.add(standart);
            standardBox.addParcel(standart);

        } else if (res == 2) {

            FragileParcel fragile = new FragileParcel(description, weight, address, sendDay);
            allParcels.add(fragile);
            fragileBox.addParcel(fragile);
            trackableParcels.add(fragile);

        } else if (res == 3) {

            System.out.print("Введите срок годности посылки: ");
            int time = Integer.parseInt(scanner.nextLine());

            PerishableParcel perishable = new PerishableParcel(description, weight, address, sendDay, time);
            allParcels.add(perishable);
            perishableBox.addParcel(perishable);

        } else {
            System.out.println("Выбран неправильный тип посылки");
        }
    }


    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel p: allParcels) {
            p.packageItem();
            p.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        double total = 0;
        for (Parcel p: allParcels) {
            total = total + p.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость доставок: " + total);
    }

    private static void getParselBox() {
        System.out.println("Выберите коробку: 1 - стандартная, 2 - хрупкая, 3 - скоропортящаяся");
        int boxType = Integer.parseInt(scanner.nextLine());

        List<? extends Parcel> list;

        switch (boxType) {
            case 1 -> list = standardBox.getAllParcels();
            case 2 -> list = fragileBox.getAllParcels();
            case 3 -> list = perishableBox.getAllParcels();
            default -> {
                System.out.println("Неверный выбор.");
                return;
            }
        }

        if (list.isEmpty()) {
            System.out.println("Коробка пуста.");
        } else {
            System.out.println("Содержимое коробки:");
            for (Parcel p : list) {
                System.out.println("- " + p.description);
            }
        }
    }

    private static void reportAllStatus() {
        System.out.print("Введите новое местоположение для трекинговых посылок: ");
        String location = scanner.nextLine();
        for (Trackable t : trackableParcels) {
            t.reportStatus(location);
        }
    }
}



