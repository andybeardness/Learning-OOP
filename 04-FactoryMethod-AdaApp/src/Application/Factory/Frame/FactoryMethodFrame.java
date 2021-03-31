package Application.Factory.Frame;

import javax.swing.JFrame;

/**
 * Абстрактный класс для фабрики Фрейма
 */
public abstract class FactoryMethodFrame {

  /**
   * Метод для создания фрейма
   *
   * @return Фабричный метод
   */
  public abstract JFrame createFrame();

}
