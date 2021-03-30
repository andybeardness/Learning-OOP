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
    new GUI(new CaloriesButtonListener()).run();
  }
}
