import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // �������� �������� ����
        JFrame frame = new JFrame("���������� �� ����������� � ���������");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // �������� ������ � ���������� ������ � ��������
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        // ���� ��� ������ ����������
        JTextArea outputArea = new JTextArea(10, 50);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // ������ "�������� �� ������ ����� 5 ���"
        JButton experiencedDriversButton = new JButton("�������� �� ������ > 5 ���");
        experiencedDriversButton.addActionListener(e -> {
            Driver driver1 = new Driver("���� ������", 10);
            Driver driver2 = new Driver("���� ������", 2);
            Driver driver3 = new Driver("����� �������", 6);

            StringBuilder sb = new StringBuilder("�������� �� ������ ����� 5 ���:\n");
            for (Driver driver : new Driver[]{driver1, driver2, driver3}) {
                if (driver.getExperience() > 5) {
                    sb.append("  - ").append(driver.getFullName())
                      .append(", ����: ").append(driver.getExperience()).append(" ���\n");
                }
            }
            outputArea.setText(sb.toString());
        });

        // ������ "���������� ���������� ������������"
        JButton sovietCarsButton = new JButton("���������� ���������� ������������");
        sovietCarsButton.addActionListener(e -> {
            Driver driver1 = new Driver("���� ������", 10);
            Driver driver2 = new Driver("���� ������", 2);
            Driver driver3 = new Driver("����� �������", 6);

            Engine engine1 = new Engine(150, "���");
            Engine engine2 = new Engine(200, "BMW");
            Engine engine3 = new Engine(100, "���");

            Car car1 = new Car("����", "B", 1000, driver1, engine1);
            Car car2 = new Car("BMW", "C", 1500, driver2, engine2);
            Car car3 = new Car("���", "A", 1200, driver3, engine3);

            StringBuilder sb = new StringBuilder("���������� ���������� ������������:\n");
            for (Car car : new Car[]{car1, car2, car3}) {
                if (car.getEngine().getManufacturer().equals("���") || car.getEngine().getManufacturer().equals("���")) {
                    sb.append("  - ").append(car.getBrand())
                      .append(", ���������: ").append(car.getEngine().getManufacturer()).append("\n");
                }
            }
            outputArea.setText(sb.toString());
        });

        // ���������� ����������� �� ������
        panel.add(experiencedDriversButton);
        panel.add(sovietCarsButton);
        panel.add(scrollPane);

        // ���������� ������ � ����
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
