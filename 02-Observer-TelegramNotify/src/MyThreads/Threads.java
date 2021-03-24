package MyThreads;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, который собирает два потока вместе и запускает
 *
 * Содержит только статические методы и атрибуты
 */
public class Threads {

  // Список потоков
  private static List<Thread> threadList;

  /**
   * Делает всю работу по запуску
   */
  public static void runALlThreads() {
    init();
    addAll();
    runALl();
  }

  /**
   * Инициализирует список для объектов Thread
   */
  private static void init() {
    threadList = new ArrayList<>();
  }

  /**
   * Добавляет два потока в список потоков
   */
  private static void addAll() {
    threadList.add(new ThreadGUI());
    threadList.add(new ThreadTG());
  }

  /**
   * Через цикл запускает каждый поток
   */
  private static void runALl() {
    for (Thread t : threadList) {
      t.start();
    }
  }
}
