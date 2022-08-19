package game;

import core.AngineApp;
import core.Game;
import core.scene.Scene;

public class SnakeGame implements Game {

    private AngineApp angineApp;

    private static final int XLEN = 146;
    private static final int YLEN = 51;


    private final Scene mainScene = new Scene(XLEN, YLEN);

    @Override
    public void start() {
        angineApp = new AngineApp(1000, 700);
        mainScene.fill('#');
    }

    @Override
    public void update() throws InterruptedException {
        while(true){
            angineApp.drawScene(mainScene);
            Thread.sleep(1000);
        }
    }
}