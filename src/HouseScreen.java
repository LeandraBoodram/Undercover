import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HouseScreen{

    private BufferedImage image;

    private int recentScore;

    private int oldTime;
    private int newTime;

    private int newScore;
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
        oldTime = (int) System.currentTimeMillis();
        newScore = oldTime - newTime;
        newScore = (int) (newScore / 1000F);
        System.out.println(newScore);
    }

    public void startShowing(HouseScreen x){
        isShowing = true;
        x.image = readImage();
        newTime = (int) System.currentTimeMillis();
    }

    public boolean checkShowing(){
        return isShowing;
    }
    public BufferedImage getImage() {
        return image;
    }

}
