public class Main {
    public static void main(String[] args) {
        // ������� ������� Driver
        Driver driver1 = new Driver("���� ������", 10);
        Driver driver2 = new Driver("���� ������", 2);
        Driver driver3 = new Driver("����� �������", 6);

        // ������� ������� Engine
        Engine engine1 = new Engine(150, "���");
        Engine engine2 = new Engine(200, "BMW");
        Engine engine3 = new Engine(100, "���");

        // ������� ������� Car
        Car car1 = new Car("����", "B", 1000, driver1, engine1);
        Car car2 = new Car("BMW", "C", 1500, driver2, engine2);
        Car car3 = new Car("���", "A", 1200, driver3, engine3);

        // ������� ��������� �� ������ ����� 5 ���
        System.out.println("�������� �� ������ ����� 5 ���:");
        printExperiencedDrivers(new Driver[]{driver1, driver2, driver3});

        // ������� ���������� ���������� ������������ (���������� ��������)
        System.out.println("\n���������� ���������� ������������:");
        printSovietCars(new Car[]{car1, car2, car3});
    }

    private static void printExperiencedDrivers(Driver[] drivers) {
        for (Driver driver : drivers) {
            if (driver.getExperience() > 5) {
                System.out.println("  - " + driver.getFullName() + ", ����: " + driver.getExperience() + " ���");
            }
        }
    }

    private static void printSovietCars(Car[] cars) {
        for (Car car : cars) {
            if (car.getEngine().getManufacturer().equals("���") || car.getEngine().getManufacturer().equals("���")) {
                System.out.println("  - " + car.getBrand() + ", ���������: " + car.getEngine().getManufacturer());
            }
        }
    }
