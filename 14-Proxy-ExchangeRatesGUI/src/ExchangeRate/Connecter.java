package ExchangeRate;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Класс Коннектера, который делает всю работу
 * Реализует интерфейс Proxy
 */
public class Connecter implements Proxy {

  private Rate current; // Текущий курс

  private Document doc; // Документ страницы
  private Elements tbody, tds; // Элементы для парсинга

  private double usdRub; // Курс доллара к рублю
  private double eurRub; // Курс евро к рублю

  /**
   * Подключается к сайту
   * Парсит
   * Добывает нужные значения
   * Собирает их в объект Rate
   * Возвращает этот объект
   *
   * @return Объект курсов валют
   */
  @Override
  public Rate getRate() {
    try {
      doc = Jsoup.connect("https://www.profinance.ru/chart/usdrub/")
          .userAgent("Chrome/4.0.249.0 Safari/532.5")
          .referrer("http://www.google.com")
          .get();

      tbody = doc.select("table[class=stat news]");
      tds = tbody.select("td");

      usdRub = Double.parseDouble(tds.get(4).text());
      eurRub = Double.parseDouble(tds.get(7).text());

      current = new Rate(usdRub, eurRub, "OK");

    } catch (Exception e) {
      e.printStackTrace();

      current = new Rate(-1., -1., "ERROR");
    }
    return current;
  }
}
