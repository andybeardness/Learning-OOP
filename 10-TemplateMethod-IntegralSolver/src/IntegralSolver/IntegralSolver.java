package IntegralSolver;

/**
 * Решатель интегралов по методу "Шаблонный метод"
 */
public abstract class IntegralSolver {

  // Тут методы, которые должен реализовать пользователь
  public abstract double getFunction(double x);
  public abstract double getLeftBound();
  public abstract double getRightBound();
  public abstract double getSteps();

  // А тут пайплайн решения
  public final double solve() {
    double sum = 0.;

    double h = (getRightBound() - getLeftBound()) / getSteps();

    for (double i = getLeftBound(); i < getRightBound(); i += h) {
      sum += getFunction(i) * h;
    }

    return sum;
  }
}
