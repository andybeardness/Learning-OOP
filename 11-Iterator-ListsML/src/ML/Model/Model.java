package ML.Model;

import ML.DataItem;

/**
 * Класс для одной модели МО
 */
public class Model implements ModelInterface {

  double b; // Байес
  double wGender; // Вес для гендера
  double wHeight; // Вес для роста

  // Конструктор
  public Model(double b, double wGender, double wHeight) {
    this.b = b;
    this.wGender = wGender;
    this.wHeight = wHeight;
  }

  // Метод возвращает предсказание
  @Override
  public double getPredict(DataItem d) {
    return b + d.getGender() * wGender + d.getHeight() * wHeight;
  }
}
