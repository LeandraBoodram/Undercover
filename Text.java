import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Text {

    private BufferedImage image;

    private int played; // it will be 1 when the final text bubble is played so the opening scene wont constantly be replayd

    private boolean isShowing;
    public Text (boolean show) {
        this.isShowing = show;
        this.image = readImage();
    }

    public BufferedImage readImage() {
        try {
            image = ImageIO.read(new File("src/textBanner.png"));
        }
        catch (IOException e) {
            System.out.println(e);
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

    public void textOne(Graphics g){
        g.drawString("Hello!", 160, 357);
    }

    public void textTwo(Graphics g){
        g.drawString("Goodbye", 160, 357);
    }

    public BufferedImage getImage() {
        return image;
    }

   // public void textTwo(Graphics g){
   //     instance.repaint();
  //  }
}
