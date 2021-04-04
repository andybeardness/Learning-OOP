package App;

import GUI.GUI;
import ML.DataItem;
import ML.MLIterator.MLSolver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс приложения, который аккумулирует в себе МО и ГУИ
 */
public class App {
  MLSolver mls; // МО
  GUI gui; // ГУИ

  /**
   * Конструктор с
   *    -- Инициализацией МО
   *    -- Инициализацией ГУИ
   *    -- Установки кнопки ГУИ слушателя
   */
  public App() {
    mls = new MLSolver();
    gui = new GUI();

    gui.setExecuteButtonActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        DataItem d = gui.getDataItem();
        double[] preds = mls.getPreds(d);
        gui.updateResults(preds);
      }
    });
  }

  /**
   * Запуск приложения
   */
  public void run() {
    gui.run();
  }
}
