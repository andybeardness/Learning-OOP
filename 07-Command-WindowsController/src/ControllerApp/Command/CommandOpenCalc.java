package ControllerApp.Command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Команда для открытия калькулятора
 */
public class CommandOpenCalc implements Command, ActionListener {

  String path;

  /**
   * Конструктор с инициализацией пути до программы
   */
  public CommandOpenCalc() {
    path = "C:\\\\Windows\\\\System32\\\\calc.exe";
  }

  /**
   * Запуск программы
   */
  @Override
  public void go() {
    try {
      Runtime.getRuntime().exec(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Метод интерфейса слушателя
   *
   * @param e Событие
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    go();
  }


}
