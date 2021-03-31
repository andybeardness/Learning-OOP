package Application.Factory.Label;

import Application.Colors.Colors;
import Application.Dater.DateLimiter;

import javax.swing.JLabel;
import java.awt.Font;

/**
 * Конкретная реализация фабрики для лейбла
 */
public class FactoryMethodLabelDN extends FactoryMethodLabel {

  private final int hour;

  /**
   * Конструктор
   *
   * @param hourNow Час дня в 24-часовом формате
   */
  public FactoryMethodLabelDN(int hourNow) {
    hour = hourNow;
  }

  /**
   * Метод создающий лейбл
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
}
