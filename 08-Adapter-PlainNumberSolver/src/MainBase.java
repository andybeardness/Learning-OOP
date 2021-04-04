import PlainNumberBase.App;
import PlainNumberBase.PNBase;
import PlainNumberBase.PlainNumberBaseSolver;

/**
 * Базовая реализация проверки простоты числа
 *
 * Вывод программы :
 *
 * Number 10 is plain? :: false
 * Number 15 is plain? :: false
 * Number 17 is plain? :: true
 * Number 21 is plain? :: false
 * Number 97 is plain? :: true
 */
public class MainBase {
  public static void main(String[] args) {

    int[] numbers = {10, 15, 17, 21, 97};

    PNBase pnBase = new PlainNumberBaseSolver();
    App app = new App(pnBase);

    for (int number : numbers) {
      System.out.println("Number " + number + " is plain? :: " + app.isPlainNumber(number));
    }
  }
}
