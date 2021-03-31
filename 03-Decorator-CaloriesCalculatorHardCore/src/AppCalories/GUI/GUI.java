package AppCalories.GUI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Графический интерфейс
 */
public class GUI {

  // Переменные для обработки результата
  String[] genderList;
  boolean isFemale;
  double age, weight, height;
  CaloriesButtonListenerInterface listener;

  // Переменные для ГУИ
  JFrame frame;
  JPanel panelLeft, panelRight, panelAll;
  JLabel enterAgeLabel, enterWeightLabel, enterHeightLabel;
  JTextField enterAgeValue, enterWeightValue, enterHeightValue;
  JComboBox<String> genders;
  JButton calculate;
  JLabel result;

  /**
   * Собирает и настраивает ГУИ
   */
  public GUI(String title, CaloriesButtonListenerInterface listener) {
    // Подключаю кастомного слушателя
    this.listener = listener;

    // Список полов
    genderList = new String[]{
        "Мужчина",
        "Женщина"
    };

    // ------------------------------------------------------------------------

    // Задаёт фрейм
    frame = new JFrame(title);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 350);

    // ------------------------------------------------------------------------

    // Левая панель фрейма
    panelLeft = new JPanel(new GridLayout(6, 1));

    // Готовлю лейблы с текстами
    enterAgeLabel = new JLabel("Введите возраст (в годах)");
    enterWeightLabel = new JLabel("Введите вес (в килограммах)");
    enterHeightLabel = new JLabel("Введите рост (в сантиметрах)");

    // Центрирую текст в лейблах
    enterAgeLabel.setHorizontalAlignment(JLabel.CENTER);
    enterWeightLabel.setHorizontalAlignment(JLabel.CENTER);
    enterHeightLabel.setHorizontalAlignment(JLabel.CENTER);

    // Готовлю поля ввода значений
    enterAgeValue = new JFormattedTextField();
    enterWeightValue = new JFormattedTextField();
    enterHeightValue = new JFormattedTextField();

    // Центрирую текст в полях ввода
    enterAgeValue.setHorizontalAlignment(JTextField.CENTER);
    enterWeightValue.setHorizontalAlignment(JTextField.CENTER);
    enterHeightValue.setHorizontalAlignment(JTextField.CENTER);

    // Добавляю компоненты на левую панель
    panelLeft.add(enterAgeLabel);
    panelLeft.add(enterAgeValue);

    panelLeft.add(enterWeightLabel);
    panelLeft.add(enterWeightValue);

    panelLeft.add(enterHeightLabel);
    panelLeft.add(enterHeightValue);

    // Делаю отступы
    panelLeft.setBorder(
        BorderFactory.createEmptyBorder(
            10, 20, 10, 20
        )
    );

    // ------------------------------------------------------------------------

    // Правая панель фрейма
    panelRight = new JPanel(new GridLayout(3, 1));

    // Выбор пола
    genders = new JComboBox<>(genderList);

    // Кнопка "Посчитать"
    calculate = new JButton("Посчитать");
    // Добавляю слушателя к ней
    addButtonListener();

    // Лейбл с выводом результата
    result = new JLabel("Тут будет результат");

    // Центрирую текст результата
    result.setHorizontalAlignment(JLabel.CENTER);

    // Добавляю компоненты на правую панель
    panelRight.add(genders);
    panelRight.add(calculate);
    panelRight.add(result);

    // Делаю отступы
    panelRight.setBorder(
        BorderFactory.createEmptyBorder(
            10, 20, 10, 20
        )
    );

    // ------------------------------------------------------------------------

    // Общая панель
    panelAll = new JPanel(new GridLayout(1, 2));

    // Добавляю левую и правую панели на общую
    panelAll.add(panelLeft);
    panelAll.add(panelRight);

    // ------------------------------------------------------------------------

    // Добавляю общую панель на фрейм
    frame.add(panelAll);

  }

  /**
   * Делает ГУИ видимым
   */
  public void run() {
    frame.setVisible(true);
  }

  /**
   * Добавляет кнопке слушателя
   */
  private void addButtonListener() {
    calculate.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Получаю пол
        isFemale = (genders.getSelectedItem()).equals("Женщина");

        // Получаю возраст, вес, рост
        try {
          age = Double.parseDouble(enterAgeValue.getText());
          weight = Double.parseDouble(enterWeightValue.getText());
          height = Double.parseDouble(enterHeightValue.getText());

          // Кастомный слушатель делает свою работу
          listener
              .getListener(isFemale, age, weight, height, result)
              .actionPerformed(e);
        }
        // Если что-то не так с вводом, то выводится сообщение об ошибке
        catch (NumberFormatException numberFormatException) {
          result.setText(
              "<html>" +
                  "<p>Что-то пошло не так</p>" +
                  "<br>" +
                  "<p>Проверь, ввёл ли ты все значения? Нужно ввести числа!</p>" +
                  "</html>"
          );
        }

      }
    });
  }

}
