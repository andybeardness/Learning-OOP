package ML.MLStackTwo;

import ML.Model.Model;

import java.util.LinkedList;

/**
 * Интерфейс для второй реализации на LinkedList
 */
public interface MLST {
  void initModels(double[] bList, double[] wGenderList, double[] wHeightList);
  LinkedList<Model> getModels();
  int getLength();
}
