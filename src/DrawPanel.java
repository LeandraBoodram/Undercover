import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

class DrawPanel extends JPanel implements MouseListener, KeyListener {
    private Rectangle button;

    private Rectangle loadBar;

    private Rectangle MenuButton;
    private JLabel p1;
    private int charX = 0;
    private int charY = 0;

    private int speed = 10;

    private BufferedImage player1;
    private Rectangle quitGameButton;
    private StartScreen s;

    private LoadingScreen l;

    private Player one;
    private HouseScreen h;

    private Text t;

    private Graphics g;

    public DrawPanel() {
        this.button = new Rectangle(150, 100, 150, 25);
        this.MenuButton = new Rectangle(491, 70, 150, 25);
        this.quitGameButton = new Rectangle(516, 100, 150, 25);
        this.loadBar = new Rectangle(327, 210, 280, 25);
        //player1 = ImageIO.read(new File("src/baseP1right"));
        //p1 = new JLabel(new ImageIcon(player1));
      //  p1.setSize(200, 100);
        t = new Text(true);
        this.addMouseListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);
        s = new StartScreen(true);
        h = new HouseScreen(false);
        l = new LoadingScreen(false);
    }

    protected void paintComponent(Graphics g) {
        this.g = g;
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
        if ((l.checkShowing()) && !(h.checkShowing()) && (s.checkShowing())){
            g.drawImage(l.getImage(), 0, 0, 900, 500, null);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.BOLD, 30));
            g.drawString("Loading...", 395, 171);
            g.drawRect((int) loadBar.getX(), (int) loadBar.getY(), (int) loadBar.getWidth(), (int) loadBar.getHeight());

            if (l.getFullTime() == 1){
                g.fillRect((int) loadBar.getX(), (int) loadBar.getY(), 50, (int) loadBar.getHeight());
            }
            if (l.getFullTime() == 2){
                g.fillRect((int) loadBar.getX(), (int) loadBar.getY(),100, (int) loadBar.getHeight());
            }
            if (l.getFullTime() == 3){
                g.fillRect((int) loadBar.getX(), (int) loadBar.getY(),150, (int) loadBar.getHeight());
            }
            if (l.getFullTime() == 4){
                g.fillRect((int) loadBar.getX(), (int) loadBar.getY(), 200, (int) loadBar.getHeight());
            }
            if (l.getFullTime() == 5){
                g.fillRect((int) loadBar.getX(), (int) loadBar.getY(), 250, (int) loadBar.getHeight());
            }
            if (l.getFullTime() == 6){
                g.fillRect((int) loadBar.getX(), (int) loadBar.getY(), 280, (int) loadBar.getHeight());
            }
            if ((l.getFullTime() == 7) && !(h.checkShowing())){
                l.stopShowing(l);
                s.startShowing(s);
                System.out.println("hello");
            }

        }
        if ((l.checkShowing()) && !(s.checkShowing()) && h.checkShowing()){
            g.drawImage(l.getImage(), 0, 0, 900, 500, null);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.BOLD, 30));
            g.drawString("Loading...", 395, 171);
            g.drawRect((int) loadBar.getX(), (int) loadBar.getY(), (int) loadBar.getWidth(), (int) loadBar.getHeight());
            if (l.getFullTime() == 1){
                g.fillRect((int) loadBar.getX(), (int) loadBar.getY(), 50, (int) loadBar.getHeight());
            }
            if (l.getFullTime() == 2){
                g.fillRect((int) loadBar.getX(), (int) loadBar.getY(),100, (int) loadBar.getHeight());
            }
            if (l.getFullTime() == 3){
                g.fillRect((int) loadBar.getX(), (int) loadBar.getY(),150, (int) loadBar.getHeight());
            }
            if (l.getFullTime() == 4){
                g.fillRect((int) loadBar.getX(), (int) loadBar.getY(), 200, (int) loadBar.getHeight());
            }
            if (l.getFullTime() == 5){
                g.fillRect((int) loadBar.getX(), (int) loadBar.getY(), 250, (int) loadBar.getHeight());
            }
            if (l.getFullTime() == 6){
                g.fillRect((int) loadBar.getX(), (int) loadBar.getY(), 280, (int) loadBar.getHeight());
            }

            if ((l.getFullTime() == 7) && !(s.checkShowing())) {
                l.stopShowing(l);
                h.startShowing(h);
                System.out.println("lol");
            }
        }

        if((s.checkShowing()) && !(h.checkShowing()) && !(l.checkShowing())){
            s.setStartBoxLocation(x, y);
            g.drawImage(s.getImage(), 0, 0, 900, 500, null);
            g.setFont(new Font("Courier New", Font.BOLD, 20));
            g.drawString("Start", 165, 118);
            g.drawRect((int) button.getX(), (int) button.getY(), (int) button.getWidth(), (int) button.getHeight());
            g.drawImage(p.getImage(), charX, charY, 200, 100, null);
            g.drawString("Quit game", 540, 118);
            g.drawRect((int) quitGameButton.getX(), (int) quitGameButton.getY(), (int) quitGameButton.getWidth(), (int) quitGameButton.getHeight());
        }
        if ((h.checkShowing()) && !(s.checkShowing()) && !(l.checkShowing())) {
            g.drawImage(h.getImage(), 0, 0, 900, 500, null);
            g.drawImage(t.getImage(), 100, 300, 700, 150, null);
            t.textOne(g);
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
        if ((h.checkShowing()) && (t.getPlayed() != 1)){
            t.textTwo(g);
        }
        if((button.contains(getMousePosition()))){
            s.stopShowing(s);
            h.startShowing(h);
            l.startShowing(l);
        }
        if((MenuButton.contains(getMousePosition()))){
            h.stopShowing(h);
            s.startShowing(s);
            l.startShowing(l);
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