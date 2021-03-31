package AppCalories;

import AppCalories.GUI.CaloriesButtonListener;
import AppCalories.GUI.GUI;

/**
 * Класс приложения
 * Запускает ГУИ
 */
public class App {

  /**
   * Запуск ГУИ
   */
  public void run() {
    new GUI(
        "Раcсчитать калории онлайн без смс и регистрации сейчас в два клика!",
        new CaloriesButtonListener()).run();
  }
}
