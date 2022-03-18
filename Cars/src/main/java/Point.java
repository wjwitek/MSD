import java.util.concurrent.ThreadLocalRandom;

public class Point {
    int type = 0; // -1 for car and 0 for empty space
    Point next;
    Boolean moved;
    int speed = 0;

    public void move() {
        if (type == -1 && !moved){
            accelerate();
            slow();
            randomize();

            findPoint().type = -1;
            findPoint().speed = speed;
            if (speed != 0){
                type = 0;
                speed = 0;
            }
        }
    }

    public void clicked() {
        type = -1;
    }

    public void clear() {
        type = 0;
        speed = 0;
    }

    private void accelerate(){
        if (speed < 5){
            speed ++;
        }
    }

    private void slow(){
        Point curr = next;
        for (int i=0; i<speed; i++){
            if (curr.type == -1){
                speed = i;
                break;
            }
            curr = curr.next;
        }
    }

    private void randomize(){
        int randomNum = ThreadLocalRandom.current().nextInt(1, 30 + 1);
        if (randomNum < 11 && type == -1 && speed > 0){
            speed --;
        }
    }

    private Point findPoint(){
        Point curr = this;
        for (int i=0; i<speed; i++){
            curr.moved = true;
            curr = curr.next;
        }
        curr.moved = true;
        return curr;
    }
}

