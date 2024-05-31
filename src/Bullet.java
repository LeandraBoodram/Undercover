import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bullet {

    private int speed = 4;

    private boolean move;

    private String iN;

    private boolean isVisible;

    private int currentX;

    private int currentY;


    private BufferedImage image;

    public Bullet (Player p){
        currentX = p.getCurrentX();
        currentY = p.getCurrentY();
        iN = "src/bulletUp.png";
    }
    public BufferedImage readImage() {
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

    private void makeVisible(){
        isVisible = true;
    }

    private void makeInvisible(){
        isVisible = false;
    }

    private boolean getIsVisible(){
        return isVisible;
    }
    public void setLocation(int x, int y) {
        currentX = x;
        currentY = y;

    }

    public void moveUp(){
        if (currentY > 0 ) {
            iN ="src/bulletUp.png";
            currentY -= speed;
        }
    }

    public void moveDown(){
        if (currentY < 350) {
            iN = "src/bulletDown.png";
            currentY += speed;
        }
    }

    public void moveLeft(){ //if char is facing left
        if (currentX > 0) {
            iN = "src/bulletLeft.png";
            currentX -= speed;
        }
    }

    public void moveRight(){
        if (currentX < 740) { //specific number because only the left side is accounted for the sprite position and each sprite has a different amount of pixels
            iN = "src/bulletRight.png";
            currentX += speed;
        }
    }

    public int getCurrentX(){
        return currentX;
    } //later on used to decrease health
    public int getCurrentY(){
        return currentY;
    }

}
