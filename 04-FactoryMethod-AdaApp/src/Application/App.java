package Application;

import Application.GUI.GUI;
import Application.Threads.ThreadGUI;
import Application.Threads.ThreadTimer;

import java.util.Calendar;

/**
 * Класс приложения
 */
public class App {

  int hour; // Час

  GUI gui; // ГУИ

  Runnable threadGUI; // Поток для ГУИ
  Runnable threadTimer; // Поток для Обновляльщика времени

  /**
   * Конструктор и с инициализацией и подготовкой объектов
   */
  public App() {

    hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

    gui = new GUI(hour);

    threadGUI = new ThreadGUI(gui);
    threadTimer = new ThreadTimer(gui);
  }

  /**
   * Запуск
   */
  public void run() {
    threadGUI.run();
    threadTimer.run();
  }
}
