# Паттерн : Заместитель

Паттер помогает отделить объект, который выполняет реальную работу, от объектов, которые им пользуются

Это нужно, если слишком частое или слишком прямое взаимодействие с объектом нежелательно

На помощь объекту-работяге приходит заместитель, который тыркает его только в нужные момент и не пускает никого в другие

----

## Проект : Проверка курсов доллара и евро с GUI (ExchangeRatesGUI)

Есть GUI, которое позволяет следить за курсом валют. Пользователь нажимает на кнопку, курсы валют обновляется

Курсы не могут обновляться чаще, чем раз в 5 секунд. Тогда статус поменяется с **ОK** на **WAIT**

Работает так :

![ExchangeRatesGUI.gif](https://github.com/andybeardness/Learning-OOP/blob/main/imgs/ExchangeRatesGUI.gif)

----

### О реализации :

Есть класс [Connecter](https://github.com/andybeardness/Learning-OOP/blob/main/14-Proxy-ExchangeRatesGUI/src/ExchangeRate/Connecter.java), который парсит [сайт](https://www.profinance.ru/chart/usdrub/) и добывает с него нужную инфу о курсах

Он реализует интерфейс [Proxy](https://github.com/andybeardness/Learning-OOP/blob/main/14-Proxy-ExchangeRatesGUI/src/ExchangeRate/Proxy.java), который задаёт нужные для этого методы

Также есть класс-Заместитель [ProxyConnecter](https://github.com/andybeardness/Learning-OOP/blob/main/14-Proxy-ExchangeRatesGUI/src/ExchangeRate/ProxyConnecter.java), который управляет доступом к классу-Парсеру и позволяет запрашивать инфу не чаще, чем раз в 5 секунд

Заместитель возвращает объект [Rate](https://github.com/andybeardness/Learning-OOP/blob/main/14-Proxy-ExchangeRatesGUI/src/ExchangeRate/Rate.java), который содержит в себе курсы доллара и евро, а также статус

Класс [GUI](https://github.com/andybeardness/Learning-OOP/blob/main/14-Proxy-ExchangeRatesGUI/src/GUI/GUI.java) отрисовывает интерфейс

Всё это чудо в себе аккумулирет [App](https://github.com/andybeardness/Learning-OOP/blob/main/14-Proxy-ExchangeRatesGUI/src/App/App.java), который управляет взаимодействиями объектов

----

### Плюсы и минусы реализации : 

#### ✔️ Плюсы :

- ✔️ Отдельно реализованы логики : парсинга и ожидания
- ✔️ Успешная аггрегация в едином классе App

#### ❌ Минусы :

- ❌ Возможно, имеет смысл выделить отдельный метод у класса App для запуска GUI. А не запускать его в конструкторе
