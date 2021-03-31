package Application.Factory.Panel;

import Application.Colors.Colors;
import Application.Dater.DateLimiter;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * Конкретная реализация фабрики для панели
 */
public class FactoryMethodPanelDN extends FactoryMethodPanel {

  private final int hour;

  /**
   * Конструктор
   *
   * @param hourNow Час дня в 24-часовом формате
   */
  public FactoryMethodPanelDN(int hourNow) {
    hour = hourNow;
  }

  /**
   * Метод создающий панель
   *
   * @return Панель
   */
  @Override
  public JPanel createPanel() {
    JPanel panel = new JPanel(new GridLayout(2, 1));
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
}
