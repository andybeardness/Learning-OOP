package TGBot;

import GUI.GUI;
import Users.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Бота с интерфейсом Subject для реализации паттерна "Наблюдатель"
 */
public class Bot extends TelegramLongPollingBot implements Subject {

  private static String token, name; // Токет и Имя ТГ-бота

  private static List<User> arrayUsers = new ArrayList<>(); // Список наблюдателей

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
    // Собираю имя
    String firstName = update.getMessage().getChat().getFirstName();
    String lastName = update.getMessage().getChat().getLastName();
    String name = firstName + " " + lastName;

    // Беру щепотку ИД-шника чата
    String chatID = update.getMessage().getChatId().toString();

    // Создаю объект User из того, что было
    User user = new User(name, chatID);

    // Беру текст сообщения
    String messageText = update.getMessage().getText();

    // Тут будет наш ответ
    String response;

    // Проверка : "Есть ли сообщение для бота?"
    if (update.hasMessage()) {

      // Проверка : "Эти сообщения -- это одна из команд /start или /stop ?"
      if (messageText.equals("/start") || messageText.equals("/stop")) {

        // Проверка : "Это команда /start ?"
        if (messageText.equals("/start")) {

          // Првоерка : "Новый ли пользователь?"
          if (isNewUser(user)) {
            // Добавляю юзера в наблюдатели
            addUser(user);
            // vv В подобных строках подбираю сообщение для юзера vv
            response = BotMsg.getMsgYouAreFollowing();
          }
          // Если ошибся и сделал /start два раза подряд
          else {
            response = BotMsg.getMsgYouAlreadyFollowing();
          }
        }
        // В противном случае это должно быть /stop
        else {
          // Проверка : "Пользователь уже подписан?"
          if (!isNewUser(user)) {
            // Тогда удаляю из наблюдателей
            removeUser(user);
            response = BotMsg.getMsgYouAreUnfollowing();
          }
          // Если ошибся и сделал /stop два раза подряд
          else {
            response = BotMsg.getMsgYouAlredyUnfollowing();
          }
        }
        // Отправляем сообщение
        send(user, response);
      }
    }
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
   * Добавляет юзера в наблюдатели
   *
   * @param u Экзмепляр юзера
   */
  @Override
  public void addUser(User u) {
    if (isNewUser(u)) {
      arrayUsers.add(u);
      updateNamesList();
    }
  }

  /**
   * Удаляет юзера из наблюдателей
   *
   * @param u Экзепляр юзера
   */
  @Override
  public void removeUser(User u) {
    arrayUsers.removeIf(user -> user.getChatID().equals(u.getChatID()));
    updateNamesList();
  }

  /**
   * Отправляет всем напоминашку
   */
  @Override
  public void sendMessages() {
    for (User u : arrayUsers) {
      send(u, BotMsg.getMsgNotify());
    }
  }

  /**
   * Проверка на нового юзера
   *
   * @param u Экзмепляр юзера
   * @return Ответ на вопрос "Это новый юзер?"
   */
  @Override
  public boolean isNewUser(User u) {
    for (User user : arrayUsers) {
      if (user.getChatID().equals(u.getChatID())) {
        return false;
      }
    }
    return true;
  }

  /**
   * Метод для отравки текста одному отдельному юзеру
   *
   * @param u Экзепляр юзера
   * @param text Текст сообщения
   */
  public void send(User u, String text) {
    SendMessage message = createMessage(text, u.getChatID());

    try {
      execute(message); // Call method to send the message
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }

  /**
   * Собирает сообщение
   * Оказалось немного геморройным занятием,
   * поэтому выделил отделюный метод под это
   *
   * @param msg Текст сообщения
   * @param chatID ИД чата, тоже в виде String
   * @return Объект SendMessage, готовый к отправке
   */
  private SendMessage createMessage(String msg, String chatID) {
    SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
    message.setChatId(chatID);
    message.setText(msg);
    return message;
  }

  /**
   * Обновляет список в GUI в элементе label
   *
   * Так как GUI состоит только из статических методов,
   * то им можно управлять из любого класса
   *
   * Это и хорошо, и плохо одновременно
   */
  private void updateNamesList() {
    List<String> names = new ArrayList<>();

    for (User u : arrayUsers) {
      names.add(u.getName());
    }

    GUI.updateList(names);
  }
}

