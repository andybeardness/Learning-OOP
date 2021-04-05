# Паттерн : Состояние

Если у объекта меняется состояние, это можно регулировать с помощью паттерна Состояние

Реализуем на каждое состояние свой класс, которые будут наследоваться от общего абстрактного

В каждом из этих классов прописываем реакцию на смену состояния

----

## Проект : Анализ марковских процессов состояний в поликлинике (MarkovHospital)

Представим, что мы глава поликлиники, и нам нужно понять "Какая точка в нашей больнице работает неэффективно?"

Это можно сделать, если проследить за посетителем и построить модель его переходов с помощью "Марковских цепей"

Достаточно учитывать локацию, в которой пациент был, и в которую он перешёл в дальнешем

В итоге мы получим матрицу состояний и переходов. Которую после преобразований можно привести к матрице вероятностей

Если матрицу возвести в степень N, то в каждой строке матрицы мы увидим процент времени посетителя

И если в поликлинике окажется, что человек попадает в регистратуру чаще, чем к хирургу, то нужно что-то с этим делать

В этом проекте я реализовал четыре локации: 

- Улица (вне поликлиники)
- Регистрация 
- Терапевт
- Хирург

Изначально пациент находится вне больницы. Тыкая на кнопки можно менять его локацию и следить за результатом анализа "Марковских цепей"

Работает так :

![ListsEnseblesML.gif](https://github.com/andybeardness/Learning-OOP/blob/main/imgs/MarkovHospital.gif)

----

### О реализации :

Главный класс тут : [User](https://github.com/andybeardness/Learning-OOP/blob/main/13-State-MarkovHospital/src/User/User.java), всё вертится вокруг него

У него есть четыре состояния :

- [StreetUserState](https://github.com/andybeardness/Learning-OOP/blob/main/13-State-MarkovHospital/src/User/StreetUserState.java) : Улица
- [RegistrationUserState](https://github.com/andybeardness/Learning-OOP/blob/main/13-State-MarkovHospital/src/User/RegistrationUserState.java) : Регистрация
- [DoctorUserState](https://github.com/andybeardness/Learning-OOP/blob/main/13-State-MarkovHospital/src/User/DoctorUserState.java) : Терапевт
- [SurgeonUserState](https://github.com/andybeardness/Learning-OOP/blob/main/13-State-MarkovHospital/src/User/SurgeonUserState.java) : Хирург

Все эти состояния наследуются от общего класса [UserState](https://github.com/andybeardness/Learning-OOP/blob/main/13-State-MarkovHospital/src/User/UserState.java)

За работу с данными отвечает класс [SaverData](https://github.com/andybeardness/Learning-OOP/blob/main/13-State-MarkovHospital/src/MatrixMath/SaverData.java), который работает с матрицами переходов и вероятностей [Vec2D](https://github.com/andybeardness/Learning-OOP/blob/main/13-State-MarkovHospital/src/MatrixMath/Vec2D.java)

А класс [GUI](https://github.com/andybeardness/Learning-OOP/blob/main/13-State-MarkovHospital/src/GUI/GUI.java) отвечает за GUI, что логично

----

### Плюсы и минусы реализации : 

#### ✔️ Плюсы :

- ✔️ В этой реализации паттер Состояние зашёл как никто другой. Больше всего мороки было с перемножением матрицы, из-за моей минорной и глупой ошибки. Понравилось, что к классам, отвечающим за состояния, я не обращался совсем. Просто сделал, а они сразу работали как надо. Круто

#### ❌ Минусы :

- ❌ В этой реализации много смежных зависимостей. Хоть я и хотел, чтобы User был над-классом над всем, который отвечает и за GUI, и за данные. Но в итоге потратил много времени на фикс и для простого учебного проекта решил оставить как есть
