package Application.Factory.Panel;

import javax.swing.JPanel;

/**
 * Абстрактный класс для фабрики Панели
 */
public abstract class FactoryMethodPanel {

  /**
   * Метод для создания панели
   *
   * @return Фабричный метод
   */
  public abstract JPanel createPanel();

}
