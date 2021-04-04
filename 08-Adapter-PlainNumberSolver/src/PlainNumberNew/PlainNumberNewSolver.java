package PlainNumberNew;

/**
 * Новый решатель, который не делает лишнюю работу в цикле
 */
public class PlainNumberNewSolver implements PNNew {

  int number; // Число
  int center; // Центр, он же -- конец цикла

  /**
   * Устанавливает число
   *
   * @param n Число
   */
  @Override
  public void setNumber(int n) {
    number = n;
  }

  /**
   * Инициализирует центер
   */
  @Override
  public void initCenter() {
    center = number / 2;
  }

  /**
   * Проверка, имеет ли в делителях число d
   *
   * @param d Делитель
   * @return Число % d == 0 ?
   */
  @Override
  public boolean hasDelimiter(int d) {
    return number % d == 0;
  }

  /**
   * Новая улучшенная проверка на простоту
   *
   * @return Ответ на вопрос "Число простое?"
   */
  @Override
  public boolean isPlain() {
    for (int i = 2; i < center; i++) {
      if (hasDelimiter(i)) {
        return false;
      }
    }
    return true;
  }
}
