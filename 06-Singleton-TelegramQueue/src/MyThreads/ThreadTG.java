package MyThreads;

import TGBot.Bot;

/**
 * Поток ТГ-бота
 */
public class ThreadTG extends Thread {

  Bot bot; // Объект бота

  /**
   * Конструктор
   *
   * @param bot Объект бота
   */
  public ThreadTG(Bot bot) {
    this.bot = bot;
  }

  /**
   * Для запуска ему нужно :
   *    1 -- Создать экземпляр бота
   *    2 -- Зарегистрировать его в GUI
   *    3 -- Запустить бота
   */
  @Override
  public void run() {
    bot.run();
  }
}
