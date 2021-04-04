package ML.MLStackTwo;

import ML.Model.Model;

import java.util.LinkedList;

/**
 * Реализация вторая на LinkedList
 */
public class MLStackLinkedList implements MLST {
  LinkedList<Model> models = new LinkedList<>(); // Модели будут тут
  int length;

  // Инициализацияя моделей
  @Override
  public void initModels(double[] bList, double[] wGenderList, double[] wHeightList) {
    // Проверка на размеры массивов
    assert (bList.length == wGenderList.length);
    assert (bList.length == wHeightList.length);

    length = bList.length;

    for (int i = 0; i < length; i++) {
      models.add(new Model(bList[i], wGenderList[i], wHeightList[i]));
    }
  }

  // Возвращает модели списком
  @Override
  public LinkedList<Model> getModels() {
    return models;
  }

  // Возвращает длину
  @Override
  public int getLength() {
    return length;
  }

}
