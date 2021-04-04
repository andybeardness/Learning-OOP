package IntegralSolversCollection;

import IntegralSolver.IntegralSolver;
import IntegralSolver.Function;

/**
 * Интеграл х ** 2
 */
public class ISX2 extends IntegralSolver {
  // Левая граница, правая граница, количество отрезков
  double a, b, n;

  // Функция
  Function func = new Function() {
    @Override
    public double f(double x) {
      return x * x;
    }
  };

  /**
   * Конструктор
   *
   * @param a Левая граница
   * @param b Правая грацниа
   * @param n Количество отрезков
   */
  public ISX2(double a, double b, double n) {
    this.a = a;
    this.b = b;
    this.n = n;
  }

  // Возвращает функцию в точке х
  @Override
  public double getFunction(double x) {
    return func.f(x);
  }

  // Возвращает левую границу
  @Override
  public double getLeftBound() {
    return a;
  }

  // Возвращает правую границу
  @Override
  public double getRightBound() {
    return b;
  }

  // Возвращает кол-во отрезков
  @Override
  public double getSteps() {
    return n;
  }

  // Перевод объектв  стрингу
  @Override
  public String toString() {
    return "FUNC : x ** 2 :: a == " + a + ", b == " + b + ", n == " + n;
  }
}
