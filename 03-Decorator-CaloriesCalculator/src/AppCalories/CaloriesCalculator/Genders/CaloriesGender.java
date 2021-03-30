package AppCalories.CaloriesCalculator.Genders;

import AppCalories.CaloriesCalculator.Base.CaloriesBase;

/**
 * Базовый абстрактный класс для персоны с полом
 */
public abstract class CaloriesGender extends CaloriesBase {

  /**
   * Возвращает калории
   *
   * @return Норму калорий
   */
  public abstract double getCalories();

  /**
   * Возвращает гендер : Женщина -- true, Мужчина -- false
   *
   * @return Ответ на вопрос "Персона является женщиной?"
   */
  public abstract boolean getGender();

}
