package Application.Threads;

import Application.GUI.GUI;

/**
 * Поток для ГУИ
 */
public class ThreadGUI implements Runnable {

  GUI gui;

  /**
   * Конструктор
   *
   * @param gui Ссылка на объект ГУИ
   */
  public ThreadGUI(GUI gui) {
    this.gui = gui;
  }

  /**
   * Запуск
   */
  @Override
  public void run() {
    gui.run();
  }
}
