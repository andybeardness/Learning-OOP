# Паттерн : Наблюдатель

Суть паттерна в пректировании единого "интерфейса" для взаимодействия со всем наблюдателями

----

## Проект : Telegram-Оповещатель с GUI 2.0 (TelegramNotifyV2)

Приложение позволяет добавлять наблюдателей через телеграм-бота и делать оповещение для них через GUI на ПК

Пример работы программы :

![TelegramNotify.gif](https://raw.githubusercontent.com/andybeardness/Learning-OOP/main/imgs/TelegramNotify.gif)

----

### О реализации :

- 👄 Источник : Приложение на Java-Swing
- 👂 Наблюдатель : Юзер телеграм-бота

Интерфейс [Subject](https://github.com/andybeardness/Learning-OOP/blob/main/02-Observer-TelegramNotifyV2/src/TGBot/Subject.java) позволяет работать с наблюдателями

Его реализует класс [Bot](https://github.com/andybeardness/Learning-OOP/blob/main/02-Observer-TelegramNotifyV2/src/TGBot/Bot.java), который напрямую работает с юзерами

----

### Плюсы и минусы реализации :

#### ✔️ Плюсы :

- ✔️ Реализации "субъекта" и "наблюдателей" при таком подходе делают проект более гибким
- ✔️ Бот и GUI работают на разных потоках, что хорошо в плане быстродействия
- ✔️ Части приложения логично разнесены по частям, что тоже даёт + к гибкости
- ✔️ (новое) Убрал связь между GUI и ТГ-ботом. Это позволяет дорабатывать один элемент, не боясь повредить другой
- ✔️ (новое) Теперь за всё отвечает класс App, который в себе аггрегирует нужные аттрибуты и методы
- ✔️ (новое) Реализовал интерфейсы у GUI, ТГ-бота и Юзера

#### ❌ Минусы :

- ❌ Остаётся чувство, что можно сделать ещё элегантнее

	