import QESolvers.QEBase;
import QESolvers.QuadraticEquation;

/*
 * Вывод программы :
 *
 * Дискриминант больше нуля :
 * a == 2.0, b == 5.0, c == -7.0
 * sqrt(D) == 9.0
 * X1 == 1.0
 * X2 == -3.5
 *
 *
 * Дискриминант равен нулю :
 * a == 16.0, b == -8.0, c == 1.0
 * sqrt(D) == 0.0
 * X1 == X2 == 0.25
 *
 *
 * Дискриминант меньше нуля :
 * a == 9.0, b == -6.0, c == 2.0
 * У условия (9.0, -6.0, 2.0) дискриминант < 0!
 *
 */

/**
 * Класс для проверки реализации
 */
public class Main {

  /**
   * Точка входа в программу
   *
   * @param args
   */
  public static void main(String[] args) {
    test("Дискриминант больше нуля", 2, 5, -7);
    test("Дискриминант равен нулю", 16, -8, 1);
    test("Дискриминант меньше нуля", 9, -6, 2);
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
    double d, x1, x2, x1x2;
    boolean hasTwoSolves;

    System.out.println("a == " + a + ", b == " + b + ", c == " + c);

    QuadraticEquation qe = new QEBase(a, b, c);

    // Этот блок нужен, так как QESolvers.QuadraticEquation выбрасывает исключение,
    // если дискриминант меньше нуля
    try {
      qe.solveDiscriminant();
      qe.solveX();

      d = qe.getDiscriminant();
      hasTwoSolves = qe.hasTwoSolves();

      System.out.println("sqrt(D) == " + d);

      // Проверка на количество решений уравнения
      if (hasTwoSolves) {
        x1 = qe.getX1();
        x2 = qe.getX2();

        System.out.println("X1 == " + x1);
        System.out.println("X2 == " + x2);
      }
      else {
        x1x2 = qe.getX1();

        System.out.println("X1 == X2 == " + x1x2);
      }
    }
    catch (Exception e) {
      System.out.println("У условия (" + a + ", " + b + ", " + c + ") дискриминант < 0!");
    }

    System.out.println("\n");
  }
}
