package ML.MLStackOne;

import ML.Model.Model;

import java.util.ArrayList;

/**
 * Реализация первая на ArrayList
 */
public class MLStackArrayList implements MLSO {
  ArrayList<Model> models = new ArrayList<>(); // Модели будут тут
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
  public ArrayList<Model> getModels() {
    return models;
  }

  // Возвращает длину
  @Override
  public int getLength() {
    return length;
  }
}
