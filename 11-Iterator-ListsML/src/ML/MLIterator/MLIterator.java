package ML.MLIterator;

import ML.MLStackOne.MLStackArrayList;
import ML.MLStackTwo.MLStackLinkedList;
import ML.Model.Model;

/**
 * Реализация паттерна Итератор
 *
 * Объединяем два разных списка в один интерфейс
 */
public class MLIterator implements SelfIterator {

  MLStackArrayList mlAL = new MLStackArrayList(); // Список № 1
  MLStackLinkedList mlLL = new MLStackLinkedList(); // Список № 2

  // Нужны для работы
  int length;
  int iter;

  /**
   * Конструктор
   */
  public MLIterator() {
    initModels();
    length = mlAL.getLength() + mlLL.getLength();
    iter = 0;
  }

  /**
   * Инициализация моделей статическими данными
   */
  public void initModels() {
    mlAL.initModels(
        MLValuesStatic.getBListOne(),
        MLValuesStatic.getGenderListOne(),
        MLValuesStatic.getHeightListOne()
        );

    mlLL.initModels(
        MLValuesStatic.getBListTwo(),
        MLValuesStatic.getGenderListTwo(),
        MLValuesStatic.getHeightListTwo()
    );
  }

  /**
   * Метод, проверяющий "Есть ли следующий элемент?"
   * @return Ответ на вопрос "Есть ли следующий элемент?"
   */
  @Override
  public boolean hasNext() {
    return iter >= 0 && iter < length;
  }

  /**
   * Получаем следующий элемент
   *
   * @return Модель
   * @throws Exception Если забыл одновить итератор
   */
  @Override
  public Model getNext() throws Exception {
    if (iter < mlAL.getLength()) {
      return mlAL.getModels().get(iter++);
    }
    else if (iter < length) {
      return mlLL.getModels().get((iter++) - mlAL.getLength());
    }
    else {
      throw new Exception("Итератор вышел за пределы, нужно использовать метод refresh()");
    }
  }

  /**
   * Обновляет итератор
   */
  @Override
  public void refresh() {
    iter = 0;
  }

  /**
   * Геттер для общей длины списков
   *
   * @return Общая длина списков
   */
  @Override
  public int getLength() {
    return length;
  }
}
