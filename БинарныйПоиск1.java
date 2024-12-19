import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class BinarySearchGUI {

    private static int[] массив;

    public static void main(String[] args) {
        // Создание основного окна
        JFrame frame = new JFrame("Бинарный поиск и сортировка");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Панель для элементов
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        // Поля для ввода массива
        JLabel labelArray = new JLabel("Введите элементы массива через запятую:");
        JTextField fieldArray = new JTextField();

        // Поля для ввода искомого элемента
        JLabel labelTarget = new JLabel("Введите искомый элемент:");
        JTextField fieldTarget = new JTextField();

        // Кнопка для сортировки массива
        JButton buttonSort = new JButton("Сортировать массив");

        // Кнопка для выполнения двоичного поиска
        JButton buttonSearch = new JButton("Выполнить поиск");

        // Поле для отображения результата
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        // Добавление элементов на панель
        panel.add(labelArray);
        panel.add(fieldArray);
        panel.add(labelTarget);
        panel.add(fieldTarget);
        panel.add(buttonSort);
        panel.add(buttonSearch);

        // Добавление панели и области результата в окно
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        // Действие для кнопки сортировки
        buttonSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = fieldArray.getText().trim();
                    String[] elements = input.split(",");
                    массив = Arrays.stream(elements).mapToInt(Integer::parseInt).toArray();
                    пузырьковаяСортировка(массив);
                    resultArea.setText("Отсортированный массив: " + Arrays.toString(массив));
                } catch (Exception ex) {
                    resultArea.setText("Ошибка: Проверьте корректность ввода массива.");
                }
            }
        });

        // Действие для кнопки поиска
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (массив == null || массив.length == 0) {
                        resultArea.setText("Сначала введите и отсортируйте массив.");
                        return;
                    }
                    int target = Integer.parseInt(fieldTarget.getText().trim());
                    int result = двоичныйПоиск(массив, target);
                    if (result == -1) {
                        resultArea.setText(resultArea.getText() + "\nЭлемент " + target + " не найден.");
                    } else {
                        resultArea.setText(resultArea.getText() + "\nЭлемент " + target + " найден на индексе " + result + ".");
                    }
                } catch (Exception ex) {
                    resultArea.setText("Ошибка: Проверьте корректность ввода искомого элемента.");
                }
            }
        });

        // Отображение окна
        frame.setVisible(true);
    }

    private static void пузырьковаяСортировка(int[] массив) {
        int размер = массив.length;
        for (int i = 0; i < размер - 1; i++) {
            for (int j = 0; j < размер - i - 1; j++) {
                if (массив[j] > массив[j + 1]) {
                    int временный = массив[j];
                    массив[j] = массив[j + 1];
                    массив[j + 1] = временный;
                }
            }
        }
    }

    private static int двоичныйПоиск(int[] массив, int искомый) {
        int низ = 0;
        int верх = массив.length - 1;
        while (низ <= верх) {
            int середина = низ + (верх - низ) / 2;
            if (массив[середина] < искомый) {
                низ = середина + 1;
            } else if (массив[середина] > искомый) {
                верх = середина - 1;
            } else {
                return середина;
            }
        }
        return -1;
    }
}
