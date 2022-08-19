package core.scene;

//Scenes use this class for keeping filling
public class Canvas {
    protected char[][] canvas;

    //the symbol who using for fill scene
    protected char filling;

    protected int xLen;
    protected int yLen;

    //convert canvas to string format(for drawing in window)
    protected String getCanvas(){
        StringBuilder cloth = new StringBuilder();
        for(int y = 0; y < yLen; y++){
            for (int x = 0; x < xLen; x++){
                cloth.append(canvas[y][x]);
            }
            cloth.append('\n');
        }
        return cloth.toString();
    }

    //fill canvas someone symbol
    public void fill(char s){
        filling = s;
        for(int y = 0; y < yLen; y++){
            for(int x = 0; x < xLen; x++) canvas[y][x] = s;
        }
    }
}
