package GUI;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import TGBot.Bot;

/**
 * Тут все методы GUI
 */
public class GUI {

  // Элементы GUI
  private static JFrame frame;
  private static JPanel panel;
  private static JLabel label;
  private static JButton button;
  private static Container container;

  // Бот
  private static Bot bot;

  /**
   * Метод, который запускает всё по очереди
   */
  public static void run() {
    setFrame();
    setPanel();
    setLabel();
    setButton();
    addElements();
    setContainer();
    addPanel();
    setFrameVisible();
  }

  /**
   * Регистрирет бота в GUI
   *
   * @param b Экземпляр бота
   */
  public static void registerBotInGUI(Bot b) {
    bot = b;
  }

  /**
   * Одновляет список в элементе label
   *
   * @param names
   */
  public static void updateList(List<String> names) {
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
   * Создаёт и настраивает frame
   */
  private static void setFrame() {
    frame = new JFrame("Напоминание через TG с GUI");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
  }

  /**
   * Создаёт panel
   */
  private static void setPanel() {
    panel = new JPanel(new GridLayout(1, 2));
  }

  /**
   * Создаёт и настраивает label
   */
  private static void setLabel() {
    label = new JLabel("<html><p>Список забывчивых :</p></html>\n");
    label.setVerticalAlignment(JLabel.TOP);
    label.setHorizontalAlignment(JLabel.CENTER);
  }

  /**
   * Создаёт и настраивает button на взаимодействей с ТГ-ботом
   */
  private static void setButton() {
    button = new JButton("Напомнить!");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        bot.sendMessages();
      }
    });
  }

  /**
   * Добавляет на panel элемненты : label и button
   */
  private static void addElements() {
    panel.add(label);
    panel.add(button);
  }

  /**
   * Создаёт container
   */
  private static void setContainer() {
    container = frame.getContentPane();
  }

  /**
   * Добавляет в container элемент panel
   */
  private static void addPanel() {
    container.add(panel);
  }

  /**
   * Делает frame видимым
   */
  private static void setFrameVisible() {
    frame.setVisible(true);
  }

}
