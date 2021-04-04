package ML.MLIterator;

import ML.Model.Model;

/**
 * Интерфейс для Итератора
 */
public interface SelfIterator {
  boolean hasNext();
  Model getNext() throws Exception;
  void refresh();
  int getLength();
}
