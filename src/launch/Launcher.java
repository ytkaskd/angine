package launch;

import game.SnakeGame;

//Game launch here
public class Launcher implements Starter{
    public static void main(String[] args) throws InterruptedException {
        SnakeGame snakeGame = new SnakeGame();
        snakeGame.start();
        snakeGame.update();
    }
}
