package PlainNumberBase;

/**
 * Класс приложения, который принимает в конструкторе решатель с интерфейсом PNBase
 */
public class App {
  PNBase pn;

  /**
   * Конструктор
   *
   * @param pn Решатель
   */
  public App(PNBase pn) {
    this.pn = pn;
  }

  /**
   * Проверяет число на простоту
   *
   * @param number Проверочное число
   * @return Ответ на вопрос "Число простое?"
   */
  public boolean isPlainNumber(int number) {
    pn.setNumber(number);
    return pn.isPlain();
  }

}
