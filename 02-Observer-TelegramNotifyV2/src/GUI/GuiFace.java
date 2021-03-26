package GUI;

import javax.swing.*;
import java.util.List;

/**
 * Интерфейс для ГУИ (интерфейс для интерфейса лол)
 */
public interface GuiFace {
  void initGUI(); // Инициализация без "frame.setVisible(true)"
  void run(); // Запуск (он же "frame.setVisible(true)")
  void updateList(List<String> names); // Обновляет список
  JButton getButton(); // Возвращает ссылку на управляющую напоминаниями кнопку
}
