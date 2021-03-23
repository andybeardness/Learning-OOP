package DisciminantSolvers;

/**
 * Интерфейс для решателя дискриминанта
 */
public interface DiscriminantBehaviour {
  public void solve() throws Exception; // Находит дискриминант
  public double getD() throws Exception; // Возвращает дискриминант
  public boolean hasTwoSolves(); // Возвращает ответ на вопрос "Имеет ли уравнение два решения?"
}
