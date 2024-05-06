import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Scanner;

class DrawPanel extends JPanel implements MouseListener, KeyListener {
    private Rectangle button;

    private Rectangle quitButton;
    private String player1String;
    private int charMoveX = 0;
    private int charMovey = 0;
    private int changeX;
    private int changeY;

    private StartScreen s;

    private HouseScreen h;

    public DrawPanel() {
        this.button = new Rectangle(150, 100, 150, 25);
        this.quitButton = new Rectangle(491, 70, 150, 25);
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
            g.drawString("Start", 165, 118);
            g.drawRect((int) button.getX(), (int) button.getY(), (int) button.getWidth(), (int) button.getHeight());
            player1String = "src/baseP1right";
            Player1 p = new Player1("lol", player1String);
            g.drawImage(p.getImage(), charMoveX, charMovey, 200, 100, null);
            if ((h.checkShowing()) && !(s.checkShowing())) {
                g.drawImage(h.getImage(), 0, 0, 900, 500, null);
                g.setColor(Color.WHITE);
                g.setFont(new Font("Courier New", Font.BOLD, 20));
                g.drawString("Player 1 uses WASD to move", 491, 31);
                g.setFont(new Font("Courier New", Font.BOLD, 20));
                g.drawString("Player 2 uses Arrows to move", 491, 49);
                g.setFont(new Font("Courier New", Font.BOLD, 20));
                g.drawString("Quit", 540, 90);
                g.drawRect((int) quitButton.getX(), (int) quitButton.getY(), (int) quitButton.getWidth(), (int) quitButton.getHeight());
                if((s.checkShowing()) && !(h.checkShowing())){
                    s.setStartBoxLocation(x, y);
                    g.drawImage(s.getImage(), 0, 0, 900, 500, null);
                    g.setFont(new Font("Courier New", Font.BOLD, 20));
                    g.drawString("Start", 165, 118);
                    g.drawRect((int) button.getX(), (int) button.getY(), (int) button.getWidth(), (int) button.getHeight());
                    g.drawImage(p.getImage(), charMoveX, charMovey, 200, 100, null);

                }
            }
        }


    //public void moveChar(Graphics g){
       // g.fillRect(charMoveX, charMovey, 50, 20);
    //    charMoveX = charMoveX + changeX;
        //charMovey = charMovey + changeY;

   // }
    public void keyTyped (KeyEvent e){

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
         //   changeX = -10;
            System.out.println("RIGHT");

            //player1String = "src/baseP1left";
        }

        if (e.getKeyChar() == 'a') {
            System.out.println("a");
        }

        if (e.getKeyChar() == 's') {
            System.out.println("s");
        }

        if (e.getKeyChar() == 'd') {
            System.out.println("d");
        }

    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        if((button.contains(getMousePosition()))){
            s.stopShowing(s);
            h.startShowing(h);
        }
        if((quitButton.contains(getMousePosition()))){
            h.stopShowing(h);
            s.startShowing(s);
        }
        System.out.println(getMousePosition());
    }

    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) {
    }
}