import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Создание главного окна
        JFrame frame = new JFrame("Информация об автомобилях и водителях");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Создание панели с текстовыми полями и кнопками
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        // Поле для вывода информации
        JTextArea outputArea = new JTextArea(10, 50);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Кнопка "Водители со стажем более 5 лет"
        JButton experiencedDriversButton = new JButton("Водители со стажем > 5 лет");
        experiencedDriversButton.addActionListener(e -> {
            Driver driver1 = new Driver("Иван Иванов", 10);
            Driver driver2 = new Driver("Петр Петров", 2);
            Driver driver3 = new Driver("Сидор Сидоров", 6);

            StringBuilder sb = new StringBuilder("Водители со стажем более 5 лет:\n");
            for (Driver driver : new Driver[]{driver1, driver2, driver3}) {
                if (driver.getExperience() > 5) {
                    sb.append("  - ").append(driver.getFullName())
                      .append(", Стаж: ").append(driver.getExperience()).append(" лет\n");
                }
            }
            outputArea.setText(sb.toString());
        });

        // Кнопка "Автомобили советского производства"
        JButton sovietCarsButton = new JButton("Автомобили советского производства");
        sovietCarsButton.addActionListener(e -> {
            Driver driver1 = new Driver("Иван Иванов", 10);
            Driver driver2 = new Driver("Петр Петров", 2);
            Driver driver3 = new Driver("Сидор Сидоров", 6);

            Engine engine1 = new Engine(150, "ВАЗ");
            Engine engine2 = new Engine(200, "BMW");
            Engine engine3 = new Engine(100, "ГАЗ");

            Car car1 = new Car("Лада", "B", 1000, driver1, engine1);
            Car car2 = new Car("BMW", "C", 1500, driver2, engine2);
            Car car3 = new Car("ГАЗ", "A", 1200, driver3, engine3);

            StringBuilder sb = new StringBuilder("Автомобили советского производства:\n");
            for (Car car : new Car[]{car1, car2, car3}) {
                if (car.getEngine().getManufacturer().equals("ВАЗ") || car.getEngine().getManufacturer().equals("ГАЗ")) {
                    sb.append("  - ").append(car.getBrand())
                      .append(", Двигатель: ").append(car.getEngine().getManufacturer()).append("\n");
                }
            }
            outputArea.setText(sb.toString());
        });

        // Добавление компонентов на панель
        panel.add(experiencedDriversButton);
        panel.add(sovietCarsButton);
        panel.add(scrollPane);

        // Добавление панели в окно
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
