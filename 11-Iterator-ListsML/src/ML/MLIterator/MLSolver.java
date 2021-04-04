package ML.MLIterator;

import ML.DataItem;

/**
 * Решатель МО
 *
 * В себе содержит Итератор
 */
public class MLSolver {
  MLIterator mli; // Итератор
  int length; // Общая длина
  double[] preds; // предсказания

  /**
   * Конструктор с инициализацией внутренних аттрибутов
   */
  public MLSolver() {
    mli = new MLIterator();
    length = mli.length;
    preds = new double[length];
  }

  /**
   * Для добычи предсказаний
   *
   * @param d Данные
   * @return Предсказания
   */
  public double[] getPreds(DataItem d) {
    // Если следующей нет, то надо рефрешнуть итератор
    if (!mli.hasNext()) {
      mli.refresh();
    }

    // Итерируемая переменная
    int i = 0;

    // Главный цикл для добычи предсказаний
    while(mli.hasNext()) {
      try {
        preds[i++] = mli.getNext().getPredict(d);
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }

    return preds;
  }

}
