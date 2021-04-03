package Q;

import Users.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс для очереди
 *
 * Реализован с паттерном Одиночка (синглтон)
 */
public class Q {

  private static Q q; // Объект класса
  private LinkedList<User> users; // Очередь

  /**
   * Закрытый конструктор
   */
  private Q() {
    users = new LinkedList<>();
  }

  /**
   * Получаем единственный объект класса
   *
   * @return Единственный объект класса
   */
  public static Q getInstance() {
    if (q == null) {
      q = new Q();
    }
    return q;
  }

  /**
   * @return Ответ на вопрос "Есть ли следующий?"
   */
  public boolean hasNext() {
    return !users.isEmpty();
  }

  /**
   * Добавляет пользователя
   *
   * @param u Объект пользователя
   */
  public void add(User u) {
    users.add(u);
  }

  /**
   * Возвращает первого в очереди
   *
   * @return Первый юзер в очереди
   */
  public User getNext() {
    return users.removeFirst();
  }

  /**
   * Удаляет пользователя
   *
   * @param u Объект юзера
   */
  public void removeUser(User u) {
    for (User user : users) {
      if (user.equals(u)) {
        users.remove(u);
      }
    }
  }

  /**
   * Для обновления списка в ГУИ
   *
   * @return Имена всех пользователей
   */
  public List<String> getUserNames() {
    List<String> names = new ArrayList<>();

    for (User u : users) {
      names.add(u.getName());
    }

    return names;
  }

  /**
   * Проверка на нового пользователя
   *
   * @param u Объект пользователя
   * @return Ответ на вопрос "Этот пользователь новый?"
   */
  public boolean isNewUser(User u) {
    for (User user : users) {
      if (user.equals(u)) {
        return false;
      }
    }

    return true;
  }

}