import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadingScreen {

    private BufferedImage image;

    private int oldTime;
    private int newTime;

    private int fullTime;
    private boolean highlight;

    private boolean isShowing;

    public LoadingScreen(boolean show) {
        this.highlight = false;
        this.image = readImage();
        this.isShowing = show;
    }

    public BufferedImage readImage() {
        try {
            image = ImageIO.read(new File("src/loading.png"));
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
        return image;
    }

    public void stopShowing(LoadingScreen x) {
        isShowing = false;
        image = null;
    }


    public void startShowing(LoadingScreen x) {
        isShowing = true;
        image = readImage();
        newTime = (int) System.currentTimeMillis();
    }


    public int getFullTime(){
        oldTime = (int) System.currentTimeMillis();
        fullTime = oldTime - newTime;
        fullTime = (int) (fullTime / 1000F);
     //   System.out.println(fullTime);
        return fullTime;
    }

    public BufferedImage getImage() {
        return image;
    }


    public boolean checkShowing() {
        return isShowing;
    }

  //  public  progressLoad(){
    //    int
  //  }
}
