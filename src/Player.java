import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {

    private BufferedImage image;

    private Boolean facedLeft = true;

    private Boolean facedRight;

    private Boolean facedDown;

    private Boolean facedUp;
    private String name;
    private int coins;

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
            readImage("src/p1Up.png");
            currentY -= speed;
        }
    }

    public void moveDown(){
        if (currentY < 350) {
            readImage("src/p1Down.png");
            currentY += speed;
        }
    }

    public void moveLeft(){
        if (currentX > 0) {
            readImage("src/p1Left.png");
            currentX -= speed;
        }
    }

    public void moveRight(){
        if (currentX < 740) { //specific number because only the left side is accounted for the sprite position and each sprite has a different amount of pixels
           readImage("src/p1Right.png");
            currentX += speed;
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


    public void faceLeft(boolean face){
        facedLeft = face;
    }

    public void faceRight(boolean face){
        facedRight = face;
    }

    public void faceUp(boolean face){
        facedUp= face;
    }

    public void faceDown(boolean face){
        facedDown = face;
    }

    public Boolean getFacedLeft(){
        return facedLeft;
    }

    public Boolean getFacedUp(){
        return facedUp;
    }


    public Boolean getFacedDown(){
        return facedDown;
    }

    public Boolean getFacedRight(){
        return facedRight;
    }


}

