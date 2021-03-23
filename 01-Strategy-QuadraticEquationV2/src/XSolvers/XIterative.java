package XSolvers;

/**
 * Итеративный решатель корней уравнения
 */
public class XIterative implements XBehaviour {

  private double a, b, c; // Параметры a, b, c
  private double x1, x2; // Корни уравнения
  private double y; // Получившийся итеративным путём ответ
  private double loss = Double.POSITIVE_INFINITY; // Ошибка, изначально равняется +оо
  private boolean isTwoSolves; // Булева переменная "У уравнения два решения?"

  /**
   * Конструктор
   *
   * @param a Число А
   * @param b Число В
   * @param c Число С
   */
  public XIterative(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }


  @Override
  public void solve() throws Exception {
    for (double ix = -100.; ix <= 100.; ix += 0.1) {
      y = a * ix * ix + b * ix + c;
      y = Math.abs(y);
      if (loss > y) {
        x2 = x1;
        x1 = ix;
        loss = y;
      }
    }

    isTwoSolves = x1 != x2;
  }


  @Override
  public boolean hasTwoSolves() {
    return isTwoSolves;
  }


  @Override
  public double getX1() {
    return x1;
  }


  @Override
  public double getX2() {
    return x2;
  }

  /**
   * Находит и возвращает единственный корень уравнения
   *
   * @return Единственный корень уравнения
   */
  @Override
  public double getX() {
    return x1;
  }
}
