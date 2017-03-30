package Cartetecton;
public class NonWalls extends Wall {
    byte facing = 0;
    boolean colidable = false, interactOnCollision = true, state = true;
    String description = "";
    Board board;
    NonWalls link;
public NonWalls(int xPosition, int yPosition, int elevation, String wallType) {
    super(xPosition, yPosition, elevation, wallType);
    nonWall = true;
}
}
