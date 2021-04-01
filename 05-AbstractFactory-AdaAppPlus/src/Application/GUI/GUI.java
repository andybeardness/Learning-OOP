package Application.GUI;

import Application.Dater.DateMotion;
import Application.Factory.AbstractFactoryGUI;
import Application.Factory.Factory;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ГУИ
 */
public class GUI {

  // Объекты ГУИ
  private JFrame frame;
  private JPanel panel;
  private JLabel label;
  private JButton button;
  private JLabel image;

  // Объект стринговый даты и времени
  private String dateString;

  // Фабрики
  private AbstractFactoryGUI GUIFactory;

  /**
   * Конструктор
   *
   * @param hour Час дня в 24-часовом формате
   */
  public GUI(int hour, String lang, String country) {
    // Получаем дату
    dateString = DateMotion.getDateString();

    // Инициализируем абстрактную фабрику
    GUIFactory = new Factory(hour, lang, country);

    // Создаём объекты
    frame = GUIFactory.createFrame();
    label = GUIFactory.createLabel();
    button = GUIFactory.createButton();
    panel = GUIFactory.createPanel();
    image = GUIFactory.createImage();

    // Добавляем объекты на панель
    panel.add(label);
    panel.add(button);
    panel.add(image);

    // Добавляем панель на фрейм
    frame.add(panel);
  }

  /**
   * Метод, делающий фрейм видимым
   */
  public void run() {
    frame.setVisible(true);
  }

  /**
   * Метод, обновляющий лейбл новой стрингой
   *
   * @param newString Новая стринга даты-времени
   */
  public void updateLabel(String newString) {
    label.setText(newString);
  }

  /**
   * Метод, возвращающий дату и время в виде стрингИ
   *
   * @return Стринговая дата-время
   */
  public String getDateString() {
    return dateString;
  }

}
