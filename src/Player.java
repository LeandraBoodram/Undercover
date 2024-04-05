import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {

    private BufferedImage image;
    private String name;
    private int coins;

    public Player(String n, String iN){
        name = n;
        this.image = readImage(iN);
    }

    public BufferedImage readImage(String imageName) {
        try {
            image = ImageIO.read(new File(imageName));
        }
        catch (IOException e) {
            System.out.println(e);
            return null;
        }
        return image;
    }

    public BufferedImage getImage(){
        return image;
    }

    public void addCoin(){
        coins = coins + 1;
    }
    }
