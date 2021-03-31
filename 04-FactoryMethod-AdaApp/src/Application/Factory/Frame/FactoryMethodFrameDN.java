package Application.Factory.Frame;

import Application.Dater.DateLimiter;

import javax.swing.JFrame;

/**
 * Конкретная реализация фабрики для фрейма
 */
public class FactoryMethodFrameDN extends FactoryMethodFrame {

  private final int hour;

  /**
   * Конструктор
   *
   * @param hourNow Час дня в 24-часовом формате
   */
  public FactoryMethodFrameDN(int hourNow) {
    hour = hourNow;
  }

  /**
   * Метод создающий фрейм
   *
   * @return Фрейм
   */
  @Override
  public JFrame createFrame() {
    JFrame frame = new JFrame();
    if (DateLimiter.isNight(hour)) {
      frame.setTitle("Адаптивное ПО | Тема : Ночь");

    }
    else {
      frame.setTitle("Адаптивное ПО | Тема : День");
    }
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 250);

    return frame;
  }
}
