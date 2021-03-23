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

----

## Паттерны

- ✔️ Стратегия
	> Определяет семейство алгоритмов, инкапсулирует каждый из них, обеспечивает взаимозаменяемость. Он позволяет модифицировать алгоритмы независимо от их использования на стороне клиента

	Реализации:

	- [Решатель квадратных уравнений](https://github.com/andybeardness/Learning-OOP/tree/main/01-Strategy-QuadraticEquation)
	- [Решатель квадратных уравнений 2.0](https://github.com/andybeardness/Learning-OOP/tree/main/01-Strategy-QuadraticEquationV2)
	- [Решатель квадратных уравнений 3.0](https://github.com/andybeardness/Learning-OOP/tree/main/01-Strategy-QuadraticEquationV3)

----

## Проекты

_Тут будут ссылки на домашние проекты с применением двух и более паттернов_

_Если ничего в голову не придёт, то удалю этот раздел_


----

## Резюме

_Тут сделаю заключение, как было в репозитории Learning-C_