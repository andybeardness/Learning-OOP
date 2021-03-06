# Паттерн : Комманда

Аггрегирует разные классы под один интерфейс управления

Причём максимально отделяет реализацию классов от реализации управления

----

## Проект : Пуль управления Windows (WindowsController)

Окно для быстрого доступа к стандартным, и не только, прилагам винды

Пример работы :

![WindowsController.gif](https://github.com/andybeardness/Learning-OOP/blob/main/imgs/WindowsController.gif)

----

### О реализации :

В этом проекте не удалось раскрыть полностью паттерн Команда. Так как Swing тоже требует свой интерфейс для работы. И финальный "пульт управления" тоже имеет свои условия реализации

Сам паттерн реализован в пакете [Command](https://github.com/andybeardness/Learning-OOP/tree/main/07-Command-WindowsController/src/ControllerApp/Command)

В нём есть такие файлы :

- [Command](https://github.com/andybeardness/Learning-OOP/blob/main/07-Command-WindowsController/src/ControllerApp/Command/Command.java) : Интерфейс паттерна
- [CommandOpenCalc](https://github.com/andybeardness/Learning-OOP/blob/main/07-Command-WindowsController/src/ControllerApp/Command/CommandOpenCalc.java) : Конкретный класс для открытия Калькулятора
- [CommandOpenNote](https://github.com/andybeardness/Learning-OOP/blob/main/07-Command-WindowsController/src/ControllerApp/Command/CommandOpenNote.java) : Конкретный класс для открытия Блокнота
- [CommandOpenPaint](https://github.com/andybeardness/Learning-OOP/blob/main/07-Command-WindowsController/src/ControllerApp/Command/CommandOpenPaint.java) : Конкретный класс для открытия Paint

----

### Плюсы и минусы реализации : 

#### ✔️ Плюсы :

- ✔️ Хороший паттерн, помогает объединить разные интерфейсы под одну гребёнку
- ✔️ Понравилось отделять одну логику от другой

#### ❌ Минусы :

- ❌ Как говорил выше, не удалось качественно показать работу паттерна. А делать примитивные примеры с уточками не хотелось
- ❌ Нет такой красоты, как в книге с их "пультом". Можно обойтись и без этого паттерна в данном концепте
