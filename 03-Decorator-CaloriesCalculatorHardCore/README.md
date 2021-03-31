# Паттерн : Декоратор

Паттерн декорирует объект, изменяя его реализацию

Декорировать нужно до тех пор, пока объект не стал подходящим

----

## Проект : Калькулятор калорий с GUI (CaloriesCalculator)

То же самое, что в приложении [Калькулятор калорий с GUI](https://github.com/andybeardness/Learning-OOP/tree/main/03-Decorator-CaloriesCalculator), но с изменениями :

- Расширил базовое приложение, добавил реализацию для "хардкорщиков". Она для тех, кто занимается в зале очень часто и очень упорно
- Дополнительный декаратор, который даёт женщинам + 1000 ккал, а мужчинам + 1500 ккал

----

### О реализации :

Реализация не поменялась, просто дополнил функционал

Посмотреть можно в приложении [Калькулятор калорий с GUI](https://github.com/andybeardness/Learning-OOP/tree/main/03-Decorator-CaloriesCalculator)

----

### Плюсы и минусы реализации : 

#### ✔️ Плюсы :

- ✔️ Позволяет легко добавлять новые факторы, влияющие на норму калорий
- ✔️ Также можно легко корректировать имеющиеся факторы
- ✔️ (новое) Добавил в GUI функционал, позволяющий менять заголовок окна отдельно
- ✔️ (новое) Исправил опечатку в слове "РасСчитать"


#### ❌ Минусы :

- ❌ Не уверен, что есть необходимость в классе [Base](https://github.com/andybeardness/Learning-OOP/blob/main/03-Decorator-CaloriesCalculator/src/AppCalories/CaloriesCalculator/Base/CaloriesBase.java). Возможно, следует обойтись только классом [Gender](https://github.com/andybeardness/Learning-OOP/blob/main/03-Decorator-CaloriesCalculator/src/AppCalories/CaloriesCalculator/Genders/CaloriesGender.java)
	