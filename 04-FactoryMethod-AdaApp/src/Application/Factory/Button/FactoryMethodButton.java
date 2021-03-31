package Application.Factory.Button;

import javax.swing.JButton;

/**
 * Абстрактный класс для фабрики Кнопки
 */
public abstract class FactoryMethodButton {

  /**
   * Метод для создания кнопки
   *
   * @return Фабричный метод
   */
  public abstract JButton createButton();

}
