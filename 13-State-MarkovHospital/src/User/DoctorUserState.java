package User;

import MatrixMath.SaverData;

/**
 * Класс состояния "У терапевта"
 */
public class DoctorUserState extends UserState {

  /**
   * Конструктор, который принимает юзера
   * И обозначает имя состояния
   *
   * @param u Юзер
   */
  public DoctorUserState(User u) {
    super(u);
    name = "Терапевт";
  }

  /**
   * Получаем ИД состояния
   *
   * @return ИД состояния
   */
  @Override
  public int getID() {
    return 2;
  }

  /**
   * Если тыкнул на кнопку "Пойти на улицу"
   */
  @Override
  public void clickStreetButton() {
    System.out.println("Пришёл от терапевта на улицу");
    SaverData.changeState(this, u.getStreetState());
    u.changeState(u.getStreetState());
    updateGUI();
  }

  /**
   * Если тыкнул на кнопку "Подойти к регистратуре"
   */
  @Override
  public void clickRegistrationButton() {
    System.out.println("Пришёл от терапевта в регистратуру");
    SaverData.changeState(this, u.getRegState());
    u.changeState(u.getRegState());
    updateGUI();
  }

  /**
   * Если тыкнул на кнопку "Пойти к терапевту"
   */
  @Override
  public void clickDoctorButton() {
    // Ничего
  }

  /**
   * Если тыкнул на кнопку "Пойти к хирургу"
   */
  @Override
  public void clickSurgeonButton() {
    System.out.println("Пришёл от терапевта к хирургу");
    SaverData.changeState(this, u.getSurgeonState());
    u.changeState(u.getSurgeonState());
    updateGUI();
  }
}
