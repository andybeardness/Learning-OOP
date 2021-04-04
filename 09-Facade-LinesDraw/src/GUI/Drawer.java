package GUI;

import java.awt.Graphics2D;

/**
 * Класс рисователя
 *
 * У которого в наборе куча методов, каждый из которых рисует одну линию
 * Для подобной фигни очень пригодится Фасад
 */
public class Drawer {

  Graphics2D g2d; // 2Д графика

  /**
   * Конструктор
   *
   * @param g 2Д графика
   */
  public Drawer(Graphics2D g) {
    g2d = g;
  }

  // Методы для отрисовки линий
  public void drawLine01() { g2d.drawLine(100, 100, 100, 200); }
  public void drawLine02() { g2d.drawLine(100, 100, 200, 100); }
  public void drawLine03() { g2d.drawLine(200, 100, 200, 200); }
  public void drawLine04() { g2d.drawLine(100, 200, 200, 200); }
  public void drawLine05() { g2d.drawLine(100, 100, 200, 200); }
  public void drawLine06() { g2d.drawLine(100, 200, 200, 100); }
  public void drawLine07() { g2d.drawLine(150, 100, 100, 150); }
  public void drawLine08() { g2d.drawLine(150, 100, 200, 150); }
  public void drawLine09() { g2d.drawLine(150, 200, 100, 150); }
  public void drawLine10() { g2d.drawLine(150, 200, 200, 150); }
  public void drawLine11() { g2d.drawLine(150, 100, 150, 200); }
  public void drawLine12() { g2d.drawLine(100, 150, 200, 150); }

}
