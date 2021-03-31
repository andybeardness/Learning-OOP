package AppCalories.CaloriesCalculator.Features;

import AppCalories.CaloriesCalculator.Base.CaloriesBase;

/**
 * Декоратор веса
 */
public class CaloriesFeatureWeight extends CaloriesFeature {

  /**
   * Конструктор декоратора для веса
   *
   * @param weight Вес
   * @param cb Персона
   */
  public CaloriesFeatureWeight(double weight, CaloriesBase cb) {
    this.value = weight;
    this.cb = cb;

    // Подсчет коэффициента
    this.coef = cb.getGender() ? 9.6 : 13.7;
  }

}
