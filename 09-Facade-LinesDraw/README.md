# Паттерн : Фасад

Позволяет привести интерфейс с кучей методов привести к удобному

----

## Проект : Рисователь линий (LinesDraw)

В зависимости от входного параметра рисует ту или иную фигуру из линий

Список фигур :

| Название | Скриншот | Название | Скриншот |
| :---: | :---: | :---: | :---: |
| Квадрат | ![Квадрат](https://github.com/andybeardness/Learning-OOP/blob/main/imgs/LinesDraw-Square.png) | Коробка | ![Коробка](https://github.com/andybeardness/Learning-OOP/blob/main/imgs/LinesDraw-Box.png) |
| Ромб | ![Ромб](https://github.com/andybeardness/Learning-OOP/blob/main/imgs/LinesDraw-Rhombus.png) | Коробка-Ромб | ![Коробка-Ромб](https://github.com/andybeardness/Learning-OOP/blob/main/imgs/LinesDraw-RBox.png) |
| Треугольник | ![Треугольник](https://github.com/andybeardness/Learning-OOP/blob/main/imgs/LinesDraw-Triangle.png) | Другое, Крест | ![Другое, Крест](https://github.com/andybeardness/Learning-OOP/blob/main/imgs/LinesDraw-Other.png) |

----

### О реализации :

Класс [Drawer](https://github.com/andybeardness/Learning-OOP/blob/main/09-Facade-LinesDraw/src/GUI/Drawer.java) реализует по-отдельности методы рисования каждой линии

Поэтому их нужно объединить в осмыслленые рисунки

Эти и занимается паттер Фасад в классе [FacadeDraw](https://github.com/andybeardness/Learning-OOP/blob/main/09-Facade-LinesDraw/src/GUI/FacadeDraw.java)

Приложение [App](https://github.com/andybeardness/Learning-OOP/blob/main/09-Facade-LinesDraw/src/GUI/App.java) наследуется от JFrame и отрисовывает фигуры с помощью фасада

----

### Плюсы и минусы реализации : 

#### ✔️ Плюсы :

- ✔️ 

#### ❌ Минусы :

- ❌ 
