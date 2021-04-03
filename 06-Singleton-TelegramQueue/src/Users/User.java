package Users;

/**
 * Клас юзера
 */
public class User implements UserFace {

  private String name, chatID; // Имя и ИД чата (оба стринг)

  /**
   * Конструктор
   *
   * @param name Имя
   * @param chatID ИД чата (стринг)
   */
  public User(String name, String chatID) {
    this.name = name;
    this.chatID = chatID;
  }

  /**
   * Геттер для имени
   *
   * @return Имя юзера
   */
  public String getName() {
    return name;
  }

  /**
   * Геттер для ИД чата
   *
   * @return ИД чата
   */
  public String getChatID() {
    return chatID;
  }
}
