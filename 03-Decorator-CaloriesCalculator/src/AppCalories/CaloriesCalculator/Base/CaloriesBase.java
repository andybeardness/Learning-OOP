package AppCalories.CaloriesCalculator.Base;

/**
 * Базовый абстрактный класс для персоны
 */
public abstract class CaloriesBase {

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
