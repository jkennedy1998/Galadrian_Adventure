package cartography;
public class Wall {
    public int xPosition, yPosition, elevation;
    String wallType = "";

    public Wall( int xPosition, int yPosition, int elevation, String wallType){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.elevation = elevation;
        this.wallType = wallType;
    }

}
