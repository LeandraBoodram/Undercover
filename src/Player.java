import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {

    private BufferedImage image;
    private String name;
    private int coins;

    private String direction;

    private boolean attack;

    private int speed = 2;

    private int health;

    private boolean move;

    private int currentX;

    private int currentY;

    public Player(String n, int x, int y, String imageName){
        name = n;
        health = 10;
        this.image = readImage(imageName); //start saviing all player direction images as different image variables

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
        if (currentY > 0 ) {
            currentY -= speed;
            direction = "up";
        }
    }

    public void moveDown(){
        if (currentY < 350) {
            currentY += speed;
            direction = "down";
        }
    }

    public void moveLeft(){
        if (currentX > 0) {
            readImage("src/baseP1left.png");
            currentX -= speed;
            direction = "left";
        }
    }

    public void moveRight(){
        if (currentX < 740) { //specific number because only the left side is accounted for the sprite position and each sprite has a different amount of pixels
           readImage("src/baseP1Right.png");
            currentX += speed;
            direction = "right";
        }
    }

    public int getCurrentX(){
        return currentX;
    }
    public int getCurrentY(){
        return currentY;
    }

    public void attackOn(){
        attack = true;
        System.out.println("attakc");
    }

    public void attackOff(){
        attack = false;
        System.out.println("no attack");
    }

    public boolean getAttack(){
        return attack;
    }

}

