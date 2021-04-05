package User;

import MatrixMath.SaverData;

/**
 * Класс состояния "У стойки регистрации"
 */
public class RegistrationUserState extends UserState {

  /**
   * Конструктор, который принимает юзера
   * И обозначает имя состояния
   *
   * @param u Юзер
   */
  public RegistrationUserState(User u) {
    super(u);
    name = "Регистрация";
  }

  /**
   * Получаем ИД состояния
   *
   * @return ИД состояния
   */
  @Override
  public int getID() {
    return 1;
  }

  /**
   * Если тыкнул на кнопку "Пойти на улицу"
   */
  @Override
  public void clickStreetButton() {
    System.out.println("Пришёл из регистратуры на улицу");
    SaverData.changeState(this, u.getStreetState());
    u.changeState(u.getStreetState());
    updateGUI();
  }

  /**
   * Если тыкнул на кнопку "Подойти к регистратуре"
   */
  @Override
  public void clickRegistrationButton() {
    // Ничего
  }

  /**
   * Если тыкнул на кнопку "Пойти к терапевту"
   */
  @Override
  public void clickDoctorButton() {
    System.out.println("Пришёл из регистратуры к терапевту");
    SaverData.changeState(this, u.getDocState());
    u.changeState(u.getDocState());
    updateGUI();
  }

  /**
   * Если тыкнул на кнопку "Пойти к хирургу"
   */
  @Override
  public void clickSurgeonButton() {
    System.out.println("Пришёл из регистратуры к хирургу");
    SaverData.changeState(this, u.getSurgeonState());
    u.changeState(u.getSurgeonState());
    updateGUI();
  }
}
