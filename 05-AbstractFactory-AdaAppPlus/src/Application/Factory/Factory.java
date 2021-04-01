package Application.Factory;

import Application.Colors.Colors;
import Application.Dater.DateLimiter;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Конкретная абстраткная фабрика
 */
public class Factory implements AbstractFactoryGUI {

  int hour; // Час суток
  String lang; // Язык
  String country; // Страна

  private final String IMAGE_PATH = "src/Application/flags/"; // Путь до картинок с флагами

  /**
   * Конструктор
   *
   * @param hour Час суток
   * @param lang Язык
   * @param country Страна
   */
  public Factory(int hour, String lang, String country) {
    this.hour = hour;
    this.lang = lang;
    this.country = country;
  }

  /**
   * Создает фрейм
   *
   * @return Фрейм
   */
  @Override
  public JFrame createFrame() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 400);

    switch (lang) {
      case "ru":
        frame.setTitle("Адаптиное ПО >> Время + Язык + Страна");
        break;
      case "fr":
        frame.setTitle("Logiciel adaptatif >> Heure + Langue + Pays");
        break;
      case "ch":
        frame.setTitle("自适应软件>>时间+语言+国家");
        break;
      default:
        frame.setTitle("Adaptive software >> Time + Language + Country");
        break;
    }

    return frame;
  }

  /**
   * Создает панель
   *
   * @return Панель
   */
  @Override
  public JPanel createPanel() {
    JPanel panel = new JPanel(new GridLayout(3, 1));
    panel.setBorder(
        BorderFactory.createEmptyBorder(
            15, 15, 15, 15
        )
    );

    if (DateLimiter.isNight(hour)) {
      panel.setBackground(Colors.COLOR_BACKGROUND);
    }
    else {
      panel.setBackground(Colors.COLOR_FOREGROUND);
    }

    return panel;
  }

  /**
   * Создает кнопку
   *
   * @return Лейбл
   */
  @Override
  public JLabel createLabel() {
    JLabel label = new JLabel();
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setOpaque(true);
    label.setFont(new Font(label.getFont().getName(), Font.BOLD, 30));

    if (DateLimiter.isNight(hour)) {
      label.setBackground(Colors.COLOR_BACKGROUND);
      label.setForeground(Colors.COLOR_RED);
    }
    else {
      label.setBackground(Colors.COLOR_FOREGROUND);
      label.setForeground(Colors.COLOR_PURPLE);
    }

    return label;
  }

  /**
   * Создает кнопку
   *
   * @return Кнопка
   */
  @Override
  public JButton createButton() {
    JButton button = new JButton();
    button.setFont(new Font(button.getFont().getName(), Font.BOLD, 30));
    button.setFocusPainted(false);

    if (DateLimiter.isNight(hour)) {
      button.setBackground(Colors.COLOR_BACKGROUND);
      button.setForeground(Colors.COLOR_GREEN);
      button.setBorder(new LineBorder(Colors.COLOR_GREEN));

    }
    else {
      button.setBackground(Colors.COLOR_FOREGROUND);
      button.setForeground(Colors.COLOR_ORANGE);
      button.setBorder(new LineBorder(Colors.COLOR_ORANGE));

    }

    switch (lang) {
      case "ru":
        button.setText("Кнопка для красоты");
        break;
      case "fr":
        button.setText("Bouton beauté");
        break;
      case "ch":
        button.setText("美容按钮");
        break;
      default:
        button.setText("Beauty button");
        break;
    }

    return button;
  }

  /**
   * Создает картинку
   *
   * @return Картинка
   */
  @Override
  public JLabel createImage() {
    JLabel label = new JLabel();
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setOpaque(true);

    if (DateLimiter.isNight(hour)) {
      label.setBackground(Colors.COLOR_BACKGROUND);
      label.setForeground(Colors.COLOR_RED);
    }
    else {
      label.setBackground(Colors.COLOR_FOREGROUND);
      label.setForeground(Colors.COLOR_PURPLE);
    }

    File file;

    try {
      switch (country) {
        case "RU":
          file = new File(IMAGE_PATH + "RU.png");
          break;
        case "FR":
          file = new File(IMAGE_PATH + "FR.png");
          break;
        case "CH":
          file = new File(IMAGE_PATH + "CH.png");
          break;
        default:
          file = new File(IMAGE_PATH + "EN.png");
          break;
      }

      BufferedImage img = ImageIO.read(file);
      ImageIcon icon = new ImageIcon(img);
      label.setIcon(icon);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    return label;
  }
}