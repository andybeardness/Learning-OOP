package Application;

import GUI.GUI;
import MyThreads.ThreadGUI;
import MyThreads.ThreadTG;
import TGBot.Bot;
import TGBot.BotMsg;
import Users.User;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.swing.JButton;
import java.util.ArrayList;
import java.util.List;

public class App {

  private static Bot bot; // Бот
  private static GUI gui; // Интерфейс

  private static List<Thread> threadList; // Список потоков
  private static List<User> arrayUsers; // Список подписантов

  /**
   * Главная функция, запускает приложение
   */
  public static void run() {
    initApp(); // Инициализация
    runAllThreads(); // Запускает потоки
  }

  /**
   * Метод для взаимодействия с командами в чате
   * Читает сообщение, собирает ответ и отправляет
   *
   * @param update Входящий параметр из библиотечки ТГ бота
   */
  public static void onUpdateReceived(Update update) {
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
        bot.send(user, response);
      }
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
  public static SendMessage createMessage(String msg, String chatID) {
    SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
    message.setChatId(chatID);
    message.setText(msg);
    return message;
  }

  /**
   * Инициализация
   * Делает предвариельную подготовку
   */
  private static void initApp() {
    // Инициализирует бота и интерфейс
    bot = new Bot("NotifyBot", "1746127013:AAGNlQxutbCumSYtxKy7O0zC7zr_aNHnnbM");
    gui = new GUI();
    gui.initGUI();

    // Инициализирует списки
    threadList = new ArrayList<>();
    arrayUsers = new ArrayList<>();

    // Добавляет в список потоков два потока : бота и интерфейса
    threadList.add(new ThreadGUI(gui));
    threadList.add(new ThreadTG(bot));

    // Регистрирует слушателя для кнопки
    registerActionListener();
  }

  /**
   * Регистрация слушателя для кнопки ГУИ
   */
  private static void registerActionListener() {
    gui.getButton().addActionListener(e -> sendNotifies());
  }

  /**
   * Через цикл запускает каждый поток
   */
  private static void runAllThreads() {
    for (Thread t : threadList) {
      t.start();
    }
  }

  /**
   * Добавляет юзера в наблюдатели
   *
   * @param u Экзмепляр юзера
   */
  private static void addUser(User u) {
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
  private static void removeUser(User u) {
    arrayUsers.removeIf(user -> user.getChatID().equals(u.getChatID()));
    updateNamesList();
  }

  /**
   * Обновляет список в GUI в элементе label
   */
  private static void updateNamesList() {
    List<String> names = new ArrayList<>();

    for (User u : arrayUsers) {
      names.add(u.getName());
    }

    gui.updateList(names);
  }

  /**
   * Проверка на нового юзера
   *
   * @param u Экзмепляр юзера
   * @return Ответ на вопрос "Это новый юзер?"
   */
  private static boolean isNewUser(User u) {
    for (User user : arrayUsers) {
      if (user.getChatID().equals(u.getChatID())) {
        return false;
      }
    }
    return true;
  }

  /**
   * Циклом для каждого юзера отправляет напоминание
   */
  private static void sendNotifies() {
    for (User u : arrayUsers) {
      bot.send(u, BotMsg.getMsgNotify());
    }
  }

}
