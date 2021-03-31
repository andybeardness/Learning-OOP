package Application.Factory.Button;

import Application.Colors.Colors;
import Application.Dater.DateLimiter;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Font;

/**
 * Конкретная реализация фабрики для кнопки
 */
public class FactoryMethodButtonDN extends FactoryMethodButton {

  private final int hour;

  /**
   * Конструктор
   *
   * @param hourNow Час дня в 24-часовом формате
   */
  public FactoryMethodButtonDN(int hourNow) {
    hour = hourNow;
  }

  /**
   * Метод создающий кнопку
   *
   * @return Кнопка
   */
  @Override
  public JButton createButton() {
    JButton button = new JButton("Кнопка для красоты");
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

    return button;
  }

}
