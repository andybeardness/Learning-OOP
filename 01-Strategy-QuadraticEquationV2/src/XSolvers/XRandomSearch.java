package XSolvers;

import java.util.Random;

/**
 * Рандомный поиск корней уравнения
 */
public class XRandomSearch implements XBehaviour {

  private double a, b, c; // Параметры уравнения
  private double r; // Рандомное число
  private double x; // Единственный Х
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
    this.a = a;
    this.b = b;
    this.c = c;
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
  }

  /**
   * Всегда возвращает false
   *
   * @return Всегда возвращает false
   */
  @Override
  public boolean hasTwoSolves() {
    return false;
  }

  /**
   * Возвращает один, наиболее подходящий, рандомный корень уравнения
   *
   * @return Один, наиболее подходящий, рандомный корень уравнения
   */
  @Override
  public double getX1() {
    return getX();
  }

  /**
   * Возвращает один, наиболее подходящий, рандомный корень уравнения
   *
   * @return Один, наиболее подходящий, рандомный корень уравнения
   */
  @Override
  public double getX2() {
    return getX();
  }

  /**
   * Возвращает один, наиболее подходящий, рандомный корень уравнения
   *
   * @return Один, наиболее подходящий, рандомный корень уравнения
   */
  @Override
  public double getX() {
    return x;
  }
}
