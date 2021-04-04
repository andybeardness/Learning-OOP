# Паттерн : Итератор

Суть паттерна в помощи с объединением двух разных списков через один интерфейс

----

## Проект : Вычислитель списков МО алгоритмов (ListsML)

Вычисляет Вес по Росту и Гендеру с помощью машинного обучения

Внутри есть 20 ML-алгоритмов Линейной регрессии

Все они обучались на своём куске [этого датасета](https://www.kaggle.com/mustafaali96/weight-height)

Про него я писал статью на [Хабре](https://habr.com/ru/post/466123/)

От пользователя нужно ввести рост и выбрать пол, после чего нажать кнопку "Посчитать"

Все 20 моделей посчитают каждая свой результат

Вот пример работы :

![ListsML.gif](https://github.com/andybeardness/Learning-OOP/blob/main/imgs/ListsML.gif)

----

### О реализации :

За основу взял два класса Итератора, которые в себе имеют список моделей

- [MLStackArrayList](https://github.com/andybeardness/Learning-OOP/blob/main/11-Iterator-ListsML/src/ML/MLStackOne/MLStackArrayList.java) : Модели хранятся в ArrayList
- [MLStackLinkedList](https://github.com/andybeardness/Learning-OOP/blob/main/11-Iterator-ListsML/src/ML/MLStackTwo/MLStackLinkedList.java) : Модели хранятся в LinkedList

Просто так объединить их нельзя. На помощь приходит паттерн Итератор

Я объединил обе модели в классе [MLIterator](https://github.com/andybeardness/Learning-OOP/blob/main/11-Iterator-ListsML/src/ML/MLIterator/MLIterator.java)

А решение окончательное решение вынес в класс [MLSolver](https://github.com/andybeardness/Learning-OOP/blob/main/11-Iterator-ListsML/src/ML/MLIterator/MLSolver.java)

Также стоит немного сказать о других классах :

- [DataItem](https://github.com/andybeardness/Learning-OOP/blob/main/11-Iterator-ListsML/src/ML/DataItem.java) : Реализует единицу данных. Именно её формирует ГУИ
- [Model](https://github.com/andybeardness/Learning-OOP/blob/main/11-Iterator-ListsML/src/ML/Model/Model.java) : Реализует единичную модель
- [MLValuesStatic](https://github.com/andybeardness/Learning-OOP/blob/main/11-Iterator-ListsML/src/ML/MLIterator/MLValuesStatic.java) : Тут статически собраны веса и байесы всех моделией
- [GUI](https://github.com/andybeardness/Learning-OOP/blob/main/11-Iterator-ListsML/src/GUI/GUI.java) : Класс, отвечающий за интерфейс для пользователя
- [App](https://github.com/andybeardness/Learning-OOP/blob/main/11-Iterator-ListsML/src/App/App.java) : Класс, аккумулирующий работу всего приложения

----

### Плюсы и минусы реализации : 

#### ✔️ Плюсы :

- ✔️ Разные списки можно соединить в один благораря паттерну

#### ❌ Минусы :

- ❌ Кажется, я не совсем удачно его реализовал. Но для учебного проекта должно быть норм
