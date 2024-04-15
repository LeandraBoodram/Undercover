import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.Font;

class DrawPanel extends JPanel implements MouseListener {
    private Rectangle button;

    private String player1String;
    private int charMoveX = 0;
    private int charMovey = 0;
    private int changeX;
    private int changeY;

    private Screen start;
    public DrawPanel() {
        button = new Rectangle(150, 100, 150, 25);
        this.addMouseListener(this);
        Screen start = new Screen(true, "src/homeScreen.png");

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 50;
        int y = 10;
        start.setStartBoxLocation(x, y);
        g.drawImage(start.getImage(), 0, 0, 900, 500, null);
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.drawString("Start", 150, 120);
        g.drawRect((int)button.getX(), (int)button.getY(), (int)button.getWidth(), (int)button.getHeight());
        player1String = "src/baseP1right";
        Player1 p = new Player1("lol", player1String);
        g.drawImage(p.getImage(), charMoveX, charMovey, 200, 100, null);
        g.drawImage(start.getImage(), 0, 0, 900, 500, null);

    }

    public void moveChar(Graphics g){
        g.fillRect(charMoveX, charMovey, 50, 20);
        charMoveX = charMoveX + changeX;
        charMovey = charMovey + changeY;

    }
    public void keyPressed(KeyEvent e){

        int push = e.getKeyCode();

        if (push == KeyEvent.VK_LEFT){
            changeX = -10;
            player1String = "src/baseP1left";
        }

        if (push == KeyEvent.VK_RIGHT){

        }

    }

    public void mousePressed(MouseEvent e) {
        if((button.contains(getMousePosition()))){
            start.changeImage("src/house.png");
        }
    }

    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) {
    }
}