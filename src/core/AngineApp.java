package core;

import core.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

//Angine using Java Swing library for drawing graphics
public class AngineApp {
    private final JFrame jframe;

    private final JTextArea jTextArea;

    public AngineApp(int width, int height ){
        jframe = new JFrame();
        jTextArea = new JTextArea();

        jframe.setSize(width, height);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBackground(Color.BLACK);
        jframe.setResizable(false);
        jframe.setVisible(true);

        jTextArea.setSize(width, height);
        jTextArea.setEditable(false);
        try {
            jTextArea.setFont(Font.createFont(Font.TRUETYPE_FONT,
                    new File("jetBrainsMono/JetBrainsMono-Regular.ttf")).deriveFont(Font.BOLD, 10));
            jframe.add(jTextArea);
        } catch (IOException | FontFormatException e){
            throw new RuntimeException("Can't load font:" + e.getMessage());
        }
    }
    public void close(){
        jframe.dispose();
    }

    public void setWindowTitle(String title){
        jframe.setTitle(title);
    }

    public void drawScene(Scene scene){
        jTextArea.setRows(scene.getRows());
        jTextArea.setColumns(scene.getColumns());
        jTextArea.setText(scene.getScene());
    }

    public void addListenerToMainWindow(KeyListener jc){
        jframe.addKeyListener(jc);
    }
}
