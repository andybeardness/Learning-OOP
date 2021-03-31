package AppHardCore;

import AppCalories.CaloriesCalculator.Base.CaloriesBase;
import AppCalories.CaloriesCalculator.Features.CaloriesFeature;

/**
 * Хардкорный счетчик калорий для тех,
 * кто занимается в зале очень часто
 * и "убивается" на тренировках
 *
 * Мужчины + 1500 ккал
 * Женщины + 1000 ккал
 *
 */
public class CaloriesFeatureHardCore extends CaloriesFeature {

  /**
   * Метод делает декоратор, содержащий пустой параметр
   *
   * @param empty Пустой параметр
   * @param cb Персона
   */
  public CaloriesFeatureHardCore(double empty, CaloriesBase cb) {
    this.value = 1;
    this.cb = cb;

    this.coef = cb.getGender() ? 1000. : 1500.;
  }

}