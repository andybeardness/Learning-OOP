package QESolvers;

import XSolvers.XIterative;

/**
 * Итеративный решатель
 * Проходится циклом от -100. до +100. с шагом 0.1
 * Ищет максимально близкий ответ
 */
public class QEIterative extends QEBehaviour {

  /**
   * Конструктор
   *
   * @param a Число А
   * @param b Число В
   * @param c Число С
   */
  public QEIterative(double a, double b, double c) {
    super(a, b, c);
    solver = new XIterative(a, b, c);
  }
}
