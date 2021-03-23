package XSolvers;

import java.util.Random;

/**
 * Рандомный поиск корней уравнения
 */
public class XRandomSearch extends XBehaviour {

  private double r; // Рандомное число
  private double y; // Полученый ответ при подстановке рандомного числа

  private double loss = Double.POSITIVE_INFINITY; // Ошибка, изначально равняется +оо
  private Random R = new Random(); // Объект, отвечающий за рандом

  /**
   * Конструктор, обязательно принимающий параметры уравнения
   *
   * @param a Число А
   * @param b Число В
   * @param c Число С
   */
  public XRandomSearch(double a, double b, double c) {
    super(a, b, c);
  }

  /**
   * Решает квадратное уравнение с помощью великого рандома
   * Делает 10к рандомных подстановок от -10.0 до +10.0
   * Выбирая лучшую
   *
   * @throws Exception Никогда не выбрасывает
   */
  @Override
  public void solve() throws Exception {
    for (int i = 0; i < 10000; i++) {
      r = R.nextDouble() * 20. - 10.;
      y = a * r * r + b * r + c;
      y = Math.abs(y);
      if (y < loss) {
        x = r;
        loss = y;
      }
    }
    x1 = x;
    x2 = x;
    isTwoSolves = false;
  }
}
