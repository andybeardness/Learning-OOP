package QESolvers;

import XSolvers.XRandomSearch;

/**
 * Рандомный решатель
 * Делает 10к подборов от -10. до +10.
 * Ищет максимально близкий ответ
 */
public class QERandomSearch extends QuadraticEquation {

  /**
   * Конструктор
   *
   * @param a Число А
   * @param b Число В
   * @param c Число С
   */
  public QERandomSearch(double a, double b, double c) {
    super(a, b, c);
    solver = new XRandomSearch(a, b, c);
  }
}
