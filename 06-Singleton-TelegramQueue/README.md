# Паттерн : Одиночка

Бывает нужно, чтобы конкретный объект был только один в системе

Паттерн предлагает несколько подходом для решения этой проблемы

----

## Проект : Telegram-Очередь с GUI (TelegramQueue)

Телеграм-бот, который решает проблему очереди

Форк от [Telegram-Оповещатель с GUI 2.0](https://github.com/andybeardness/Learning-OOP/tree/main/02-Observer-TelegramNotifyV2)

Ты регистрируешься в нём, он следит за очередью. А человек, в руках которого GUI, нажимая на кнопку вызывает следующего

Тут не будет картинки с самим проектом, так как это лишь дополнения для старого проекта

Поэтому вот мем про очередь :

![TelegramQueue.jpg](https://raw.githubusercontent.com/andybeardness/Learning-OOP/main/imgs/TelegramQueue.jpg)

----

### О реализации :

По сути -- это форк с дополнительной подпапкой [Q](https://github.com/andybeardness/Learning-OOP/tree/main/06-Singleton-TelegramQueue/src/Q), в которой реализован Одиночка

Там реализована очередь по принципу FIFO (Первый пришел, первым выйдешь)

В этой папке четыре реализации :

- [Q](https://github.com/andybeardness/Learning-OOP/blob/main/06-Singleton-TelegramQueue/src/Q/Q.java) : Тут стандартная форма. Используется в реализации
- [QInitBefore](https://github.com/andybeardness/Learning-OOP/blob/main/06-Singleton-TelegramQueue/src/Q/QInitBefore.java) : Тут инициализация объекта заранее
- [QSynchronized](https://github.com/andybeardness/Learning-OOP/blob/main/06-Singleton-TelegramQueue/src/Q/QSynchronized.java) : Тут потоко-безопасная синхронизированная версия
- [QVolatile](https://github.com/andybeardness/Learning-OOP/blob/main/06-Singleton-TelegramQueue/src/Q/QVolatile.java) : Тут потоко-безопасная волатильная версия

----

### Плюсы и минусы реализации : 

#### ✔️ Плюсы :

- ✔️ Помогает быстро решить проблему очереди. Особенно актуально в поликлиниках и подобном


#### ❌ Минусы :

- ❌ Нагруженная реализация бота, всё-таки. К реализации паттерна это отношения не имеет