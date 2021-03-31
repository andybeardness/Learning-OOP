package AppCalories.CaloriesCalculator.Features;

import AppCalories.CaloriesCalculator.Base.CaloriesBase;

/**
 * Декоратор возраста
 */
public class CaloriesFeatureAge extends CaloriesFeature {

  /**
   * Конструктор декоратора для возраста
   *
   * @param age Возраст
   * @param cb Персона
   */
  public CaloriesFeatureAge(double age, CaloriesBase cb) {
    this.value = age;
    this.cb = cb;

    // Подсчет коэффициента
    this.coef = cb.getGender() ? 4.7 : 6.8;
  }

}
