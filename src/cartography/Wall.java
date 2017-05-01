package cartography;
public class Wall {
    public int xPosition, yPosition, elevation;
    public boolean nonWall = false;
    String wallType;

    public Wall( int xPosition, int yPosition, int elevation, String wallType){
        this.xPosition = xPosition*30;
        this.yPosition = yPosition*30;
        this.elevation = elevation;
        this.wallType = wallType;
    }

}
