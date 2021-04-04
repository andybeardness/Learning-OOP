package PlainNumberBase;

/**
 * Базовый решатель
 */
public class PlainNumberBaseSolver implements PNBase {

  private int number; // Число

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
   * Проверка на простоту
   * Плохо, что проходится циклом от 2 до (самого числа - 1)
   * Это нерационально, поэтому в новой реализации я это пофиксил
   *
   * @return Ответ на вопрос "Число простое?"
   */
  @Override
  public boolean isPlain() {
    for (int i = 2; i < number; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
