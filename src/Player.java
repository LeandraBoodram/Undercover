import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {

    private BufferedImage image;
    private String name;
    private int coins;

    private int speed = 10;

    private int health;

    private boolean move;

    private int currentX;

    private int currentY;

    public Player(String n, int x, int y, String imageName){
        name = n;
        health = 10;
        this.image = readImage(imageName);
        move = false;
        this.currentX = x;
        this.currentY = y;
    }

    public BufferedImage readImage(String iN) {
        try {
            image = ImageIO.read(new File(iN));
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

    public void setLocation(int x, int y) {
        currentX = x;
        currentY = y;

    }

    public void moveUp(){
        currentY -= speed;
    }

    public void moveDown(){
        currentY += speed;
    }

    public void moveLeft(){
        currentX -= speed;
    }

    public void moveRight(){
        currentX += speed;
    }

}

