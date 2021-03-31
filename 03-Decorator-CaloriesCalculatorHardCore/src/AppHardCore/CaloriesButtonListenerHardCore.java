package AppHardCore;

import AppCalories.CaloriesCalculator.Base.CaloriesBase;
import AppCalories.CaloriesCalculator.Features.CaloriesFeatureAge;
import AppCalories.CaloriesCalculator.Features.CaloriesFeatureHeight;
import AppCalories.CaloriesCalculator.Features.CaloriesFeatureWeight;
import AppCalories.CaloriesCalculator.Genders.CaloriesGenderFemale;
import AppCalories.CaloriesCalculator.Genders.CaloriesGenderMale;
import AppCalories.GUI.CaloriesButtonListenerInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Хардкорный слушатель
 * Имеет добавочный декоратор CaloriesFeatureHardCore
 */
public class CaloriesButtonListenerHardCore implements CaloriesButtonListenerInterface {

  /**
   * Возвращает слушателя
   *
   * @param isFemale Ответ на вопрос "Персона является женщиной?"
   * @param age Возраст
   * @param weight Вес
   * @param height Рост
   * @param label Ссылка на объект, где должен выводиться результат
   *
   * @return Слушатель для кнопки "Посчитать"
   */
  @Override
  public ActionListener getListener(boolean isFemale, double age, double weight, double height, JLabel label) {
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Создаю персону исходя из пола
        CaloriesBase person = isFemale ? new CaloriesGenderFemale() : new CaloriesGenderMale();

        // Модифицирую декораторами
        person = new CaloriesFeatureAge(age, person);
        person = new CaloriesFeatureWeight(weight, person);
        person = new CaloriesFeatureHeight(height, person);
        person = new CaloriesFeatureHardCore(1, person);

        // Меняю текст на лейбле с результатом
        label.setText(
            "<html>" +
                "<p> Ваша норма калорий : " + (long) person.getCalories() + " ккал в день</p>" +
                "</html>");
      }
    };
  }
}
