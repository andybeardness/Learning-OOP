import QESolvers.QERandomSearch;
import QESolvers.QuadraticEquation;

/*
 * Вывод программы :
 * ------------------------------
 *
 * Дискриминант больше нуля :
 * a == 2.0, b == 5.0, c == -7.0
 * X1 == X2 == -3.4995895139324995
 *
 *
 * Дискриминант равен нулю :
 * a == 16.0, b == -8.0, c == 1.0
 * X1 == X2 == 0.25054746993046706
 *
 *
 * Дискриминант меньше нуля :
 * a == 9.0, b == -6.0, c == 2.0
 * X1 == X2 == 0.33396692296022046
 *
 *
 * Параметр А равен нулю :
 * a == 0.0, b == -6.0, c == 2.0
 * X1 == X2 == 0.3313495684630663
 *
 *
 * Параметр В равен нулю :
 * a == 9.0, b == 0.0, c == 2.0
 * X1 == X2 == -1.8568641637628502E-4
 *
 *
 * Параметр С равен нулю :
 * a == 9.0, b == -6.0, c == 0.0
 * X1 == X2 == 0.666822707876026
 *
 */

/**
 * Класс для проверки рандомной реализации
 */
public class MainRandom {

  /**
   * Точка входа в программу
   *
   * @param args
   */
  public static void main(String[] args) {
    test("Дискриминант больше нуля", 2, 5, -7);
    test("Дискриминант равен нулю", 16, -8, 1);
    test("Дискриминант меньше нуля", 9, -6, 2);
    test("Параметр А равен нулю", 0, -6, 2);
    test("Параметр В равен нулю", 9, 0, 2);
    test("Параметр С равен нулю", 9, -6, 0);
  }

  /**
   * Ф-я теста для решения отдельного уравнения
   *
   * @param s Строка для вывода перед решением
   * @param a Число А
   * @param b Число В
   * @param c Число С
   */
  public static void test(String s, double a, double b, double c) {
    System.out.println("" + s + " :");
    printResults(a, b, c);
  }

  /**
   * Считает и печатает результаты
   *
   * @param a Число А
   * @param b Число В
   * @param c Число С
   */
  public static void printResults(double a, double b, double c) {
    double x1, x2, x;

    System.out.println("a == " + a + ", b == " + b + ", c == " + c);

    QuadraticEquation qe = new QERandomSearch(a, b, c);

    // Этот блок нужен, так как QESolvers.QuadraticEquation выбрасывает исключение,
    // если дискриминант меньше нуля
    try {
      qe.solve();

      // Проверка на количество решений уравнения
      if (qe.hasTwoSolves()) {
        x1 = qe.getX1();
        x2 = qe.getX2();

        System.out.println("X1 == " + x1);
        System.out.println("X2 == " + x2);
      }
      else {
        x = qe.getX();

        System.out.println("X1 == X2 == " + x);
      }
    }
    catch (Exception e) {
      System.out.println("Исключение : " + e.toString());
    }

    System.out.println("\n");
  }
}
