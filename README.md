# Learning-OOP

Учу ООП и конспектирую тут всё, что прочитал в книге от **"Head First : Паттерны проектирования"**

Также добавляю свои реализации паттернов. Может быть что-то ещё. Посмотрим по ситуации

![book](https://raw.githubusercontent.com/andybeardness/Learning-OOP/main/imgs/book.jpg)

Несмотря на лёгкий кринж от обложки, книга настолько крутая, что хочется её советовать каждому

----

## Зачем?

В первый раз прочитал эту книгу где-то полгода назад (_летом 2020_). Но без закрепления и конспектов сложно вспомнить основные идеи

Поэтому хочу под каждый паттерн написать простое приложение. Но перепечатывать примеры из книги не вижу смысла

Планирую сделать свои решения, которые придут в голову. А это значит, что в них будет много математики и машинного обучения 🤓

----

## Зачем это выкладывать?

Для самоконтроля

Как было в репе [Learning-C](https://github.com/andybeardness/Learning-C)

----

## Принципы

1.	**Выбрать аспекты, которые могу измениться, и отделить от тех, которые всегда останутся постоянными**
	> Выделить то, что изменяется и "инкапсулировать" эти аспекты, чтобы они не влияли на работу остального кода. Тогда будет меньше последствий от изменения кода + высокая гибкость системы

2.	**Программировать на уровне "интерфеса", а не на уровне "реализации"**
	> "Интерфейс" не обязательно означает interface (как в Java). Это что-то вроде модели поведения, которую можно выбрать отдельно и даже менять "на лету"

3. 	**Отдавать предпочтение "композииции" перед "наследованием"**
	> Можно сделать поведение не наследуемым, а настраиваемым, благодаря отдельным объектам, отвечающим каждому аспекту поведения

4.	**Стремиться к слабой связанности взаимодействующих объектов**
	> На базе слабосвязанных архитектур строятся гибкие системы, которые быстро адаптируются к изменениям благодаря минимальным зависимостям между объектами

5. **Классы должны быть открыты для расширения, но закрыты для изменения**
	> Это нужно для расширения класса новым поведением и ради запрета на изменение уже отлаженного кода

6. **Код должен зависить от абстракций, а не от конкретных классов**
	> Можно спрятать создание объекта за методом, который вернёт нужный объект. Так мы получаем больше контроля за созданием объекта

7. **Принцип минимальной информированности**
	> "Общайтесь только с близкими друзьями". Это значит, что нужно обратить внимание на количество классов, с которыми взаимодействует объект, и каким образом организовано это взаимодействие

8. **Голливудский принцип**
	> "Не вызывайте нас -- мы вас сами вызовем". Это значит, что низкоуровневые зависимости не должны вызывать высокоуровневые. А если совсем избавиться невозможно, то привести эти вызовы к минимуму

9. **Класс должен иметь только одну причину для изменения**
	> Модификация кода сопровождается массой проблем. Поэтому, чем меньше у класса задач, тем меньше у него причин для изменения

----

## Паттерны

- ✔️ **Стратегия**
	> Определяет семейство алгоритмов, инкапсулирует каждый из них, обеспечивает взаимозаменяемость. Он позволяет модифицировать алгоритмы независимо от их использования на стороне клиента

	Реализации :

	- [Решатель квадратных уравнений](https://github.com/andybeardness/Learning-OOP/tree/main/01-Strategy-QuadraticEquation)
	- [Решатель квадратных уравнений 2.0](https://github.com/andybeardness/Learning-OOP/tree/main/01-Strategy-QuadraticEquationV2)
	- [Решатель квадратных уравнений 3.0](https://github.com/andybeardness/Learning-OOP/tree/main/01-Strategy-QuadraticEquationV3)

- ✔️ **Наблюдатель**
	> Определяет отношением "один ко многим" между объектами так, что при изменении состояния одного объекта происходит автоматическое оповещение и обновление всех зависимых объектов

	Реализации :

	- [Telegram-Оповещатель с GUI](https://github.com/andybeardness/Learning-OOP/tree/main/02-Observer-TelegramNotify)
	- [Telegram-Оповещатель с GUI 2.0](https://github.com/andybeardness/Learning-OOP/tree/main/02-Observer-TelegramNotifyV2)

- ✔️ **Декоратор**
	> Добавляет уже сущестующему объекту новое поведение, декарируя старый класс новым. Наследование в нём используется только ради согласования типов

	Реализации :

	- [Калькулятор калорий с GUI](https://github.com/andybeardness/Learning-OOP/tree/main/03-Decorator-CaloriesCalculator)
	- [Калькулятор калорий с GUI Hard Core](https://github.com/andybeardness/Learning-OOP/tree/main/03-Decorator-CaloriesCalculatorHardCore)

- ✔️ **Простая фабрика и Фабричный метод** :
	> Определяет интерфейс создания объекта. При этом позволяет субклассам выбрать класс создаваемого экземпляра. Таким образом, ФМ делегирует операцию создания экзепляра субклассам

	Реализации :

	- [Адаптиное GUI >> Время](https://github.com/andybeardness/Learning-OOP/tree/main/04-FactoryMethod-AdaApp)

- ✔️ **Абстрактная фабрика** :
	> Предоставляет интерфейс создания семейств взаимосвязанных или взаимозависимых объектов без указания их конкретных классов
	
	Реализации :
	
	- [Адаптиное GUI >> Время + Язык + Страна](https://github.com/andybeardness/Learning-OOP/tree/main/05-AbstractFactory-AdaAppPlus)

- ✔️ **Одиночка** :
	> Гарантирует, что класс имеет только один экземпляр, и предоставляет глобальную точку доступа к этому экземпляру
	
	Реализации :
	
	- [Telegram-Очередь с GUI](https://github.com/andybeardness/Learning-OOP/tree/main/06-Singleton-TelegramQueue)

- ✔️ **Команда** :
	> Инкапсулирует запрос в виде объекта, делая возможной параметризацию клиентских объектов с другими запросами, организацию очереди или регистрацию запросов, а также поддержку отмены операций

	Реализации :
	
	- [Пуль управления Windows](https://github.com/andybeardness/Learning-OOP/tree/main/07-Command-WindowsController)

- ✔️ **Адаптер** :
	> Преобразует интерфейс класса к другому интерфейсу, на который рассчитан клиент. Адаптер обеспечивает совместную работу классов, невозможную в обычных условиях из-за несовместимости интерфейсов

	Реализации :
	
	- [Определение простого числа](https://github.com/andybeardness/Learning-OOP/tree/main/08-Adapter-PlainNumberSolver)

- ✔️ **Фасад** :
	> Предоставляет унифицированный интерфейс к группе интерфейсов подсистемы. Фасад определеляет высокоуровневый интерфейс, упрощающий работу с подсистемой

	Реализации :
	
	- [Рисователь линий](https://github.com/andybeardness/Learning-OOP/tree/main/09-Facade-LinesDraw)

- ✔️ **Шаблонный метод** :
	> Задаёт "скелет" алгоритмы в методе, оставляя определение реализации некоторых шагов субклассам. Субклассы могут переопределять некоторые части алгоритма без изменения его структуры

	- [Вычисление определённого интеграла](https://github.com/andybeardness/Learning-OOP/tree/main/10-TemplateMethod-IntegralSolver)

- ✔️ **Итератор** :
	> Предоставляет механизм последоавтельного перебора элементов коллекции без раскрытия ее внутреннего представления

	- [Вычислитель списков МО алгоритмов >> Линейные регрессии](https://github.com/andybeardness/Learning-OOP/tree/main/11-Iterator-ListsML)

- ✔️ **Компоновщик** :
	> Объединяет объекты в древовидные структуры для представление иерархий "часть/целое". Компоновщик позволяет клиенту выполнять однородные операции с отдельными объектами и их совокупностями

	- [Вычислитель списков МО алгоритмов >> Линейные регрессии + Ансамбли линейных регрессий](https://github.com/andybeardness/Learning-OOP/tree/main/12-Composite-ListsEnseblesML)

- ✔️ **Состояние** :
	> Управляет изменением поведение объекта при изменении его внутреннего состояния. Внешне это выглядит так, словно объект меняет свой класс

	- [Анализ марковских процессов состояний в поликлинике](https://github.com/andybeardness/Learning-OOP/tree/main/13-State-MarkovHospital)

- 🔸 **Заместитель** :
	> Предоставляет суррогатный объект, управляющий доступом к другому объекту

	- [Проверка курсов доллара и евро с GUI](https://github.com/andybeardness/Learning-OOP/tree/main/14-Proxy-ExchangeRatesGUI)

----

## Проекты

_Тут будут ссылки на домашние проекты с применением двух и более паттернов_

_Если ничего в голову не придёт, то удалю этот раздел_


----

## Резюме

_Тут сделаю заключение, как было в репозитории Learning-C_