package cartography;

/**
 * Created by citim on 4/14/2017.
 */
public class Floor {
    int xPosition, yPosition, elevation;
    String floorType;

    public Floor(int xPosition, int yPosition, int elevation, String floorType){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.elevation = elevation;
        this.floorType = floorType;
    }
}
