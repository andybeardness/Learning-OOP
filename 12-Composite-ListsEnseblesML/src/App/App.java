package App;

import GUI.GUI;
import ML.DataItem;
import ML.ML;
import ML.Models.Composite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс приложения, который аккумулирует в себе МО и ГУИ
 */
public class App {
  ML ml; // МО
  GUI gui; // ГУИ
  Composite ensemble; // Основной ансамбль

  /**
   * Конструктор с
   *    -- Инициализацией МО
   *    -- Инициализацией ГУИ
   *    -- Инициация основного ансамбля
   *    -- Установки кнопки ГУИ слушателя
   */
  public App() {
    ml = new ML();
    gui = new GUI();

    ensemble = ml.getAllComposite();

    gui.setExecuteButtonActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        DataItem d = gui.getDataItem();
        gui.updateResults(ensemble.getPredict(d));
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
