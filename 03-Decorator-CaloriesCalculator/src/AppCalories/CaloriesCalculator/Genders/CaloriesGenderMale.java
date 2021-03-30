package AppCalories.CaloriesCalculator.Genders;

/**
 * Класс для персоны мужского пола
 */
public class CaloriesGenderMale extends CaloriesGender {

  /**
   * Возвращает базовый калораж мужчины
   *
   * @return Базовый калораж мужчины
   */
  @Override
  public double getCalories() {
    return 66.;
  }

  /**
   * Возвращает гендер : Женщина -- true, Мужчина -- false
   *
   * @return false
   */
  @Override
  public boolean getGender() {
    return false;
  }

}
