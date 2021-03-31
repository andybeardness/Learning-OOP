package AppHardCore;

import AppCalories.GUI.GUI;

/**
 * Класс, расширяющий возможности стандартного App
 */
public class AppHardCore {

  /**
   * Запуск
   */
  public void run() {
    new GUI(
        "Рассчет калорий для хардкорщиков",
        new CaloriesButtonListenerHardCore()
    ).run();
  }

}
