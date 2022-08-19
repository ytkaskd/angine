package core.scene;

import core.entity.Entity;
import core.entity.Set;

//You can display objects, who extends Entity class
public class Scene extends Canvas{
    //constructors
    public Scene(int xLen, int yLen){
        this.canvas = new char[yLen][xLen];

        this.xLen = xLen;
        this.yLen = yLen;
    }
    public Scene(int xLen, int yLen, char s){
        this.canvas = new char[yLen][xLen];

        this.xLen = xLen;
        this.yLen = yLen;
        this.filling = s;

        fill(s);
    }

    //methods
    public void setCell(char s,int x, int y){
        canvas[y][x] = s;
    }
    public char getCell(int x, int y){
        if(x >= 0 && y >= 0) {
            return canvas[y][x];
        }
        else{
            return '0';
        }

    }

    public char[] getNeighbours(int x, int y){
        char[] neighbours = new char[8];

        neighbours[0] = this.getCell(x - 1, y);
        neighbours[1] = this.getCell(x - 1, y - 1);
        neighbours[2] = this.getCell(x , y - 1);
        neighbours[3] = this.getCell(x + 1 , y - 1);
        neighbours[4] = this.getCell(x + 1 , y );
        neighbours[5] = this.getCell(x + 1, y + 1);
        neighbours[6] = this.getCell(x  , y + 1);
        neighbours[7] = this.getCell(x - 1 , y );

        return neighbours;
    }

    public void clear(){
        fill(filling);
    }

    public String getScene(){
        return getCanvas();
    }

    public int getRows(){
        return yLen;
    }
    public int getColumns(){
        return xLen;
    }

    public void draw(Entity entity){
        try {
            canvas[entity.getCorY()][entity.getCorX()] = entity.getBody();
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid x/y cor");
        }
    }
//    public void draw(Set set){
//        try {
//            canvas[set.getCorY()][set.getCorX()] = set.getFolk();
//        } catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("Invalid x/y cor");
//        }
//    }
}
