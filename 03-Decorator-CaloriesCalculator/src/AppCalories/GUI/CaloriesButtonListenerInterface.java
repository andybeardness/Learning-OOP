package AppCalories.GUI;

import javax.swing.JLabel;
import java.awt.event.ActionListener;

/**
 * Интерфейс для класса, который должен вернуть слушателя для кнопки
 */
public interface CaloriesButtonListenerInterface {

  /**
   * Возвращает слушателя
   *
   * @param isFemale Ответ на вопрос "Персона является женщиной?"
   * @param age Возраст
   * @param weight Вес
   * @param height Рост
   * @param label Ссылка на объект, где должен выводиться результат
   *
   * @return Слушатель для кнопки "Посчитать"
   */
  ActionListener getListener(boolean isFemale, double age, double weight, double height, JLabel label);
}
