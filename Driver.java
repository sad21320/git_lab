/**
 * Класс Driver описывает водителя автомобиля.
 */
public class Driver {
    private String fullName; // Полное имя водителя
    private int experience;   // Стаж вождения в годах

    /**
     * Конструктор класса Driver.
     * @param fullName Полное имя водителя.
     * @param experience Стаж вождения в годах.
     */
    public Driver(String fullName, int experience) {
        this.fullName = fullName;
        this.experience = experience;
    }

    /**
     * Возвращает полное имя водителя.
     * @return Полное имя водителя.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Возвращает стаж вождения.
     * @return Стаж вождения в годах.
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Возвращает строковое представление водителя.
     * @return Строка с информацией о водителе.
     */
    @Override
    public String toString() {
        return "Водитель: " + fullName + ", Стаж: " + experience + " лет";
    }

    /**
     * Основной метод для тестирования класса Driver.
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        Driver driver = new Driver("John Doe", 5);
        System.out.println(driver);
    }
}