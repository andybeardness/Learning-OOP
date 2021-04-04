package PlainNumberNew;

import PlainNumberBase.PNBase;

/**
 * Адаптер нового решателя к интерфейсу PNBase
 */
public class PNNAdapter implements PNBase {

  PNNew pnn; // Новый решатель

  /**
   * Конструктор Адаптера
   * С инициализацией нового решателя
   */
  public PNNAdapter() {
    pnn = new PlainNumberNewSolver();
  }

  /**
   * Устанавливает число
   *
   * @param n Число
   */
  @Override
  public void setNumber(int n) {
    pnn.setNumber(n);
    pnn.initCenter();
  }

  /**
   * Проверка на простоту
   *
   * @return Ответ на вопрос "Число простое?"
   */
  @Override
  public boolean isPlain() {
    return pnn.isPlain();
  }
}
