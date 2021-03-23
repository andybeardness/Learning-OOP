package XSolvers;

/**
 * Решатель корней уравнения через дискриминант
 */
public class XBase extends XBehaviour {

  private double d2, d; // Дискриминант и корень из него

  /**
   * Конструктор
   *
   * @param a Число А
   * @param b Число В
   * @param c Число С
   */
  public XBase(double a, double b, double c) {
    super(a, b, c);
  }

  /**
   * Решает квадратное уравнение через дискриминант
   *
   * @throws Exception Если у уравнения отрицательный дискриминант или А == 0
   */
  @Override
  public void solve() throws Exception {
    // Проверка на полноту уравнения
    if (a == 0) {
      throw new Exception("Это не квадратное уравнение! a == 0!");
    }

    // Находим дискриминант
    d2 = b * b - 4 * a * c;

    // Находим корни
    if (d2 > 0) {
      isTwoSolves = true;
      d = Math.sqrt(d2);
      x1 = (-b + d) / (2 * a);
      x2 = (-b - d) / (2 * a);
      x = x1; // Защита от случайного использования getX() вместо getX1() или getX2()
    }
    else if (d2 == 0) {
      isTwoSolves = false;
      d = 0;
      x = (-b) / (2 * a);
      x1 = x; // Защита от случайного использования getX1() или getX2()...
      x2 = x; // вместо getX()
    }
    else {
      throw new Exception("Дискриминант меньше нуля");
    }
  }
}
