# Паттерн : Адаптер

Позволяет адаптировать один интерфейс к другому

----

## Проект : Определение простого числа (PlainNumberSolver)

Реализует способ определения : простое число или нет

Картинка с простыми числами :

![PlainNumber.jpg](https://github.com/andybeardness/Learning-OOP/blob/main/imgs/PlainNumber.jpg)

----

### О реализации :

Изначально я сделал [базовый решатель](https://github.com/andybeardness/Learning-OOP/blob/main/08-Adapter-PlainNumberSolver/src/PlainNumberBase/PlainNumberBaseSolver.java), который работает неэффективно

Суть его в том, что он проходится циклом от 2 до (число - 1), проверяя при этом делимость числа

В этом нет смысла, так как Х не станет нацело делиться на на У, который больше чем Х / 2

Поэтому я реализовал [улучшенный решатель](https://github.com/andybeardness/Learning-OOP/blob/main/08-Adapter-PlainNumberSolver/src/PlainNumberNew/PlainNumberNewSolver.java), который исправляет эту проблему c помощью [адаптера](https://github.com/andybeardness/Learning-OOP/blob/main/08-Adapter-PlainNumberSolver/src/PlainNumberNew/PNNAdapter.java)

Вот пример работы программы :

```java
	/**
	 * Базовая реализация проверки простоты числа
	 *
	 * Вывод программы :
	 *
	 * Number 10 is plain? :: false
	 * Number 15 is plain? :: false
	 * Number 17 is plain? :: true
	 * Number 21 is plain? :: false
	 * Number 97 is plain? :: true
	 */
    int[] numbers = {10, 15, 17, 21, 97};
    PNBase pnBase = new PlainNumberBaseSolver(); // Базовый класс
    App app = new App(pnBase);
    for (int number : numbers) {
      System.out.println("Number " + number + " is plain? :: " + app.isPlainNumber(number));
    }
```

```java
	/**
	 * Упрощённая реализация проверки простоты числа
	 * Добавлена с помощью Адаптера
	 *
	 * Вывод программы :
	 *
	 * Number 10 is plain? :: false
	 * Number 15 is plain? :: false
	 * Number 17 is plain? :: true
	 * Number 21 is plain? :: false
	 * Number 97 is plain? :: true
	 */
    int[] numbers = {10, 15, 17, 21, 97};
    PNBase pnBase = new PNNAdapter(); // Адаптер к новому классу
    App app = new App(pnBase);
    for (int number : numbers) {
      System.out.println("Number " + number + " is plain? :: " + app.isPlainNumber(number));
    }
```

----

### Плюсы и минусы реализации : 

#### ✔️ Плюсы :

- ✔️ Можно достаточно неплохо подстраивать новые решатели под старый интерфейс, чтобы не переписывать его и не ломать продакшн

#### ❌ Минусы :

- ❌ Можно представить ситуацию, когда этот паттерн бы очень пригодился, но не получится его применить из-за негибкости старого интерфейса
