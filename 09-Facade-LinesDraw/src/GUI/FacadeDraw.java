package GUI;

/**
 * Фасад для Рисователя
 */
public class FacadeDraw {

  Drawer drawer; // Рисователь

  /**
   * Конструктор
   *
   * @param d Рисователь
   */
  public FacadeDraw(Drawer d) {
    drawer = d;
  }

  /**
   * Рисует квадрат
   */
  public void drawSquare() {
    drawer.drawLine01();
    drawer.drawLine02();
    drawer.drawLine03();
    drawer.drawLine04();
  }

  /**
   * Рисует крест
   */
  public void drawX() {
    drawer.drawLine05();
    drawer.drawLine06();
  }

  /**
   * Рисует коробку
   */
  public void drawBox() {
    drawer.drawLine01();
    drawer.drawLine02();
    drawer.drawLine03();
    drawer.drawLine04();
    drawer.drawLine05();
    drawer.drawLine06();
  }

  /**
   * Рисует треугольник
   */
  public void drawTriangle() {
    drawer.drawLine01();
    drawer.drawLine02();
    drawer.drawLine06();
  }

  /**
   * Рисует ромб
   */
  public void drawRhombus() {
    drawer.drawLine07();
    drawer.drawLine08();
    drawer.drawLine09();
    drawer.drawLine10();
  }

  /**
   * Рисует коробку-ромб
   */
  public void drawRhombusBox() {
    drawer.drawLine07();
    drawer.drawLine08();
    drawer.drawLine09();
    drawer.drawLine10();
    drawer.drawLine11();
    drawer.drawLine12();
  }

}
