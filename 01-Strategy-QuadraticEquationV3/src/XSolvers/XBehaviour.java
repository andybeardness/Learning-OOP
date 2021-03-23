package XSolvers;

/**
 * Интерфейс для решателя корней уравнения
 */
abstract public class XBehaviour {
  protected double a, b, c; // Параметры уравнения
  protected double x1, x2, x; // х1 и х1 (если два решения), х (если одно решение)
  protected boolean isTwoSolves; // Булева переменная "У уравнения два решения?"

  /**
   * Конструктор
   *
   * @param a Число А
   * @param b Число В
   * @param c Число С
   */
  public XBehaviour(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  /**
   * Абстрактный метод для решения уравнения своим способом
   */
  abstract public void solve() throws Exception; // Решает уравнение своим способом


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
    return x1;
  }

  /**
   * Находит и возвращает второй корень уравнения
   *
   * @return Второй корень уравнения
   */
  public double getX2() {
    return x2;
  }

  /**
   * Находит и возвращает единственный корень уравнения
   *
   * @return Единственный корень уравнения
   */
  public double getX() {
    return x;
  }
}
