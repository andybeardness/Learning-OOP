package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.List;

/**
 * Тут все методы GUI
 */
public class GUI implements GuiFace {

  // Элементы GUI
  private JFrame frame;
  private JPanel panel;
  private JLabel label;
  private JButton button;
  private Container container;

  /**
   * Инициализация ГУИ
   *
   * Делает всё, кроме последнего метода "setFrameVisible"
   */
  public void initGUI() {
    setFrame();
    setPanel();
    setLabel();
    setButton();
    addElements();
    setContainer();
    addPanel();
  }

  /**
   * Метод, который делает ГУИ видимым
   */
  public void run() {
    setFrameVisible();
  }

  /**
   * Одновляет список в элементе label
   *
   * @param names
   */
  public void updateList(List<String> names) {
    // Тут было удобно пользоваться StringBuilder для собирания текста label
    StringBuilder text = new StringBuilder("<html><p>Список забывчивых :</p>");

    for (String name : names) {
      text.append("<br>");
      text.append("<p>").append(name).append("</p>");
    }

    text.append("</html>");

    label.setText(String.valueOf(text));
  }

  /**
   * Возвращает ссылку на button, чтобы установить ему слушателя
   * Это нужно, чтобы GUI не знал о существовании App
   *
   * @return Кнопка напоминания
   */
  public JButton getButton() {
    return button;
  }

  /**
   * Создаёт и настраивает frame
   */
  private void setFrame() {
    frame = new JFrame("Напоминание через TG с GUI");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
  }

  /**
   * Создаёт panel с сеткой 1х2
   */
  private void setPanel() {
    panel = new JPanel(new GridLayout(1, 2));
  }

  /**
   * Создаёт и настраивает label
   */
  private void setLabel() {
    label = new JLabel("<html><p>Список забывчивых :</p></html>\n");
    label.setVerticalAlignment(JLabel.TOP);
    label.setHorizontalAlignment(JLabel.CENTER);
  }

  /**
   * Создаёт button
   */
  private void setButton() {
    button = new JButton("Напомнить!");
  }

  /**
   * Добавляет на panel элемненты : label и button
   */
  private void addElements() {
    panel.add(label);
    panel.add(button);
  }

  /**
   * Создаёт container
   */
  private void setContainer() {
    container = frame.getContentPane();
  }

  /**
   * Добавляет в container элемент panel
   */
  private void addPanel() {
    container.add(panel);
  }

  /**
   * Делает frame видимым
   */
  private void setFrameVisible() {
    frame.setVisible(true);
  }

}
