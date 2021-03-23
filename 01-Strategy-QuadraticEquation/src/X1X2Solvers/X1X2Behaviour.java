package X1X2Solvers;

/**
 * Интерфейс для решателя корней уравнения
 */
public interface X1X2Behaviour {
  public void setD(double d); // Задаёт дискриминант
  public double getX1(); // Возвращает первый корень уравнения
  public double getX2(); // Возвращает второй корень уравнения
  public double getX1X2(); // Возвращает единственный корень уравнения
}
