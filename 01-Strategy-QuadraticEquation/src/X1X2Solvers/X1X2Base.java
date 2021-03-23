package X1X2Solvers;

/**
 * Решатель корней уравнения
 */
public class X1X2Base implements X1X2Behaviour {

  private double a, b, c;
  private double d;

  /**
   * Конструктор
   *
   * @param a Число А
   * @param b Число В
   * @param c Число С
   */
  public X1X2Base(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  /**
   * Задаёт дискриминат
   *
   * @param d Дискриминант
   */
  @Override
  public void setD(double d) {
    this.d = d;
  }

  /**
   * Находит и возвращает первый корень уравнения
   *
   * @return Первый корень уравнения
   */
  @Override
  public double getX1() {
    return (-b + d) / (2 * a);
  }

  /**
   * Находит и возвращает второй корень уравнения
   *
   * @return Второй корень уравнения
   */
  @Override
  public double getX2() {
    return (-b - d) / (2 * a);
  }

  /**
   * Находит и возвращает единственный корень уравнения
   *
   * @return Единственный корень уравнения
   */
  @Override
  public double getX1X2() {
    return (-b) / (2 * a);
  }
}
