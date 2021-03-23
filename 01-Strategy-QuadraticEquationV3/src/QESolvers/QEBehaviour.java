package QESolvers;

import XSolvers.XBehaviour;

/**
 * Абстрактный класс, от которого наследуются все "решатели" квадратных уравнений
 *
 * Есть множество способов решить квадратное уравнение
 * Тут предлагаю абстрактный решатель, который требует одно :
 *    -- Решатель с интерфейсом XBehaviour
 *
 * Это минус такой реализации, ведь есть способы решить квадратное уравнение,
 * не прибегая к дискриминанту
 *
 * Этим примером хотел лишь показать реализацию паттерна "Стратегия"
 */
abstract public class QEBehaviour {
  private double a, b, c;
  protected boolean isTwoSolves;
  protected XBehaviour solver;

  /**
   * Конструктор
   *
   * @param a Число А
   * @param b Число В
   * @param c Число С
   */
  public QEBehaviour(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  /**
   * Решает квадратное уравнение
   *
   * @throws Exception Возможность выбросить исключение зависит от реализации
   */
  public void solve() throws Exception {
    solver.solve();
    isTwoSolves = solver.hasTwoSolves();
  }

  /**
   * Возвращает ответ на вопрос "У уравнения два корня?"
   *
   * @return Ответ на вопрос "У уравнения два корня?"
   */
  public boolean hasTwoSolves() {
    return isTwoSolves;
  }

  /**
   * Находит и возвращает первый корень уравнения
   *
   * @return Первый корень уравнения
   */
  public double getX1() {
    return solver.getX1();
  }

  /**
   * Находит и возвращает второй корень уравнения
   *
   * @return Второй корень уравнения
   */
  public double getX2() {
    return solver.getX2();
  }

  /**
   * Находит и возвращает единственный корень уравнения
   *
   * @return Единственный корень уравнения
   */
  public double getX() {
    return solver.getX();
  }
}
