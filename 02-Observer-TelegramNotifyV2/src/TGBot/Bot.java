package TGBot;

import Application.App;
import Users.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Класс Бота с интерфейсом Subject для реализации паттерна "Наблюдатель"
 */
public class Bot extends TelegramLongPollingBot implements Subject {

  private static String token, name; // Токет и Имя ТГ-бота

  /**
   * Конструктор
   *
   * @param name Имя бота
   * @param token Токен бота
   */
  public Bot(String name, String token) {
    Bot.name = name;
    Bot.token = token;
  }

  /**
   * Getter для имени бота
   *
   * @return Имя бота
   */
  @Override
  public String getBotUsername() {
    return name;
  }

  /**
   * Getter для токена бота
   *
   * @return Токен бота
   */
  @Override
  public String getBotToken() {
    return token;
  }

  /**
   * Инструкции на случай обновления
   * По сути, он тоже реализует метод "Наблюдатель",
   * но не тут, а где-то на серверах Телеграма
   *
   * @param update Параметр обновления
   */
  @Override
  public void onUpdateReceived(Update update) {
    App.onUpdateReceived(update);
  }

  /**
   * Запуск бота
   */
  public void run() {
    try {
      TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
      botsApi.registerBot(new Bot(name, token));
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }

  /**
   * Метод для отравки текста одному отдельному юзеру
   *
   * @param u Экзепляр юзера
   * @param text Текст сообщения
   */
  public void send(User u, String text) {
    SendMessage message = App.createMessage(text, u.getChatID());

    try {
      execute(message); // Call method to send the message
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }

}

