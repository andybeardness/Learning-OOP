package ML.Models;

import ML.DataItem;

/**
 * Клосс Компоновщика
 */
public interface Composite {
  double getPredict(DataItem d); // Предсказание
  void add(Composite m); // Добавляет модель в ансамбль
  void remove(Composite m); // Удаляет модель из ансамбля (не используется)
}
