package core.math;

// 2D Vector for symbols
// Entities should use this class
public class SymbolVector {

    public int x, y;

    public SymbolVector(int x, int y){
        this.x = x;
        this.y = y;
    }
    public SymbolVector(){
        x = 1;
        y = 1;
    }
    //Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setCor(int x, int y){
        this.x = x;
        this.y = y;
    }

    public SymbolVector getPosition(){
        return new SymbolVector(this.x, this.y);
    }
}
