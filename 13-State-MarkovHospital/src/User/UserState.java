package User;

import MatrixMath.SaverData;

/**
 * Абстрактный класс состояния
 */
public abstract class UserState {
  protected User u; // Юзер
  protected String name; // Имя состояния

  /**
   * Конструктор
   *
   * @param u Юзер
   */
  public UserState(User u) {
    this.u = u;
  }

  /**
   * Получить имя состояния
   *
   * @return Имя состояния
   */
  public String getName() {
    return name;
  }

  /**
   * Обновить ГУИ
   */
  public void updateGUI() {
    u.getGUI().updateResults(name, SaverData.getStringHTML(), SaverData.getTotals());
  }

  /**
   * Получить ИД состояния
   *
   * @return ИД состояния
   */
  public abstract int getID();

  // Методы для смены состояния из каждого состояния
  public abstract void clickStreetButton();
  public abstract void clickRegistrationButton();
  public abstract void clickDoctorButton();
  public abstract void clickSurgeonButton();

}
