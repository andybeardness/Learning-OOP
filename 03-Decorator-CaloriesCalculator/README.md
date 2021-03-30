# Паттерн : Декоратор

Паттерн декорирует объект, изменяя его реализацию

Декорировать нужно до тех пор, пока объект не стал подходящим

----

## Проект : Калькулятор калорий с GUI (CaloriesCalculator)

Приложение может посчитать суточную норму калорий, учитывая:

- Пол
- Возраст
- Вес
- Рост

Формула :

Формула Тома Венуто взята с [сайта](https://medsoftpro.ru/kalkulyatory/bazovyj-obmen-veshchestv.html#:~:text=Из-за значительного изменения образа,в годах %2B 5 - для мужчин)

	Вот, что про неё пишут :
		> Среди спортсменов весьма популярна формула, разработанная бодибилдером и фитнес-тренером Томом Венуто 


	Вот так она выглядит :
		> 66 + (13,7 × вес в кг) + (5 × рост в см) - (6,8 × возраст в годах) - для мужчин
		> 665 + (9,6 × вес в кг) + (1,8 × рост в см) - (4,7 × возраст в годах) - для женщин

Пример работы программы :

![CaloriesCalculator.gif](https://raw.githubusercontent.com/andybeardness/Learning-OOP/main/imgs/CaloriesCalculator.gif)

----

### О реализации :

Декоратор в основе имеет абстрактную реализацию [Base](https://github.com/andybeardness/Learning-OOP/blob/main/03-Decorator-CaloriesCalculator/src/AppCalories/CaloriesCalculator/Base/CaloriesBase.java)

У которой есть два наследника :
	
- [Gender](https://github.com/andybeardness/Learning-OOP/blob/main/03-Decorator-CaloriesCalculator/src/AppCalories/CaloriesCalculator/Genders/CaloriesGender.java) - Отвечает за пол человека. С него начинается декарирование
- [Feature](https://github.com/andybeardness/Learning-OOP/blob/main/03-Decorator-CaloriesCalculator/src/AppCalories/CaloriesCalculator/Features/CaloriesFeature.java) - Отвечает за фичи, которые корректируют подсчёт калорий

Реализации пола :

- [Male](https://github.com/andybeardness/Learning-OOP/blob/main/03-Decorator-CaloriesCalculator/src/AppCalories/CaloriesCalculator/Genders/CaloriesGenderMale.java) - Мужской
- [Female](https://github.com/andybeardness/Learning-OOP/blob/main/03-Decorator-CaloriesCalculator/src/AppCalories/CaloriesCalculator/Genders/CaloriesGenderFemale.java) - Женский

Разновидности фич :

- [Age](https://github.com/andybeardness/Learning-OOP/blob/main/03-Decorator-CaloriesCalculator/src/AppCalories/CaloriesCalculator/Features/CaloriesFeatureAge.java) - Отвечает за учёт возраста
- [Weight](https://github.com/andybeardness/Learning-OOP/blob/main/03-Decorator-CaloriesCalculator/src/AppCalories/CaloriesCalculator/Features/CaloriesFeatureWeight.java) - Отвечает за учёт веса
- [Height](https://github.com/andybeardness/Learning-OOP/blob/main/03-Decorator-CaloriesCalculator/src/AppCalories/CaloriesCalculator/Features/CaloriesFeatureHeight.java) - Отвечает за учёт роста

Для реализации новой фичи необходимо :

- Создать класс, который наследуется от [Feature](https://github.com/andybeardness/Learning-OOP/blob/main/03-Decorator-CaloriesCalculator/src/AppCalories/CaloriesCalculator/Features/CaloriesFeature.java) и имеет такой код

	```java
	/**
	 * Декоратор для учёта кислорода в воздухе, например
	 */
	public class CaloriesFeatureOxy extends CaloriesFeature {

	  /**
	   * Конструктор декоратора
	   *
	   * @param oxy Количество кислорода
	   * @param cb Персона
	   */
	  public CaloriesFeatureOxy(double oxy, CaloriesBase cb) {
	    this.value = oxy; // Присваем value наше значение oxy
	    this.cb = cb; // Ссылаемся на персону

	    // Подсчет коэффициента
	    // 1.4 -- Коэффициент для женщин
	    // 8.8 -- Коэффициент для мужчин
	    this.coef = cb.getGender() ? 1.4 : 8.8;
	  }

	}
	```

- Создать своего слушателя для кнопки "Посчитать" и реализовать его примерно так

	```java
	/**
	 * Класс для кастомного слушателя
	 *
	 * Так как в нём обрабатываются декораторы -- его нужно вынести,
	 *    чтобы в будущем апгрейдить приложение, добавляя декораторы
	 */
	public class CaloriesButtonListenerWithOxy implements CaloriesButtonListenerInterface {

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
	  public ActionListener getListener(boolean isFemale, double age, double weight, double height, double oxy, JLabel label) {
	    return new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	        // Создаю персону исходя из пола
	        CaloriesBase person = isFemale ? new CaloriesGenderFemale() : new CaloriesGenderMale();

	        // Модифицирую декораторами
	        person = new CaloriesFeatureAge(age, person);
	        person = new CaloriesFeatureWeight(weight, person);
	        person = new CaloriesFeatureHeight(height, person);
	        person = new CaloriesFeatureOxy(oxy, person); // Наш декоратор с фичей

	        // Меняю текст на лейбле с результатом
	        label.setText(
	            "<html>" +
	                "<p> Ваша норма калорий : " + (long) person.getCalories() + " ккал в день</p>" +
	                "</html>");
	      }
	    };
	  }
	}

	```

- Инициализировать GUI с этим слушателем

	```java
	/**
	 * Класс приложения
	 * Запускает ГУИ
	 */
	public class AppOxy {

	  /**
	   * Запуск ГУИ
	   */
	  public void run() {
	    new GUI(new CaloriesButtonListenerWithOxy()).run();
	  }
	}
	```

----

### Плюсы и минусы реализации : 

#### ✔️ Плюсы :

- ✔️ Позволяет легко добавлять новые факторы, влияющие на норму калорий
- ✔️ Также можно легко корректировать имеющиеся факторы

#### ❌ Минусы :

- ❌ Не уверен, что есть необходимость в классе [Base](https://github.com/andybeardness/Learning-OOP/blob/main/03-Decorator-CaloriesCalculator/src/AppCalories/CaloriesCalculator/Base/CaloriesBase.java). Возможно, следует обойтись только классом [Gender](https://github.com/andybeardness/Learning-OOP/blob/main/03-Decorator-CaloriesCalculator/src/AppCalories/CaloriesCalculator/Genders/CaloriesGender.java)

	