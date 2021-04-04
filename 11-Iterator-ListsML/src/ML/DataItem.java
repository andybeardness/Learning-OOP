package ML;

/**
 * Класс для элемента данных
 */
public class DataItem {
  private final double gender; // Гендер
  private final double height; // Рост

  // Типичный конструктор
  public DataItem(double g, double h) {
    gender = g;
    height = h;
  }

  // Геттер для Гендера
  public double getGender() {
    return gender;
  }

  // Геттер для Роста
  public double getHeight() {
    return height;
  }
}
