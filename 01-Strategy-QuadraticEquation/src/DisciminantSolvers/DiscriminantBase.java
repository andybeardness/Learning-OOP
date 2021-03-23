package DisciminantSolvers;

/**
 * Классический решатель дискриминанта
 */
public class DiscriminantBase implements DiscriminantBehaviour {

  private double d2 = 0.;
  private double d = 0.;

  private double a, b, c;

  private boolean hasTwoSolves = false;

  /**
   * Конструктор
   *
   * @param a Число А
   * @param b Число В
   * @param c Число С
   */
  public DiscriminantBase(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  /**
   * Находит дискриминант или выбрасывает исключение
   *
   * @throws Exception Если дискриминат меньше нуля
   */
  @Override
  public void solve() throws Exception {
    d2 = b * b - 4 * a * c;
    if (d2 > 0) {
      d = Math.sqrt(d2);

      hasTwoSolves = true;
    }
    else if (d2 == 0) {
      d = 0;
      hasTwoSolves = false;
    }
    else {
      throw new Exception("Дискриминант меньше нуля");
    }
  }

  /**
   * Возвращает корень из дискриминанта
   *
   * @return Корень из дискриминанта
   */
  @Override
  public double getD() {
    return d;
  }

  /**
   * Возвращает ответ на вопрос "Имеет ли уравнение два решения?"
   *
   * @return Ответ на вопрос "Имеет ли уравнение два решения?"
   */
  @Override
  public boolean hasTwoSolves() {
    return hasTwoSolves;
  }
}
