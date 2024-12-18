/**
 * Класс Car описывает автомобиль.
 */
public class Car {
    private String brand;
    private String classType;
    private int price;
    private Driver driver;
    private Engine engine;

    /**
     * Конструктор класса Car.
     * @param brand Марка автомобиля.
     * @param classType Класс автомобиля.
     * @param price Цена автомобиля.
     * @param driver Водитель автомобиля.
     * @param engine Двигатель автомобиля.
     */
    public Car(String brand, String classType, int price, Driver driver, Engine engine) {
        this.brand = brand;
        this.classType = classType;
        this.price = price;
        this.driver = driver;
        this.engine = engine;
    }

    /**
     * Возвращает марку автомобиля.
     * @return Марка автомобиля.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Возвращает производителя двигателя.
     * @return Производитель двигателя.
     */
    public String getEngineManufacturer() {
        return engine.getManufacturer();
    }

    /**
     * Основной метод для тестирования класса Car.
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        // Создаем экземпляр класса Engine
        Engine engine = new Engine(150, "Toyota");

        // Создаем экземпляр класса Driver (нужно определить класс Driver)
        Driver driver = new Driver("John Doe", 30);

        // Создаем экземпляр класса Car
        Car car = new Car("Toyota", "Sedan", 20000, driver, engine);

        // Вывод информации о машине
        System.out.println("Марка автомобиля: " + car.getBrand());
        System.out.println("Производитель двигателя: " + car.getEngineManufacturer());
    }
}