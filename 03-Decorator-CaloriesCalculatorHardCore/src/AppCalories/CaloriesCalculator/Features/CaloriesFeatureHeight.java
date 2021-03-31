package AppCalories.CaloriesCalculator.Features;

import AppCalories.CaloriesCalculator.Base.CaloriesBase;

/**
 * Декоратор роста
 */
public class CaloriesFeatureHeight extends CaloriesFeature {

  /**
   * Конструктор декоратора для роста
   *
   * @param height Рост
   * @param cb Персона
   */
  public CaloriesFeatureHeight(double height, CaloriesBase cb) {
    this.value = height;
    this.cb = cb;

    // Подсчет коэффициента
    this.coef = cb.getGender() ? 1.8 : 5;
  }

}
