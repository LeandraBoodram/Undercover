import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Text {

    private BufferedImage image;

    private int x;

    private int y;

    private int clicks;

    private boolean change;

    private int played; // it will be 1 when the final text bubble is played so the opening scene wont constantly be replayd

    private boolean isShowing;

    public Text (boolean show, String imageName) {
        this.isShowing = show;
        this.image = readImage(imageName);
        this.x = 100;
        this.y = 20;
    }

    public BufferedImage readImage(String iN) {
        try {
            image = ImageIO.read(new File(iN));
        }
        catch (IOException e) {
            System.out.println("hello");
            return null;
        }
        return image;
    }

    public int getPlayed(){
        return played;
    }

    public void addPlay(){
        played++;
    }


    public void changeX(int xValue){
        x = xValue;
    }

    public void changeY(int yValue){
        y = yValue;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void changeTextTrue(){
        change = true;
    }

    public void changeTextFalse(){
        change = false;
    }

    public boolean checkChange(){
        return change;
    }

    public BufferedImage getImage() {
       return image;
    }

    public int getClicks(){
        return clicks;
    }

    public void addClicks(){
        clicks++;
    }

}
