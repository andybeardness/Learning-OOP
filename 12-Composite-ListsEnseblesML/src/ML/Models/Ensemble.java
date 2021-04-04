package ML.Models;

import ML.DataItem;

import java.util.ArrayList;

/**
 * Класс Ансамбля моделей
 */
public class Ensemble implements Composite {
  ArrayList<Composite> children = new ArrayList<>(); // Список моделей

  /**
   * Метод для предсказаний
   *    Сначала собирает предсказания с каждой дочерней модели
   *    Потом усредняет
   *
   * @param d Элемент данных
   * @return Финальное предсказание
   */
  @Override
  public double getPredict(DataItem d) {
    ArrayList<Double> preds = new ArrayList<>();

    for (Composite child : children) {
      preds.add(child.getPredict(d));
    }

    double predsSum = 0.;

    for (double p : preds) {
      predsSum += p;
    }

    double pred = predsSum / (double)preds.size();

    return pred;
  }

  /**
   * Метод добавления новой модели в Ансамбль
   *
   * @param m Модель
   */
  @Override
  public void add(Composite m) {
    children.add(m);
  }

  /**
   * Метод удаления модели из ансамбля
   * Не используется
   *
   * @param m Модель
   */
  @Override
  public void remove(Composite m) {
    children.remove(m);
  }
}
