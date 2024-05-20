import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {

    private BufferedImage image;
    private String name;
    private int coins;

    private int health;

    private boolean move;

    public Player(String n){
        name = n;
        health = 10;
        move = false;
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

    private boolean canMove(){
        return move;
    }

    private void startMove(){
        move = true;
        //when movement is implemented create a condition where the player can onl move when this is called as the opening wont allow them to move
    }

    private void stopMove(){
        move = false;
    }

    public void addCoin(){
        coins = coins + 1;
    }

    public int getHealth() {
        return health;
    }
}

