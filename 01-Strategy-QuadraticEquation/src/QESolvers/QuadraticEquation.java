package QESolvers;

/**
 * Абстрактный класс, от которого наследуются все "решатели" квадратных уравнений
 *
 * Есть множество способов решить квадратное уравнение
 * Тут предлагаю абстрактный решатель, который требует в себе две вещи
 *    1 -- Наличие решателя для дискриминанта
 *    2 -- Наличие решателя для корней уравнения
 *
 * Это минус такой реализации, ведь есть способы решить квадратное уравнение,
 * не прибегая к дискриминанту
 *
 * Этим примером хотел лишь показать реализацию паттерна "Стратегия"
 */
abstract public class QuadraticEquation {
  abstract public void solveDiscriminant() throws Exception; // Находит дискриминант
  abstract public void solveX() throws Exception; // Находит Х1 и Х2
  abstract public double getDiscriminant() throws Exception; // Возвращает дискриминант
  abstract public boolean hasTwoSolves(); // Возвращает булево значение "Имеет или два решения?"
  abstract public double getX1(); // Возвращает Х1
  abstract public double getX2(); // Возвращает Х2
}
