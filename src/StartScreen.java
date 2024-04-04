import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartScreen {

    private BufferedImage image;

    private Rectangle startBox;

    private boolean highlight;

    public StartScreen(boolean show) {
        this.startBox = new Rectangle(-100, -100);
        this.highlight = false;
        this.image = readImage();
    }

    public BufferedImage readImage() {
        try {
            image = ImageIO.read(new File("src/homeScreen.png"));
        }
        catch (IOException e) {
            System.out.println(e);
            return null;
        }
        return image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setStartBoxLocation(int x, int y){
        startBox.setLocation(x, y);
    }

}
