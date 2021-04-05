package User;

import MatrixMath.SaverData;

/**
 * Класс состояния "На улице"
 */
public class StreetUserState extends UserState {

  /**
   * Конструктор, который принимает юзера
   * И обозначает имя состояния
   *
   * @param u Юзер
   */
  public StreetUserState(User u) {
    super(u);
    name = "Улица";
  }

  /**
   * Получаем ИД состояния
   *
   * @return ИД состояния
   */
  @Override
  public int getID() {
    return 0;
  }

  /**
   * Если тыкнул на кнопку "Пойти на улицу"
   */
  @Override
  public void clickStreetButton() {
    // Ничего
  }

  /**
   * Если тыкнул на кнопку "Подойти к регистратуре"
   */
  @Override
  public void clickRegistrationButton() {
    System.out.println("Пришёл из улицы в регистратуру");
    SaverData.changeState(this, u.getRegState());
    u.changeState(u.getRegState());
    updateGUI();
  }

  /**
   * Если тыкнул на кнопку "Пойти к терапевту"
   */
  @Override
  public void clickDoctorButton() {
    System.out.println("Пришёл из улицы к терапевту");
    SaverData.changeState(this, u.getDocState());
    u.changeState(u.getDocState());
    updateGUI();
  }

  /**
   * Если тыкнул на кнопку "Пойти к хирургу"
   */
  @Override
  public void clickSurgeonButton() {
    System.out.println("Пришёл из улицы к хирургу");
    SaverData.changeState(this, u.getSurgeonState());
    u.changeState(u.getSurgeonState());
    updateGUI();
  }
}
