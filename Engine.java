/**
 * Класс Engine описывает двигатель автомобиля.
 */
public class Engine {
    private int power;
    private String manufacturer;

    /**
     * Конструктор класса Engine.
     * @param power Мощность двигателя.
     * @param manufacturer Производитель двигателя.
     */
    public Engine(int power, String manufacturer) {
        this.power = power;
        this.manufacturer = manufacturer;
    }

    /**
     * Возвращает мощность двигателя.
     * @return Мощность двигателя.
     */
    public int getPower() {
        return power;
    }

    /**
     * Возвращает производителя двигателя.
     * @return Производитель двигателя.
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Основной метод для тестирования класса Engine.
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        Engine engine = new Engine(150, "Toyota");
        System.out.println("Производитель: " + engine.getManufacturer());
        System.out.println("Мощность: " + engine.getPower() + " л.с.");
    }
}