package ML.Model;

import ML.DataItem;

/**
 * Интерфейс для Модели
 */
public interface ModelInterface {
  double getPredict(DataItem d);
}
