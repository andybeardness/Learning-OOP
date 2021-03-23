package XSolvers;

/**
 * Итеративный решатель корней уравнения
 */
public class XIterative extends XBehaviour {

  private double y; // Получившийся итеративным путём ответ
  private double loss = Double.POSITIVE_INFINITY; // Ошибка, изначально равняется +оо

  /**
   * Конструктор
   *
   * @param a Число А
   * @param b Число В
   * @param c Число С
   */
  public XIterative(double a, double b, double c) {
    super(a, b, c);
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
    x = x1;
  }
}
