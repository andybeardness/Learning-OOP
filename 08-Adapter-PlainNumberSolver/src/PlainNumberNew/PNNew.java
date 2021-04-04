package PlainNumberNew;

/**
 * Интерфейс нового решателя
 */
public interface PNNew {
  void setNumber(int n); // Устанавливает число
  void initCenter(); // Инициализирует центр
  boolean hasDelimiter(int d); // Проверка не делимость
  boolean isPlain(); // Проверка числа на простоту
}
