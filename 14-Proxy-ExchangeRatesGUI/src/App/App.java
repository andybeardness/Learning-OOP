package App;

import ExchangeRate.Proxy;
import ExchangeRate.ProxyConnecter;
import ExchangeRate.Rate;
import GUI.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Главный класс приложения,
 * который аггрегирует в себе все нужные объекты
 * и их взаимодействия
 */
public class App {
  private final GUI gui; // ГУИ
  private final Proxy pc; // Заместитель
  private final DecimalFormat df; // Для форматирования значений

  /**
   * Конструктор, который :
   *    -- Инициализирует объекты
   *    -- Добавляет слушателя
   *    -- Запускает ГУИ
   */
  public App() {
    gui = new GUI();
    pc = new ProxyConnecter();
    df = new DecimalFormat("0.000");

    gui.setActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        updateRates();
      }
    });

    gui.run();
  }

  /**
   * Метод для обновления курсов валют
   */
  public void updateRates() {
    Rate r = pc.getRate(); // Просим у заместителя новые курсы

    // Собираем HTML String
    StringBuilder sb = new StringBuilder();
    sb.append("<html>");
      sb.append("<p>Курсы валют к рублю :</p>");
      sb.append("<br>");
      sb.append("<table>");
        sb.append("<tr>");
          sb.append("<td>Валюта :</td>");
          sb.append("<td>Значение :</td>");
        sb.append("</tr>");
        sb.append("<tr>");
          sb.append("<td>Доллар</td>");
          sb.append("<td>").append(df.format(r.getRateUsd())).append("</td>");
        sb.append("</tr>");
        sb.append("<tr>");
          sb.append("<td>Доллар</td>");
          sb.append("<td>").append(df.format(r.getRateEur())).append("</td>");
        sb.append("</tr>");
      sb.append("</table>");
      sb.append("<br>");
      sb.append("<p>Статус : ").append(r.getStatus()).append("</p>");
    sb.append("</html>");

    // Обновляем результаты в ГУИ
    gui.updateLabel(sb.toString());
  }
}
