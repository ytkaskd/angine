package core;

public interface Game {

    void start();

    default void update() throws InterruptedException{
        while (true){
            Thread.sleep(5000);
        }
    }
}
