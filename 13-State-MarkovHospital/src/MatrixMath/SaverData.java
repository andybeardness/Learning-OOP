package MatrixMath;

import User.UserState;

/**
 * Статический класс для хранения и получения данных
 */
public class SaverData {
  private static Vec2D data = new Vec2D(); // Объект с двумя матрицами

  /**
   * Увеличивает элемент матрицы переходов
   * Исходя из состояния ДО и состояния ПОСЛЕ
   *
   * @param before Состояние ДО
   * @param after Состояние ПОСЛЕ
   */
  public static void changeState(UserState before, UserState after) {
    data.incrementElement(before.getID(), after.getID());
  }

  /**
   * Возвращает матрицу вероятностей под HTML для ГУИ
   *
   * @return Матрица вероятностей под HTML
   */
  public static String getStringHTML() {
    return data.toStringHTML();
  }

  /**
   * Возвращает результат Марковского анализа под HTML для ГУИ
   *
   * @return Результат Марковского анализа под HTML
   */
  public static String getTotals() {
    return data.getTotals();
  }
}
