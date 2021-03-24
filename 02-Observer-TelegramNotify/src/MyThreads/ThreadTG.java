package MyThreads;

import TGBot.Bot;
import GUI.GUI;

/**
 * Поток ТГ-бота
 */
public class ThreadTG extends Thread {

  /**
   * Для запуска ему нужно :
   *    1 -- Создать экземпляр бота
   *    2 -- Зарегистрировать его в GUI
   *    3 -- Запустить бота
   */
  @Override
  public void run() {
    Bot bot = new Bot("NotifyBot", "1746127013:AAGNlQxutbCumSYtxKy7O0zC7zr_aNHnnbM");
    GUI.registerBotInGUI(bot);
    bot.run();
  }
}
