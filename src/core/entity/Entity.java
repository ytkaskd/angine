package core.entity;

import core.math.SymbolVector;

//You should extend this class for create new entities
public class Entity {

    protected SymbolVector symbolVector = new SymbolVector();

    protected char body;

    public int getCorX() {
        return symbolVector.x;
    }

    public int getCorY() {
        return symbolVector.y;
    }

    public char getBody() {
        return body;
    }

    public void setBody(char body) {
        this.body = body;
    }

    public void setCor(int x, int y){
        symbolVector.setCor(x,y);
    }

    /*public boolean corEquals(SymbolVector sv){
        if(this.symbolVector.equals(sv)){
            return true;
        }
        else{
            return false;
        }
    }*/
}
