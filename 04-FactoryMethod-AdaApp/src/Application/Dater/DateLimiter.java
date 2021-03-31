package Application.Dater;

/**
 * Задает ограничение по дате на смену дневной и ночной темы приложения
 */
public class DateLimiter {
  private final static int UP_LIMIT = 22; // Верхний лимит
  private final static int DOWN_LIMIT = 6; // Нижний лимит

  /**
   * Ответ на вопрос "Если сейчас *hour*, то сейчас ночь?"
   *
   * @param hour Час в 24-часовом формате
   * @return Ответ на вопрос "Если сейчас *hour*, то сейчас ночь?"
   */
  public static boolean isNight(int hour) {
    return hour >= UP_LIMIT || hour < DOWN_LIMIT;
  }
}
