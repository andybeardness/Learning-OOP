package TGBot;

/**
 * Класс со статическими методами, которые возвращают те или иные соодщения
 */
public class BotMsg {

  /**
   * Если пользователь подписался, но не был подписан до этого
   *
   * @return Текст сообщения
   */
  public static String getMsgYouAreFollowing() {
    return "❤️ Ты подписался";
  }

  /**
   * Если пользователь подписался, хотя уже был подписан
   *
   * @return Текст сообщения
   */
  public static String getMsgYouAlreadyFollowing() {
    return "❤️ Ты уже был подписан";
  }

  /**
   * Если пользователь отписался, а до этого был подписан
   *
   * @return Текст сообщения
   */
  public static String getMsgYouAreUnfollowing() {
    return "\uD83D\uDC99 Ты отписался";
  }

  /**
   * Если пользователь отписался, хотя до этого был отписан
   *
   * @return Текст сообщения
   */
  public static String getMsgYouAlredyUnfollowing() {
    return "\uD83D\uDC99 Ты уже был отписан";
  }

  /**
   * Сообщение для оповещения всех подписанных пользователей
   *
   * @return Текст сообщения
   */
  public static String getMsgNotify() {
    return "☝️Напоминание!";
  }
}
