package AppCalories.CaloriesCalculator.Features;

import AppCalories.CaloriesCalculator.Base.CaloriesBase;

/**
 * Базовый абстрактный класс для персоны с полом
 *
 * Реализует методы для подсчёта калорий для всех последующих наследников-декараторов
 */
public abstract class CaloriesFeature extends CaloriesBase {

  protected double value; // значение при декораторе
  protected CaloriesBase cb; // объект персоны
  protected double coef; // коэффициент

  /**
   * Возвращает гендер : Женщина -- true, Мужчина -- false
   *
   * @return Гендер
   */
  @Override
  public boolean getGender() {
    return cb.getGender();
  }

  /**
   * Возвращает калории изначального объекта + (значение декоратора * коэффициент)
   *
   * @return Калории
   */
  public double getCalories() {
    return cb.getCalories() + (value * coef);
  }

}
