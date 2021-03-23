package QESolvers;

import DisciminantSolvers.DiscriminantBase;
import DisciminantSolvers.DiscriminantBehaviour;
import X1X2Solvers.X1X2Base;
import X1X2Solvers.X1X2Behaviour;

/**
 * Классический решатель через стандартную формулу дискриминанта
 */
public class QEBase extends QuadraticEquation {

  private DiscriminantBehaviour dBeh; // Решатель дискриминанта
  private X1X2Behaviour x1x2Beh; // Решатель х1 и х2

  private double a, b, c; // Параметры уравнения

  private boolean hasTwoSolves; // Булево значение "Имеет ли два решения?"

  /**
   * Конструктор, обязательно принимающий параметры уравнения
   *
   * @param a Число А
   * @param b Число В
   * @param c Число С
   */
  public QEBase(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;

    dBeh = new DiscriminantBase(a, b, c);
    x1x2Beh = new X1X2Base(a, b, c);
  }

  /**
   * Метод находит дискриминант для решателя дискриминантов
   *
   * @throws Exception Если дискриминат меньше нуля
   */
  @Override
  public void solveDiscriminant() throws Exception {
    dBeh.solve();

    hasTwoSolves = dBeh.hasTwoSolves();
  }

  /**
   * Метод находит корни для решателя корней
   *
   * @throws Exception Если дискриминат меньше нуля
   */
  @Override
  public void solveX() throws Exception {
    x1x2Beh.setD(dBeh.getD());
  }

  /**
   * Возвращает дискриминант
   *
   * @return double Дискриминант
   * @throws Exception
   */
  @Override
  public double getDiscriminant() throws Exception {
    return dBeh.getD();
  }

  /**
   * Возвращает ответ на вопрос "У уравнения два корня?"
   *
   * @return boolean Ответ на вопрос "У уравнения два корня?"
   */
  @Override
  public boolean hasTwoSolves() {
    return hasTwoSolves;
  }

  /**
   * Возвращает первый корень уравнения, если корней два
   * В противном случае возвращает единственный корень
   *
   * @return double Первый корень уравнения
   */
  @Override
  public double getX1() {
    return hasTwoSolves ? x1x2Beh.getX1() : x1x2Beh.getX1X2();
  }

  /**
   * Возвращает второй корень уравнения, если корней два
   * В противном случае возвращает единственный корень
   *
   * @return double Второй корень уравнения
   */
  @Override
  public double getX2() {
    return hasTwoSolves ? x1x2Beh.getX2() : x1x2Beh.getX1X2();
  }
}
