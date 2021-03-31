# Паттерн : Фабричный метод

Создаёт класс, который занимается созданием объектов (тавология детектед)

Смысл в том, чтобы вынести создание объектов подальше и инкапсулировать в специальном для этого классе

----

## Проект : Адаптиное GUI >> Время (AdaApp)

Приложение следит за временем, когда оно было открыто

- Если открывается с 6:00 до 22:00, то есть днём, то экран такой :

![AdaApp-DayMode](https://raw.githubusercontent.com/andybeardness/Learning-OOP/main/imgs/FactoryMethod-AdaApp-Day.png)

- Если открывается в другое время, то есть ночью, то такой :

![AdaApp-NightMode](https://raw.githubusercontent.com/andybeardness/Learning-OOP/main/imgs/FactoryMethod-AdaApp-Night.png)

----

### О реализации :

Фабрика тут в объектах интерфейса. Каждая фабрика в конструкторе принимает час суток. Исходя из этого фабрика решает, какой объект вернуть -- со светлой темой (день) или с тёмной (ночь)

Тут использую четыре фабрики :

- [Фрейм](https://github.com/andybeardness/Learning-OOP/blob/main/04-FactoryMethod-AdaApp/src/Application/Factory/Frame/FactoryMethodFrameDN.java) -- для, собственно, приложения
- [Панель](https://github.com/andybeardness/Learning-OOP/blob/main/04-FactoryMethod-AdaApp/src/Application/Factory/Panel/FactoryMethodPanelDN.java) -- для раположения элементов
- [Лейбл](https://github.com/andybeardness/Learning-OOP/blob/main/04-FactoryMethod-AdaApp/src/Application/Factory/Label/FactoryMethodLabelDN.java) -- для отображения даты-времени
- [Кнопка](https://github.com/andybeardness/Learning-OOP/blob/main/04-FactoryMethod-AdaApp/src/Application/Factory/Button/FactoryMethodButtonDN.java) -- для красоты

Быстрый обзор по пакетам :

- [Colors](https://github.com/andybeardness/Learning-OOP/tree/main/04-FactoryMethod-AdaApp/src/Application/Colors)
	> Там статический класс, отвечающий за цвета [Monokai](https://marketplace.visualstudio.com/items?itemName=SuperPaintman.monokai-extended)

- [Dater](https://github.com/andybeardness/Learning-OOP/tree/main/04-FactoryMethod-AdaApp/src/Application/Dater)
	> Там два класса : один отвечает за расписание смены дневной и ночной темы приложения, а второй за обновление времени. В общем, они отвечают за работу со временем

- [Factory](https://github.com/andybeardness/Learning-OOP/tree/main/04-FactoryMethod-AdaApp/src/Application/Factory)
	> Тут все фабрики разбитые по пакетам. В каждом пакете есть абстрактный класс и реализация

- [GUI](https://github.com/andybeardness/Learning-OOP/tree/main/04-FactoryMethod-AdaApp/src/Application/GUI)
	> Класс, отвечающий за GUI

- [Threads](https://github.com/andybeardness/Learning-OOP/tree/main/04-FactoryMethod-AdaApp/src/Application/Threads)
	> Классы, отвечающие за потоки. Один поток запускает GUI, второй обновляет в нём время

Файл [App](https://github.com/andybeardness/Learning-OOP/blob/main/04-FactoryMethod-AdaApp/src/Application/App.java) нужен для запуска приложения. Он инициализирует GUI и два потока и запускает всё, что нужно

----

### Плюсы и минусы реализации : 

#### ✔️ Плюсы :

- ✔️ Хороший паттерн, мне кажется, я реализовал его хорошо. Гибко, удобно, понятно, наглядно, шикарно и тд


#### ❌ Минусы :

Нет минусов, идеальное ПО, идеальная реализация