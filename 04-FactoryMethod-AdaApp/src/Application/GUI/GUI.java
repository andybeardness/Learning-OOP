package Application.GUI;

import Application.Dater.DateMotion;
import Application.Factory.Button.FactoryMethodButton;
import Application.Factory.Button.FactoryMethodButtonDN;
import Application.Factory.Frame.FactoryMethodFrame;
import Application.Factory.Frame.FactoryMethodFrameDN;
import Application.Factory.Label.FactoryMethodLabel;
import Application.Factory.Label.FactoryMethodLabelDN;
import Application.Factory.Panel.FactoryMethodPanel;
import Application.Factory.Panel.FactoryMethodPanelDN;

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

  // Объект стринговый даты и времени
  private String dateString;

  // Фабрики
  private FactoryMethodFrame factoryFrame;
  private FactoryMethodPanel factoryPanel;
  private FactoryMethodLabel factoryLabel;
  private FactoryMethodButton factoryButton;

  /**
   * Конструктор
   *
   * @param hour Час дня в 24-часовом формате
   */
  public GUI(int hour) {
    // Получаем дату
    dateString = DateMotion.getDateString();

    // Инициализируем фабрики
    factoryFrame = new FactoryMethodFrameDN(hour);
    factoryPanel = new FactoryMethodPanelDN(hour);
    factoryLabel = new FactoryMethodLabelDN(hour);
    factoryButton = new FactoryMethodButtonDN(hour);

    // Создаём объекты
    frame = factoryFrame.createFrame();
    label = factoryLabel.createLabel();
    button = factoryButton.createButton();
    panel = factoryPanel.createPanel();

    // Добавляем объекты на панель
    panel.add(label);
    panel.add(button);

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
