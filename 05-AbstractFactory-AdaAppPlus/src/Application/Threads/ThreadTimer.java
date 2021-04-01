package Application.Threads;

import Application.Dater.DateMotion;
import Application.GUI.GUI;

/**
 * Поток для класса, который занимается обновлением времени
 */
public class ThreadTimer implements Runnable {

  GUI gui;

  /**
   * Конструктор
   *
   * @param gui Ссылка на объект ГУИ
   */
  public ThreadTimer(GUI gui) {
    this.gui = gui;
  }

  /**
   * Запуск
   */
  @Override
  public void run() {
    while (true) {
      if (!DateMotion.getDateString().equals(gui.getDateString())) {
        gui.updateLabel(DateMotion.getDateString());
      }
    }
  }
}
