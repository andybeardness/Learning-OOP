package TGBot;

import Users.User;

/**
 * Интерфейс для работы с паттерном "Наблюдатель"
 */
public interface Subject {
  void run(); // Собстевнно, запуск бота
  void send(User u, String text); // Отправить всем наблюдателям сообщение
}
