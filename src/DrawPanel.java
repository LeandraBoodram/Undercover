import java.awt.event.*;
import javax.net.ssl.HostnameVerifier;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.Font;

class DrawPanel extends JPanel implements MouseListener, KeyListener {
    private Rectangle button;

    private String player1String;
    private int charMoveX = 0;
    private int charMovey = 0;
    private int changeX;
    private int changeY;

    private StartScreen s;

    private HouseScreen h;

    public DrawPanel() {
        this.button = new Rectangle(150, 100, 150, 25);
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
        g.drawString("Start", 150, 120);
        g.drawRect((int)button.getX(), (int)button.getY(), (int)button.getWidth(), (int)button.getHeight());
        player1String = "src/baseP1right";
        Player1 p = new Player1("lol", player1String);
        g.drawImage(p.getImage(), charMoveX, charMovey, 200, 100, null);
        g.drawImage(s.getImage(), 0, 0, 900, 500, null);
        if ((h.checkShowing()) && !(s.checkShowing())){
            g.drawImage(h.getImage(), 0, 0, 900, 500, null);
        }
    }

    public void moveChar(Graphics g){
        g.fillRect(charMoveX, charMovey, 50, 20);
        charMoveX = charMoveX + changeX;
        charMovey = charMovey + changeY;

    }
    public void keyTyped (KeyEvent e){

        char push = e.getKeyChar();

        if (push == 'w') {
            changeX = -10;
            System.out.println("w");

            player1String = "src/baseP1left";
        }

        if (push == 'a') {
            System.out.println("a");
        }

        if (push == 's') {
            System.out.println("s");
        }

        if (push == 'd') {
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
        System.out.println(getMousePosition());
    }

    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) {
    }
}