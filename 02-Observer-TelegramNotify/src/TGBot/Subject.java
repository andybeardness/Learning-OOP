package TGBot;

import Users.User;

/**
 * Интерфейс для работы с паттерном "Наблюдатель"
 */
public interface Subject {
  void addUser(User u); // Добавить юзера в наблюдатели
  void removeUser(User u); // Удалить юзера из наблюдателей
  void sendMessages(); // Отправить всем наблюдателям сообщение
  boolean isNewUser(User u); // Проверка "Является ли юзер новым?"

}
