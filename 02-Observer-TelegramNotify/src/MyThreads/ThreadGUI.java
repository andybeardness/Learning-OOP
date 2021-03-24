package MyThreads;

import GUI.GUI;

/**
 * Поток GUI
 */
public class ThreadGUI extends Thread {

  /**
   * Собирает и отрисовывает GUI
   */
  @Override
  public void run() {
    GUI.run();
  }
}
