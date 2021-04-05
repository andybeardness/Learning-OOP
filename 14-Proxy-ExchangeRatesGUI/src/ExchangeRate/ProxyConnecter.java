package ExchangeRate;

import java.util.Date;

/**
 * Класс заместителя
 */
public class ProxyConnecter implements Proxy {

  private final Connecter con; // Реальный объект Коннектер

  private Rate current; // Курс
  private Date dt; // Время

  /**
   * Конструктор инициализирует Коннектер
   */
  public ProxyConnecter() {
    con = new Connecter();
  }

  /**
   * Проверка на прошедшее время
   *
   * @return Ответ на вопрос "А прошли ли 5 секунд с прошлого запуска?"
   */
  private boolean isTimeIsGone() {
    return System.currentTimeMillis() - dt.getTime() >= 1000 * 5;
  }

  /**
   * Добыча текущих курсов
   *
   * В завимисости от прошедшего времени с прошлого раза
   * заместитель решает : запросить новые курсы или отдать старые
   *
   * @return Курсы валют
   */
  @Override
  public Rate getRate() {

    // Если dt не определён
    //    или
    // Если времени прошло достаточно
    if (dt == null || isTimeIsGone()) {
      System.out.println("!");
      dt = new Date(System.currentTimeMillis());
      current = con.getRate();

      return current;
    }

    // В противном случае вернёт те же курсы, но с другим статусом
    current.setStatus("WAIT");
    return current;
  }
}
