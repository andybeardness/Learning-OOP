package User;

import MatrixMath.SaverData;

/**
 * Класс состояния "У хирурга"
 */
public class SurgeonUserState extends UserState {

  /**
   * Конструктор, который принимает юзера
   * И обозначает имя состояния
   *
   * @param u Юзер
   */
  public SurgeonUserState(User u) {
    super(u);
    name = "Хирург";
  }

  /**
   * Получаем ИД состояния
   *
   * @return ИД состояния
   */
  @Override
  public int getID() {
    return 3;
  }

  /**
   * Если тыкнул на кнопку "Пойти на улицу"
   */
  @Override
  public void clickStreetButton() {
    System.out.println("Пришёл от хирурга на улицу");
    SaverData.changeState(this, u.getStreetState());
    u.changeState(u.getStreetState());
    updateGUI();
  }

  /**
   * Если тыкнул на кнопку "Подойти к регистратуре"
   */
  @Override
  public void clickRegistrationButton() {
    System.out.println("Пришёл от хирурга в регистратуру");
    SaverData.changeState(this, u.getRegState());
    u.changeState(u.getRegState());
    updateGUI();
  }

  /**
   * Если тыкнул на кнопку "Пойти к терапевту"
   */
  @Override
  public void clickDoctorButton() {
    System.out.println("Пришёл от хирурга к терапевту");
    SaverData.changeState(this, u.getDocState());
    u.changeState(u.getDocState());
    updateGUI();
  }

  /**
   * Если тыкнул на кнопку "Пойти к хирургу"
   */
  @Override
  public void clickSurgeonButton() {
    // Ничего
  }
}
