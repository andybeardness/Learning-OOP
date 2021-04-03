package MyThreads;

import GUI.GUI;

/**
 * Поток GUI
 */
public class ThreadGUI extends Thread {

  GUI gui; // Объект ГУИ

  /**
   * Конструктор
   *
   * @param gui Объект ГУИ
   */
  public ThreadGUI(GUI gui) {
    this.gui = gui;
  }

  /**
   * Собирает и отрисовывает GUI
   */
  @Override
  public void run() {
    gui.run();
  }
}
