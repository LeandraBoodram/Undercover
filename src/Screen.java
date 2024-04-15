import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Screen {

    private BufferedImage image;

    private Rectangle startBox;

    private boolean highlight;

    private boolean isShowing;

    private String imageName;

    public Screen(boolean show, String im) {
        this.startBox = new Rectangle(-100, -100);
        this.highlight = false;
        this.image = readImage();
        this.isShowing = show;
        this.imageName = im;
    }

    public BufferedImage readImage() {
        try {
            image = ImageIO.read(new File(imageName));
        }
        catch (IOException e) {
            System.out.println(e);
            return null;
        }
        return image;
    }

    public void changeImage(String newImage){
        imageName = newImage;
    }

    public void dontShow(){
        isShowing = false;
    }


    public BufferedImage getImage() {
        return image;
    }

    public void setStartBoxLocation(int x, int y){
        startBox.setLocation(x, y);
    }

}
