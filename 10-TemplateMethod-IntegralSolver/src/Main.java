import IntegralSolversCollection.IS10X;
import IntegralSolversCollection.ISX2;

/**
 * Вывод программы :
 *
 * FUNC : 10 * x :: a == 0.0, b == 1.0, n == 1000.0 >>> 4.995000000000004
 * FUNC : x ** 2 :: a == 0.0, b == 1.0, n == 1000.0 >>> 0.33283350000000095
 *
 * Верные ответы : 5 и 1/3
 *
 * Достаточно близко для левостороннего метода
 *
 */
public class Main {
  public static void main(String[] args) {
    IS10X is10x = new IS10X(0, 1, 1000);
    System.out.println(is10x.toString() + " >>> " + is10x.solve());

    ISX2 isx2 = new ISX2(0, 1, 1000);
    System.out.println(isx2.toString() + " >>> " + isx2.solve());
  }
}
