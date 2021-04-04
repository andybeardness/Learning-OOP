package GUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Наследник JFrame
 */
public class App extends JFrame {

  Drawer drawer; // Рисователь
  FacadeDraw facadeDraw; // Фасад
  String figure; // Имя фигуры

  /**
   * Конструктор
   *
   * @param fig Имя фигуры
   */
  public App(String fig) {
    // Вызываем супер-метод с указанием заголовка окна
    super("Рисователь линий");

    // Настраиваем окно
    setSize(300, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    // Инициализируем имя фигуры
    figure = fig;
  }

  /**
   * Метод отрисовки
   *
   * @param g Графика
   */
  public void paint(Graphics g) {
    super.paint(g);

    // Инициализируем рисовальщика и фасад
    drawer = new Drawer((Graphics2D) g);
    facadeDraw = new FacadeDraw(drawer);

    // Принимаем решение, что фасад будет отрисовывать
    switch (figure) {
      case "square"   : facadeDraw.drawSquare();     break;
      case "box"      : facadeDraw.drawBox();        break;
      case "triangle" : facadeDraw.drawTriangle();   break;
      case "rhombus"  : facadeDraw.drawRhombus();    break;
      case "rbox"     : facadeDraw.drawRhombusBox(); break;
      default         : facadeDraw.drawX();
    }
  }

  /**
   * Запуск
   */
  public void run() {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new App(figure).setVisible(true);
      }
    });
  }
}
