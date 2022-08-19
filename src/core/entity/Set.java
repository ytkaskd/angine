package core.entity;

import core.math.SymbolVector;

public class Set {

    protected SymbolVector symbolVector = new SymbolVector();

    protected Entity[] folk = new Entity[9];

    public int getCorX() {
        return symbolVector.x;
    }

    public int getCorY() {
        return symbolVector.y;
    }

    public void setCor(int x, int y){
        symbolVector.setCor(x,y);
    }

    public void fillFolk(char s){
        for(Entity i : folk){
            i.setBody(s);
        }
    }


}
