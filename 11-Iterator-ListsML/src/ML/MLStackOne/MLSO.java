package ML.MLStackOne;

import ML.Model.Model;

import java.util.ArrayList;

/**
 * Интерфейс для первой реализации на ArrayList
 */
public interface MLSO {
  void initModels(double[] bList, double[] wGenderList, double[] wHeightList);
  ArrayList<Model> getModels();
  int getLength();
}
