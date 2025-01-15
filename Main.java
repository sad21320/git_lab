public class Main {
    public static void main(String[] args) {
        // Создаем объекты Driver
        Driver driver1 = new Driver("Иван Иванов", 10);
        Driver driver2 = new Driver("Петр Петров", 2);
        Driver driver3 = new Driver("Сидор Сидоров", 6);

        // Создаем объекты Engine
        Engine engine1 = new Engine(150, "ВАЗ");
        Engine engine2 = new Engine(200, "BMW");
        Engine engine3 = new Engine(100, "ГАЗ");

        // Создаем объекты Car
        Car car1 = new Car("Лада", "B", 1000, driver1, engine1);
        Car car2 = new Car("BMW", "C", 1500, driver2, engine2);
        Car car3 = new Car("ГАЗ", "A", 1200, driver3, engine3);

        // Выводим водителей со стажем более 5 лет
        System.out.println("Водители со стажем более 5 лет:");
        printExperiencedDrivers(new Driver[]{driver1, driver2, driver3});

        // Выводим автомобили советского производства (упрощенная проверка)
        System.out.println("\nАвтомобили советского производства:");
        printSovietCars(new Car[]{car1, car2, car3});
    }

    private static void printExperiencedDrivers(Driver[] drivers) {
        for (Driver driver : drivers) {
            if (driver.getExperience() > 5) {
                System.out.println("  - " + driver.getFullName() + ", Стаж: " + driver.getExperience() + " лет");
            }
        }
    }

    private static void printSovietCars(Car[] cars) {
        for (Car car : cars) {
            if (car.getEngine().getManufacturer().equals("ВАЗ") || car.getEngine().getManufacturer().equals("ГАЗ")) {
                System.out.println("  - " + car.getBrand() + ", Двигатель: " + car.getEngine().getManufacturer());
            }
        }
    }
