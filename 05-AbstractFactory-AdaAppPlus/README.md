# Паттерн : Aбстрактная фабрика

В отличие от фабричного метода -- в основе имеет интферфейс для построение фабрики

Фабрика еще отличается тем, что может иметь несколько методов для создания объектов

Также может в себе содержать фабричный метод

А ещё абстрактную фабрику можно использовать для создания других абстрактных фабрик

----

## Проект : Адаптиное GUI >> Время + Язык + Страна (AdaAppPlus)

Как в случае с приложением [Адаптиное GUI >> Время](https://github.com/andybeardness/Learning-OOP/tree/main/04-FactoryMethod-AdaApp), в этой реализации есть учёт времени, чтобы менять тему приложения при запуске

Также тут есть учёт :

- Языка -- от этого зависит язык приложения
- Страны -- от этого зависит иконка флага внизу

Вот коллаж, который показывает все вариации приложения :

|  Язык  | День  | Ночь  |
| :----: | :---: | :---: |
|   RU   | ![AdaAppPlus-RU-DAY](https://raw.githubusercontent.com/andybeardness/Learning-OOP/main/imgs/AdaAppPlus-RU-DAY.png) | ![AdaAppPlus-RU-NIGHT](https://raw.githubusercontent.com/andybeardness/Learning-OOP/main/imgs/AdaAppPlus-RU-NIGHT.png) |
|   FR   | ![AdaAppPlus-FR-DAY](https://raw.githubusercontent.com/andybeardness/Learning-OOP/main/imgs/AdaAppPlus-FR-DAY.png) | ![AdaAppPlus-FR-NIGHT](https://raw.githubusercontent.com/andybeardness/Learning-OOP/main/imgs/AdaAppPlus-FR-NIGHT.png) |
|   CH   | ![AdaAppPlus-CH-DAY](https://raw.githubusercontent.com/andybeardness/Learning-OOP/main/imgs/AdaAppPlus-CH-DAY.png) | ![AdaAppPlus-CH-NIGHT](https://raw.githubusercontent.com/andybeardness/Learning-OOP/main/imgs/AdaAppPlus-CH-NIGHT.png) |
|  OTHER | ![AdaAppPlus-OTHER-DAY](https://raw.githubusercontent.com/andybeardness/Learning-OOP/main/imgs/AdaAppPlus-OTHER-DAY.png) | ![AdaAppPlus-OTHER-NIGHT](https://raw.githubusercontent.com/andybeardness/Learning-OOP/main/imgs/AdaAppPlus-OTHER-NIGHT.png) |

----

### О реализации :

[Фабрика](https://github.com/andybeardness/Learning-OOP/blob/main/05-AbstractFactory-AdaAppPlus/src/Application/Factory/Factory.java) создает разные объекты интерфейса :

- Фрейм
- Панель
- Лейбл
- Кнопку
- Картинку

Быстрый обзор по пакетам :

- [Colors](https://github.com/andybeardness/Learning-OOP/tree/main/05-AbstractFactory-AdaAppPlus/src/Application/Colors)
	> Там статический класс, отвечающий за цвета [Monokai](https://marketplace.visualstudio.com/items?itemName=SuperPaintman.monokai-extended)

- [Dater](https://github.com/andybeardness/Learning-OOP/tree/main/05-AbstractFactory-AdaAppPlus/src/Application/Dater)
	> Там два класса : один отвечает за расписание смены дневной и ночной темы приложения, а второй за обновление времени. В общем, они отвечают за работу со временем

- [Factory](https://github.com/andybeardness/Learning-OOP/tree/main/05-AbstractFactory-AdaAppPlus/src/Application/Factory)
	> Абстрактная фабрика и её интерфейс

- [GUI](https://github.com/andybeardness/Learning-OOP/tree/main/05-AbstractFactory-AdaAppPlus/src/Application/GUI)
	> Класс, отвечающий за GUI

- [Threads](https://github.com/andybeardness/Learning-OOP/tree/main/05-AbstractFactory-AdaAppPlus/src/Application/Threads)
	> Классы, отвечающие за потоки. Один поток запускает GUI, второй обновляет в нём время

Файл [App](https://github.com/andybeardness/Learning-OOP/blob/main/04-FactoryMethod-AdaApp/src/Application/App.java) нужен для запуска приложения. Он инициализирует GUI и два потока и запускает всё, что нужно

----

### Плюсы и минусы реализации : 

#### ✔️ Плюсы :

- ✔️ [x2] Хороший паттерн, мне кажется, я реализовал его хорошо. Гибко, удобно, понятно, наглядно, шикарно и тд


#### ❌ Минусы :

[x2] Нет минусов, идеальное ПО, идеальная реализация