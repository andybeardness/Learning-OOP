import PlainNumberBase.App;
import PlainNumberBase.PNBase;
import PlainNumberNew.PNNAdapter;

/**
 * Упрощённая реализация проверки простоты числа
 * Добавлена с помощью Адаптера
 *
 * Вывод программы :
 *
 * Number 10 is plain? :: false
 * Number 15 is plain? :: false
 * Number 17 is plain? :: true
 * Number 21 is plain? :: false
 * Number 97 is plain? :: true
 */
public class MainNew {
  public static void main(String[] args) {

    int[] numbers = {10, 15, 17, 21, 97};

    PNBase pnBase = new PNNAdapter();
    App app = new App(pnBase);

    for (int number : numbers) {
      System.out.println("Number " + number + " is plain? :: " + app.isPlainNumber(number));
    }
  }
}
