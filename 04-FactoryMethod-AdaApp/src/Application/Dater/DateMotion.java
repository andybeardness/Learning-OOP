package Application.Dater;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Конструирует из текущих даты и времени стрингу с датой и временем
 */
public class DateMotion {
  private static Date date;
  private static String dateString;

  private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  /**
   * Закрытый конструктор, чтобы не повадно было
   */
  private DateMotion() {}

  /**
   * Берёт текущие дату и время и превращает в стрингу
   *
   * @return Форматированные дата и время
   */
  public static String getDateString() {
    date = new Date();
    dateString = format.format(date);

    return dateString;
  }
}
