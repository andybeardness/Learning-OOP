package Users;

public class User {
  private String name, chatID;

  public User(String name, String chatID) {
    this.name = name;
    this.chatID = chatID;
  }

  public String getName() {
    return name;
  }

  public String getChatID() {
    return chatID;
  }
}
