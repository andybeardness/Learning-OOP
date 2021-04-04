# Паттерн : Шаблонный метод

Реализует пайплайн процесса, где некоторые методы заменяются пользователем

----

## Проект : Вычисление определённого интеграла (IntegralSolver)

Решает определённый интеграл от функции простым левосторонним методом

В начале мы задаём :
- a : Левая граница интервала
- b : Правая граница интервала
- n : Количество разбиений. Чем больше, тем точнее

Потом можно решать интеграл

Пример работы левостороннего метода : 

![IntegralSolver](https://github.com/andybeardness/Learning-OOP/blob/main/imgs/IntegralSolver.jpg)

----

### О реализации :

Реализую базовый абстрактный класс для решения интеграла

Затем субклассирую его в конкретных реализациях

Быстрый обзор пакетов и файлов :

- [IntegralSolver](https://github.com/andybeardness/Learning-OOP/tree/main/10-TemplateMethod-IntegralSolver/src/IntegralSolver) : Пакет с базовым абстрактным решателем
	- [Function](https://github.com/andybeardness/Learning-OOP/blob/main/10-TemplateMethod-IntegralSolver/src/IntegralSolver/Function.java) : Абстрактный класс для функции. Нужно для унификации функций
	- [IntegralSolver](https://github.com/andybeardness/Learning-OOP/blob/main/10-TemplateMethod-IntegralSolver/src/IntegralSolver/IntegralSolver.java) : Базовый абстрактный решатель
- [IntegralSolversCollection](https://github.com/andybeardness/Learning-OOP/tree/main/10-TemplateMethod-IntegralSolver/src/IntegralSolversCollection) : Пакет с конкретными реализациями
	- [IS10X](https://github.com/andybeardness/Learning-OOP/blob/main/10-TemplateMethod-IntegralSolver/src/IntegralSolversCollection/IS10X.java) : Конкретный решатель с функцией f(x) = 10x
	- [ISX2](https://github.com/andybeardness/Learning-OOP/blob/main/10-TemplateMethod-IntegralSolver/src/IntegralSolversCollection/ISX2.java) : Конкретный решатель с функцией f(x) = x²

По поводу точности :

```java
	/**
	 * Вывод программы :
	 *
	 * FUNC : 10 * x :: a == 0.0, b == 1.0, n == 1000.0 >>> 4.995000000000004
	 * FUNC : x ** 2 :: a == 0.0, b == 1.0, n == 1000.0 >>> 0.33283350000000095
	 *
	 * Верные ответы : 5 и 1/3
	 *
	 * Достаточно близко для левостороннего метода
	 *
	 */
```

----

### Плюсы и минусы реализации : 

#### ✔️ Плюсы :

- ✔️ Хороший паттерн, помогает объединить разные интерфейсы под одну гребёнку
- ✔️ Понравилось отделять одну логику от другой

#### ❌ Минусы :

- ❌ Как говорил выше, не удалось качественно показать работу паттерна. А делать примитивные примеры с уточками не хотелось
- ❌ Нет такой красоты, как в книге с их "пультом". Можно обойтись и без этого паттерна в данном концепте
