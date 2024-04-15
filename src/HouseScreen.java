import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HouseScreen {

    private BufferedImage image;


    public HouseScreen (boolean show) {
        this.image = readImage();
    }

    public BufferedImage readImage() {
        try {
            image = ImageIO.read(new File("src/house.png"));
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

}
