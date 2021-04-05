package ExchangeRate;

/**
 * Класс для аггрегации курсов
 * Нужен, чтобы за раз передать курсы доллара и евро + статус
 */
public class Rate {
  private final double rateUsd; // Курс доллара
  private final double rateEur; // Курс евро

  private String status; // Статус

  /**
   * Конструктор с инициализацией
   *
   * @param rateUsd Курс доллара
   * @param rateEur Курс евро
   * @param status Статус
   */
  public Rate(double rateUsd, double rateEur, String status) {
    this.rateUsd = rateUsd;
    this.rateEur = rateEur;
    this.status = status;
  }

  /**
   * Геттер для курса доллара
   *
   * @return Курс доллара
   */
  public double getRateUsd() {
    return rateUsd;
  }

  /**
   * Геттер для курса евро
   *
   * @return Курс евро
   */
  public double getRateEur() {
    return rateEur;
  }

  /**
   * Геттер для статуса
   *
   * @return Статус
   */
  public String getStatus() {
    return status;
  }

  /**
   * Сеттер для статуса
   *
   * @param status Новый статус
   */
  public void setStatus(String status) {
    this.status = status;
  }
}
