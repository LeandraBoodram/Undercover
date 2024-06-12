import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bullet {

    private int speed = 4;

    private boolean move;


    private boolean isVisible;

    private int currentX;

    private int currentY;
    private BufferedImage image;

    public Bullet (String imageName){
        currentX = 239;
        currentY = 394;
        image = readImage(imageName);
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
        if (isVisible) {
            // Return the image only if the bullet is visible
            return image;
        }
        return null;
    }

    public boolean canMove(){
        return move;
    }

    public void startMove(){
        move = true;
        //when movement is implemented create a condition where the player can onl move when this is called as the opening wont allow them to move
    }

    public void stopMove(){
        move = false;
    }

    public void makeVisible(){
        isVisible = true;
    }

    public void makeInvisible(){
        isVisible = false;
    }

    public boolean getIsVisible(){
        return isVisible;
    }
    public void setLocation(int x, int y) {
        currentX = x;
        currentY = y;

    }

    public void moveUp(){
        if (currentY > 0) {
            readImage("src/bulletUp.png");
            currentY -= speed;
        } else {
            // If the bullet goes off-screen, make it invisible
            makeInvisible();
        }
    }

    public void moveDown(){
        if (currentY < 350) {
            readImage("src/bulletDown.png");
            currentY += speed;
        } else {
            // If the bullet goes off-screen, make it invisible
            makeInvisible();
        }
    }

    public void moveLeft(){ //if char is facing left
        if (currentX > 0) {
            readImage("src/bulletLeft.png");
            currentX -= speed;
        } else {
            // If the bullet goes off-screen, make it invisible
            makeInvisible();
        }
    }

    public void moveRight(){
        if (currentX < 740) {
            readImage("src/bulletRight.png");
            currentX += speed;
        } else {
            // If the bullet goes off-screen, make it invisible
            makeInvisible();
        }
    }

    public int getCurrentX(){
        return currentX;
    } //later on used to decrease health
    public int getCurrentY(){
        return currentY;
    }

}
