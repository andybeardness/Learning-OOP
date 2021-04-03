import Application.App;

/**
 * Класс запускающий два потока :
 *    1 -- Поток с обработкой ТГ-бота
 *    2 -- Поток с GUI на Swing'е
 */
public class Main {

  /**
   * Точка входа
   *
   * @param args Не используются
   */
  public static void main(String[] args) {
    App.run();
  }
}
