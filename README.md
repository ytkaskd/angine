# angine
Simple Ascii Game Angine

RU:
Добро пожаловать в Angine(Ascii Engine)

1) Начало работы
2) Запуск
3) Сцены
4) Отрисовка сцен
5) Сущности
6)	Отрисовка сущностей на сцене
7) Захват клавиш с клавиатуры 
8) Создание простой игры

Начало работы
Необходимая версия JDK: 11+
IDE: Android Studio(Не проверена)/Intelij IDEA

Для начала необходимо установить JDK, сам Angine и IDE.

После установки перемещаем в свой проект папку angine.

В подпапке angine/launch находится стартер вашей игры, именно с него начинается запуск.

В подпапке  angine/game будет находится реализация самой игры, будь этим игровая логика или собственные сущности.

В подпапке angine/core находится сам движок. В дальнейшем все пакеты будут импортироваться оттуда.

Запуск
В папке angine/game создаем класс, который реализует интерфейс Game(core.Game). Именно он будет главным классом вашей игры.

В папке angine/launch открываем файл Launcher.java и изменяем любое упоминание DefaultGame на название созданного раннее класса(angine/game). 

Если используется Android studio/Intelij IDEA, то создаем новую конфигурацию: Edit configurations -> + -> Application.

В качестве главного класса задаем Launcher.main

В главном классе игры реализуем все методы интерфейса.

Далее создаем объект класса MainWindow(core.MainWindow) с любым именем(далее - mainWindow). В методе void start() присвоим ссылку используя конструктор класса MainWindow: mainWindow = new MainWindow(int width, int height); 

В качестве аргументов передаем высоту и ширину (Примечание: Высоту и ширину желательно выводить в константы)

Для того, чтобы изменить заголовок окна, можно использовать метод void setWindowTitle(String title);

Чтобы закрыть окно, следует вызвать метод void close();

Реализацию метода void update(); можно скопировать из реализуемого интерфейса 

void update() throws InterruptedException{
        while (true){
	   //Логика игры (н-р: отрисовка сцены)
            Thread.sleep(5000);
        }
    }

Запускаем и смотрим результат.

Сцены
В прошлом пункте результат показал пустое окно.

Чтобы это исправить, можно использовать Сцены.

Чтобы создать сцену, достаточно создать объект класса Scene(core.scene.Scene) с любым именем:

private Scene scene = new Scene(char s, int xLen, int yLen);

Указывать параметр s необязательно, достаточно просто указать длину координатной сетки.

 
Как изображено на рисунке сверху - координатная сетка отрженна относительно оси x, то есть чем выше значение y, тем ниже положение точки.

В Сцене координатная сетка разделена символами, значит если мы указали размер 10 на 10, то сцена будет иметь 10 символов по x и 10 символов по y. В общей сумме 100 символов.

На рисунке точка A имеет координаты (1;1), если бы сетка не была отражена, то координаты этой точки были (1; -1)

Такая реализация сетки обусловлена самой реализацией сцены. Сцена - двумерный массив символов, а как мы знаем, индексация массива начинается с нуля, поэтому нет ячейки с отрицательным индексом.

Отрисовка сцен
Чтобы сцена не была пустой, её следует заполнить. Это можно сделать используя метод void fill(char s);
Этот метод заполняют сцену указанным символом.

Стоит заметить, что разные символы имеют разный размер, поэтому для корректной отрисовки сцены в окне следует тщательно подбирать длину осей. 

Для того, чтобы отобразить сцену в окне, нужно воспользоваться методом класса MainWindow - void drawScene(Scene scene);

void update() throws InterruptedException{
        while (true){
            mainWindow_name.drawScene(scene_name);
            Thread.sleep(5000);
        }
    }
Чтобы не отображать элементы предыдущего кадра, например: каждый кадр символ меняет свои координаты, чтобы он не отображался на тех координатах, которых он был, надо использовать метод void clear();
void update() throws InterruptedException{
        while (true){
	 		scene_name.clear();
	  //Логика игры
            mainWindow_name.drawScene(scene_name);
            Thread.sleep(5000);
        }
    }

По стандарту Angine, следует сначала очистить сцену, обработать логику и затем отобразить сцену в окне. Это обеспечивает надежную работы как движка, так и самой игры.

Сущности
Сущности представляют собой объект, который имеет тело – символ, координаты – x, y и свойства, которые вы можете задать вручную.

Все сущности наследуют класс Entity(core.entity.Entity) 

Пример сущности предопределён классом Dot(core.entity.Dot). Dot реализует базовые механики, а именно отрисовка и передвижение.

Для корректной работы с координатной сеткой сущности используют экземпляр класса SymbolVector(core.math.SymbolVector). Он сочетает в себе геттеры и сеттеры x и y координат.


Отрисовка сущностей
Отрисовать сущность можно только на сцене, воспользовавшись одним из методов Сцены – void draw(Entity entity);

В качестве аргумента методу void draw(Entity entity); можно передать любой объект, класс которого наследует класс Entity(core.entity.Entity) 

Это можно сделать на примере кода ниже:

package example

import core.scene.Scene;
import core.entity.Dot;

import core.MainWindow;
import core.Game;

public class Example extends Game {
	
	private MainWindow mainWindow;

	private Scene scene = new Scene(‘s’, 10, 10);

