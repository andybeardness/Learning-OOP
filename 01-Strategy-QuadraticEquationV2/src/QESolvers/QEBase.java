package QESolvers;

import XSolvers.XBase;

/**
 * Классический решатель через стандартную формулу дискриминанта
 */
public class QEBase extends QuadraticEquation {

  /**
   * Конструктор, обязательно принимающий параметры уравнения
   *
   * @param a Число А
   * @param b Число В
   * @param c Число С
   */
  public QEBase(double a, double b, double c) {
    super(a, b, c);
    solver = new XBase(a, b, c);
  }
}
