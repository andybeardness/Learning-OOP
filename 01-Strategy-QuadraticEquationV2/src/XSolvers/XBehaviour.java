package XSolvers;

/**
 * Интерфейс для решателя корней уравнения
 */
public interface XBehaviour {
  public void solve() throws Exception; // Решает уравнение своим способом
  public boolean hasTwoSolves(); // Возвращает ответ на вопрос "У уравнения два корня?"
  public double getX1(); // Возвращает первый корень уравнения
  public double getX2(); // Возвращает второй корень уравнения
  public double getX(); // Возвращает единственный корень уравнения
}
