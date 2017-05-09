package cartography;

/**
 * Created by citim on 5/2/2017.
 */
public class Equation {
    private double slope;
    private int horizontalShift, verticalShift;
    public String direction;
    private int[] start, end;
    public Equation(int[] start, int[] end){//sent a 2 value int array representing a point
        try {
            slope = (start[1]-end[1])/(start[0]-end[0]);
        } catch (java.lang.ArithmeticException e){
            slope = 999999;
        }
        horizontalShift = start[0];
        verticalShift = start[1];
        if(slope > 0) direction = "up";
        if(slope < 0) direction = "down";
        if(slope == 0){
            if(start[0] < end[0]) direction = "right";
            else direction = "left";
        }
        this.start = start;
        this.end = end;


    }
    public double getX (int y){
        if (slope == 999999) return start[0];
        return (y-verticalShift)/slope+horizontalShift;
    }
    public double getY (int x){
        if (slope == 999999) return start[1];
        return (x-horizontalShift)*slope+verticalShift;
    }
    public int[] getNextMove(int x, int y){
        if (Math.random()>.5)
        if((x/getY(x)) > x/y){ //if you need to move vertically
            if(direction.equals("up"))return new int[] {0,-1};
            else return new int[] {0,1};
        }else{
            if(direction.equals("up"))return new int[] {-1,0};
            else return new int[] {1,0};
        }
        if((getX(y)/x) > x/y){ //if you need to move vertically
            if(direction.equals("up"))return new int[] {0,-1};
            else return new int[] {0,1};
        }else{
            if(direction.equals("up"))return new int[] {-1,0};
            else return new int[] {1,0};
        }
    }
}
