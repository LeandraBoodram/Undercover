import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

class DrawPanel extends JPanel implements MouseListener, KeyListener {
    private Rectangle button;

    private Rectangle MenuButton;
    private JLabel p1;
    private int charX = 0;
    private int charY = 0;

    private int speed = 10;

    private BufferedImage player1;
    private Rectangle quitGameButton;
    private StartScreen s;

    private Player one;
    private HouseScreen h;

    public DrawPanel() {
        this.button = new Rectangle(150, 100, 150, 25);
        this.MenuButton = new Rectangle(491, 70, 150, 25);
        this.quitGameButton = new Rectangle(516, 100, 150, 25);
        player1 = ImageIO.read(new File("src/baseP1right"));
        p1 = new JLabel(new ImageIcon(player1));
        p1.setSize(200, 100);
        this.addMouseListener(this);
        this.addKeyListener(this);
        s = new StartScreen(true);
        h = new HouseScreen(false);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 50;
        int y = 10;
            s.setStartBoxLocation(x, y);
            g.drawImage(s.getImage(), 0, 0, 900, 500, null);
            g.setFont(new Font("Courier New", Font.BOLD, 20));
            g.drawString("Start game", 165, 118);
            g.drawRect((int) button.getX(), (int) button.getY(), (int) button.getWidth(), (int) button.getHeight());
        g.drawString("Quit game", 540, 118);
        g.drawRect((int) quitGameButton.getX(), (int) quitGameButton.getY(), (int) quitGameButton.getWidth(), (int) quitGameButton.getHeight());
            Player p = new Player("lol");
            g.drawImage(p.getImage(), charX, charY, 200, 100, null);
            if ((h.checkShowing()) && !(s.checkShowing())) {
                g.drawImage(h.getImage(), 0, 0, 900, 500, null);
                g.setColor(Color.WHITE);
                g.setFont(new Font("Courier New", Font.BOLD, 20));
                g.drawString("Player 1 uses WASD to move", 491, 31);
                g.setFont(new Font("Courier New", Font.BOLD, 20));
                g.drawString("Player 2 uses Arrows to move", 491, 49);
                g.setFont(new Font("Courier New", Font.BOLD, 20));
                g.drawString("Menu", 540, 90);
                g.drawRect((int) MenuButton.getX(), (int) MenuButton.getY(), (int) MenuButton.getWidth(), (int) MenuButton.getHeight());
                g.drawString("Quit game", 507, 118);
                g.drawRect((int) MenuButton.getX(), (int) quitGameButton.getY(), (int) quitGameButton.getWidth(), (int) quitGameButton.getHeight());
                if((s.checkShowing()) && !(h.checkShowing())){
                    s.setStartBoxLocation(x, y);
                    g.drawImage(s.getImage(), 0, 0, 900, 500, null);
                    g.setFont(new Font("Courier New", Font.BOLD, 20));
                    g.drawString("Start", 165, 118);
                    g.drawRect((int) button.getX(), (int) button.getY(), (int) button.getWidth(), (int) button.getHeight());
                    g.drawImage(p.getImage(), charX, charY, 200, 100, null);
                    g.drawString("Quit game", 165, 118);
                    g.drawRect((int) quitGameButton.getX(), (int) quitGameButton.getY(), (int) quitGameButton.getWidth(), (int) quitGameButton.getHeight());
                }
            }
            if (p.getHealth() == 0){
                System.exit(0);
            }
        }


    //public void moveChar(Graphics g){
       // g.fillRect(charMoveX, charMovey, 50, 20);
    //    charMoveX = charMoveX + changeX;
        //charMovey = charMovey + changeY;

   // }
    public void keyTyped (KeyEvent e){
    }

    public void keyPressed(KeyEvent e) {

        int pressed = e.getKeyCode();

        if (pressed == KeyEvent.VK_UP)
            charY-=speed;
        else if (pressed == KeyEvent.VK_DOWN)
            charY+=speed;
        else if (pressed == KeyEvent.VK_LEFT)
            charX-=speed;
        else if (pressed == KeyEvent.VK_RIGHT)
            charX+=speed;
        p1.setLocation(charX, charY);
    }

    public void keyReleased(KeyEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        if((button.contains(getMousePosition()))){
            s.stopShowing(s);
            h.startShowing(h);
        }
        if((MenuButton.contains(getMousePosition()))){
            h.stopShowing(h);
            s.startShowing(s);
        }
        if((quitGameButton.contains(getMousePosition()))){
            System.exit(0);
        }
        System.out.println(getMousePosition());
    }

    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) {
    }
}