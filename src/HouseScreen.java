import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HouseScreen {

    private BufferedImage image;

    private boolean isShowing;
    public HouseScreen (boolean show) {
        this.isShowing = show;
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

    public void stopShowing(HouseScreen x){
        isShowing = false;
        x.image = null;
    }

    public void startShowing(HouseScreen x){
        isShowing = true;
        x.image = readImage();
    }

    public boolean checkShowing(){
        return isShowing;
    }
    public BufferedImage getImage() {
        return image;
    }

}
