package XSolvers;

/**
 * Решатель корней уравнения через дискриминант
 */
public class XBase implements XBehaviour {

  private double a, b, c; // Параметры уравнения
  private double d2, d; // Дискриминант и корень из него
  private boolean isTwoSolves; // Булева переменная "У уравнения два решения?"
  private double x1, x2, x; // х1 и х1 (если два решения), х (если одно решение)

  /**
   * Конструктор
   *
   * @param a Число А
   * @param b Число В
   * @param c Число С
   */
  public XBase(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
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
  @Override
  public double getX1() {
    return x1;
  }

  /**
   * Находит и возвращает второй корень уравнения
   *
   * @return Второй корень уравнения
   */
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
    return x;
  }
}
