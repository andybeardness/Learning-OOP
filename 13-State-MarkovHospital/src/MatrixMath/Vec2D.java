package MatrixMath;

import java.text.DecimalFormat;

/**
 * Класс 2Д вектора, ака матрицы
 */
public class Vec2D {

  private static final int DIMS = 4; // Квадратная матрица 4х4

  private int[][] values = new int[DIMS][DIMS]; // Тут хранятся количество переходов
  private double[][] percents = new double[DIMS][DIMS]; // Тут хранятся вероятности переходов

  private static DecimalFormat df = new DecimalFormat("0.00"); // Форматирующий объект для красоты представления

  /**
   * Конструктор, создающий нулевую матрицу
   *
   */
  public Vec2D() {
    for (int i = 0; i < DIMS; i++) {
      for (int j = 0; j < DIMS; j++) {
        values[i][j] = 0;
        percents[i][j] = 0;
      }
    }
  }

  /**
   * Конструктор, копирующий вектор
   *
   * @param vec Вектор, который копируется
   */
  public Vec2D(Vec2D vec) {
    for (int i = 0; i < DIMS; i++) {
      for (int j = 0; j < DIMS; j++) {
        values[i][j] = vec.values[i][j];
        percents[i][j] = vec.percents[i][j];
      }
    }
  }

  /**
   * Статический метод
   * Перемножения матриц
   *
   * @param v1 Матрица № 1
   * @param v2 Матрица № 2
   * @return Матрица № 1 * Матрица № 2
   */
  public static Vec2D getMul(Vec2D v1, Vec2D v2) {
    Vec2D result = new Vec2D();

    // Классическое копирование через три цикла
    // Зато своё :)
    for (int i = 0; i < DIMS; i++) {
      for (int j = 0; j < DIMS; j++) {
        for (int k = 0; k < DIMS; k++) {
          result.percents[i][j] += v1.percents[i][k] * v2.percents[k][j];
        }
      }
    }

    return result;
  }

  /**
   * Статический метод
   * Возведение матрицы в 20ую степень
   *
   * @param vec Матрица
   * @return Матрица ^ 20
   */
  public static Vec2D getPower(Vec2D vec) {
    Vec2D v1 = new Vec2D(vec);
    Vec2D v2 = new Vec2D(vec);

    // Возведение в 20ую степень хватает с головой
    // Но если нужна скорость, то можно ограничится 10-13 степенями
    for (int p = 0; p < 20; p++) {
      v1 = getMul(v1, v2);
    }

    return v1;
  }

  /**
   * Статический метод
   * Для отображения матрицы вероятностей
   * Создавался для отладки
   *
   * @param vec
   */
  public static void show(Vec2D vec) {
    for (int i = 0; i < DIMS; i++) {
      for (int j = 0; j < DIMS; j++) {
        System.out.print(
          df.format(vec.percents[i][j]) + " :: ");
      }
      System.out.println("\b\b\b\b"); // Эта строка нужна для удаления крайних правых символов,
                                      // там где двоеточия
    }
    System.out.println("");
  }

  /**
   * Метод, который увеличивает один элемент матрицы на 1 (инкремент)
   *
   * @param i Номет строки
   * @param j Номер столбца
   */
  public void incrementElement(int i, int j) {
    values[i][j]++;
    updatePercents();
  }

  /**
   * Возвращает матрицу вероятностей в HTML разметке
   *
   * @return Матрица вероятностей под HTML
   */
  public String toStringHTML() {
    StringBuilder sb = new StringBuilder();

    sb.append("<table>");
    for (int i = 0; i < DIMS; i++) {
      sb.append("<tr>");
      for (int j = 0; j < DIMS; j++) {
        sb.append("<td>");
          sb.append(df.format(percents[i][j]));
        sb.append("</td>");
      }
      sb.append("</tr>");
    }
    sb.append("</table>");

    return sb.toString();
  }

  /**
   * Возвращает вероятности состояний
   * То, ради чего создавался проект
   *
   * @return Вероятности состояний
   */
  public String getTotals() {
    Vec2D v = new Vec2D(this);
    String[] stateNames = {
        "Улица",
        "Регистратура",
        "Терапевт",
        "Хирург",
    };

    v = Vec2D.getPower(v);

    double[] totals = v.percents[0];

    assert (totals.length == stateNames.length);

    StringBuilder sb = new StringBuilder();

    sb.append("<table>");
    for (int i = 0; i < totals.length; i++) {
      sb.append("<tr>");
        sb.append("<td>");
          sb.append(stateNames[i]);
          sb.append(" : ");
        sb.append("</td>");
        sb.append("<td>");
          sb.append(df.format(totals[i]));
        sb.append("</td>");
      sb.append("</tr>");
    }
    sb.append("</table>");

    return sb.toString();
  }

  /**
   * Приватный метод
   * Обновляет матрицу вероятностей исходя из матрицы переходов
   */
  private void updatePercents() {
    int sumRow;

    for (int i = 0; i < DIMS; i++) {
      sumRow = 0;

      for (int j = 0; j < DIMS; j++) {
        sumRow += values[i][j];
      }

      // Защита от NaN или Null для ГУИ
      // Так как делить на ноль опасно для жизни
      if (sumRow == 0) {
        for (int j = 0; j < DIMS; j++) {
          percents[i][j] = 0;
        }
      }
      else {
        for (int j = 0; j < DIMS; j++) {
          percents[i][j] = (double) values[i][j] / (double) sumRow;
        }
      }

    }
  }
}
