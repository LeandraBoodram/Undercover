import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadingScreen {

    private BufferedImage image;

    private Rectangle startBox;

    private boolean highlight;

    private boolean isShowing;

    public LoadingScreen(boolean show) {
        this.startBox = new Rectangle(-100, -100);
        this.highlight = false;
        this.image = readImage();
        this.isShowing = show;
    }

    public BufferedImage readImage() {
        try {
            image = ImageIO.read(new File("src/loading.png"));
        }
        catch (IOException e) {
            System.out.println(e);
            return null;
        }
        return image;
    }

    public void stopShowing(LoadingScreen x){
        isShowing = false;
        image = null;
    }

    public void startShowing(LoadingScreen x){
        isShowing = true;
        image = readImage();
    }

    public boolean checkShowing(){
        return isShowing;
    }
}
