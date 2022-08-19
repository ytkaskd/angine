package core.entity;

//example
public class Dot extends Entity{

    public Dot(char s){
        body = s;
        symbolVector.x = 1;
        symbolVector.y = 1;

    }
    public Dot(char s, int x, int y){
        body = s;
        symbolVector.x = x;
        symbolVector.y = y;

    }

    public void moveX(int steps){
        symbolVector.x += steps;
    }
    public void moveY(int steps){
        symbolVector.y += steps;
    }
    public void moveTo(int x, int y){

            if(x == getCorX() && y > getCorY()){
                symbolVector.y ++;
            }
            if(x == getCorX() && y < getCorY()){
                symbolVector.y --;
            }
            if(x > getCorX() && y == getCorY()){
                symbolVector.x ++;
            }
            if(x < getCorX() && y == getCorY()){
                symbolVector.x --;
            }
            if(x < getCorX() && y < getCorY()){
                symbolVector.x --;
                symbolVector.y --;
            }
            if(x < getCorX() && y > getCorY()){
                symbolVector.x --;
                symbolVector.y ++;
            }
            if(x > getCorX() && y > getCorY()){
                symbolVector.x ++;
                symbolVector.y ++ ;
            }
            if(x > getCorX() && y < getCorY()){
                symbolVector.x ++;
                symbolVector.y --;

        }
    }
}
