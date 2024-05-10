import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {

    private BufferedImage image;
    private String name;
    private int coins;

    private int health;

    public Player(String n){
        name = n;
        this.health = 10;
    }

    public BufferedImage readImage() {
        try {
            image = ImageIO.read(new File("src/baseP1right"));
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

    public int getHealth() {
        return health;
    }
}

