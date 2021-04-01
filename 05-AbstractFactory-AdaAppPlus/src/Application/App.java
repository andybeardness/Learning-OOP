package Application;

import Application.GUI.GUI;
import Application.Threads.ThreadGUI;
import Application.Threads.ThreadTimer;

import java.util.Calendar;

/**
 * Класс приложения
 */
public class App {

  int hour; // Час суток
  String lang; // Язык
  String country; // Страна

  GUI gui; // ГУИ

  Runnable threadGUI; // Поток для ГУИ
  Runnable threadTimer; // Поток для Обновляльщика времени

  /**
   * Конструктор и с инициализацией и подготовкой объектов
   */
  public App() {

    // Получаем переменные извне
    hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    lang = System.getProperty("user.language");
    country = System.getProperty("user.country");

    // ГУИ
    gui = new GUI(hour, lang, country);

    // Потоки
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