	private Dot dot = new Dot(‘@’, 1, 1);
	
	@Override
	public void start(){
		mainWindow = new MainWindow(300, 300);
		
	}

	@Override 
	public void update()throws InterruptedException {
		while (true) {
			scene.clear();
			scene.draw(dot);
			mainWindow.drawScene(scene);
			Thread.sleep(1000);
		}
		mainWindow.close();
	}

}


EN:
Welcome to Angine(Ascii Engine)

1) Getting Started
2) Launch
3) Scenes
4) Scene rendering
5) Essences
6) Drawing entities on the stage
7) Capturing keys from the keyboard
8) Creating a simple game

Beginning of work
Required JDK version: 11+
IDE: Android Studio(Not tested)/Intelij IDEA

First you need to install the JDK, Angine itself and the IDE.

After installation, we move the angine folder to our project.

The angine/launch subfolder contains the starter of your game, it is from it that the launch begins.

The angine/game subfolder will contain the implementation of the game itself, be it game logic or custom entities.

The angine/core subfolder contains the engine itself. In the future, all packages will be imported from there.

launch
In the angine/game folder, create a class that implements the Game(core.Game) interface. It will be the main class of your game.

In the angine/launch folder, open the Launcher.java file and change any mention of DefaultGame to the name of the class created earlier (angine/game).

If Android studio/Intelij IDEA is used, then create a new configuration: Edit configurations -> + -> Application.

We set Launcher.main as the main class

In the main class of the game, we implement all the methods of the interface.

Next, create an object of the MainWindow(core.MainWindow) class with any name (hereinafter referred to as mainWindow). In the void start() method, assign a reference using the MainWindow class constructor: mainWindow = new MainWindow(int width, int height);

We pass height and width as arguments (Note: It is desirable to display height and width as constants)

To change the window title, you can use the void setWindowTitle(String title);

To close a window, call the void close() method;

The implementation of the void update() method; can be copied from an implemented interface

void update() throws InterruptedException{
        while (true){
//Game logic (ex: scene rendering)
            Thread.sleep(5000);
        }
    }

Let's run it and see the result.

Scenes
In the last paragraph, the result showed an empty window.

To fix this, you can use Scenes.

To create a scene, it is enough to create an object of class Scene(core.scene.Scene) with any name:

private Scene scene = new Scene(char s, int xLen, int yLen);

Specifying the s parameter is optional, just specifying the length of the coordinate grid is sufficient.

 
As shown in the figure above - the coordinate grid is reflected about the x-axis, that is, the higher the y value, the lower the position of the point.

In the Scene, the coordinate grid is divided by symbols, so if we specified a size of 10 by 10, then the scene will have 10 characters in x and 10 characters in y. A total of 100 characters.

In the figure, point A has coordinates (1; 1), if the grid was not reflected, then the coordinates of this point would be (1; -1)

This implementation of the grid is due to the implementation of the scene itself. The scene is a two-dimensional array of characters, and as we know, the array indexing starts from zero, so there is no cell with a negative index.

Scene rendering
In order for the stage not to be empty, it must be filled. This can be done using the void fill(char s); method.
This method fills the scene with the specified symbol.

It is worth noting that different symbols have different sizes, so for the correct rendering of the scene in the window, you should carefully select the length of the axes.

In order to display the scene in a window, you need to use the MainWindow class method - void drawScene(Scene scene);

void update() throws InterruptedException{
        while (true){
            mainWindow_name.drawScene(scene_name);
            Thread.sleep(5000);
        }
    }
In order not to display the elements of the previous frame, for example: each frame the symbol changes its coordinates so that it is not displayed at the coordinates that it was, you must use the void clear () method;
void update() throws InterruptedException{
        while (true){
scene_name.clear();
//Game logic
            mainWindow_name.drawScene(scene_name);
            Thread.sleep(5000);
        }
    }

According to the Angine standard, you should first clear the scene, process the logic, and then display the scene in a window. This ensures reliable operation of both the engine and the game itself.

Essences
Entities are an object that has a body - a symbol, coordinates - x, y and properties that you can set manually.

All entities inherit the class Entity(core.entity.Entity)

An entity example is predefined by the Dot(core.entity.Dot) class. Dot implements the basic mechanics, namely rendering and movement.

To work correctly with the coordinate grid, entities use an instance of the SymbolVector(core.math.SymbolVector) class. It combines getters and setters for x and y coordinates.


Entity rendering
An entity can only be drawn on the stage using one of the Scene methods - void draw(Entity entity);

As an argument to the method void draw(Entity entity); you can pass any object whose class inherits the Entity(core.entity.Entity) class

This can be done using the code example below:

package example

import core.scene.Scene;
import core.entity.Dot;
import core.MainWindow;
import core.Game;

public class Example extends Game {
	
	private MainWindow mainWindow;

	private Scene scene = new Scene(‘s’, 10, 10);

	private Dot dot = new Dot(‘@’, 1, 1);
	
	@Override
	public void start(){
		mainWindow = new MainWindow(300, 300);
		
	}

	@Override 
	public void update()throws InterruptedException {
		while (true) {
			scene.clear();
			scene.draw(dot);
			mainWindow.drawScene(scene);
			Thread.sleep(1000);
		}
		mainWindow.close();
	}

}
