package AppCalories.CaloriesCalculator.Genders;

/**
 * Класс для персоны женского пола
 */
public class CaloriesGenderFemale extends CaloriesGender {

  /**
   * Возвращает базовый калораж женщины
   *
   * @return Базовый калораж женщины
   */
  @Override
  public double getCalories() {
    return 665.;
  }

  /**
   * Возвращает гендер : Женщина -- true, Мужчина -- false
   *
   * @return true
   */
  @Override
  public boolean getGender() {
    return true;
  }
}
