package Application.Factory.Label;

import javax.swing.JLabel;

/**
 * Абстрактный класс для фабрики Лейбла
 */
public abstract class FactoryMethodLabel {

  /**
   * Метод для создания лейбла
   *
   * @return Фабричный метод
   */
  public abstract JLabel createLabel();

}
