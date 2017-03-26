package cartography;

public class Button {
    public int xPosition, yPosition, xDimension, yDimension;
    public String buttonTitle;

    public Button(int xPosition, int yPosition, int xDimension, int yDimension, String buttonTitle){
        this.xDimension = xDimension;
        this.yDimension = yDimension;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.buttonTitle = buttonTitle;
    }

}
