import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

class DrawPanel extends JPanel implements MouseListener, KeyListener {
    private Rectangle button;

    private Rectangle loadBar;

    private Rectangle MenuButton;

    private ArrayList<Boolean> press;


    private int speed = 10;

    private Rectangle quitGameButton;
    private StartScreen s;

    private LoadingScreen l;

    private Player one;

    private Player two;
    private HouseScreen h;

    private Bullet oneAttack;

    private Bullet twoAttack;

    private Text t;

    private Graphics g;

    public DrawPanel() {
        this.one = new Player("lol", 156, 85, "src/baseP1right.png");
        this.two = new Player("lolTwo", 170, 85, "src/baseP1left.png");
        this.button = new Rectangle(150, 100, 150, 25);
        this.MenuButton = new Rectangle(491, 70, 150, 25);
        this.quitGameButton = new Rectangle(516, 100, 150, 25);
        this.loadBar = new Rectangle(327, 210, 280, 25);
        this.oneAttack = new Bullet(one);
        this.twoAttack = new Bullet(two);
        t = new Text(true);
        this.addMouseListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);
        s = new StartScreen(true);
        h = new HouseScreen(false);
        l = new LoadingScreen(false);
        this.press = new ArrayList<Boolean>();
        press.add(false); //up
        press.add(false); //down
        press.add(false); //left
        press.add(false); //right
        press.add(false); //w
        press.add(false); //s
        press.add(false); //a
        press.add(false); //d
    }

    protected void paintComponent(Graphics g) {
        // based on which buttons are being pressed, move the character appropriately
        //make a arraylist of booleans where each index correspond to a boolean
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
            g.drawImage(one.getImage(), one.getCurrentX(), one.getCurrentY(), 200, 100, null);
        g.drawImage(two.getImage(), two.getCurrentX(), two.getCurrentY(), 200, 100, null);
       if ((one.getAttack()) && (one.getCurrentX() != 0)){
           g.drawImage(oneAttack.getImage(), oneAttack.getCurrentX(), oneAttack.getCurrentY(), 200, 200, null);
           oneAttack.moveLeft();
       }

        if (press.get(0)){
            one.moveUp();
        //    System.out.println(one.getCurrentY());
        }
        if (press.get(1)){
            one.moveDown();
         //   System.out.println(one.getCurrentY());
        }

        if (press.get(2)){
            one.moveLeft();
        //    System.out.println(one.getCurrentX());
        }
        if (press.get(3)){
            one.moveRight();
        //    System.out.println(one.getCurrentX());
        }
        if (press.get(4)){
            two.moveUp();
        //    System.out.println(two.getCurrentY());
        }
        if (press.get(5)){
            two.moveDown();
         //   System.out.println(two.getCurrentY());
        }
        if (press.get(6)){
            two.moveLeft();
        //    System.out.println(two.getCurrentX());
        }
        if (press.get(7)){
            two.moveRight();
        //    System.out.println(two.getCurrentX());
        }
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
            g.drawString("Quit game", 540, 118);
            g.drawRect((int) quitGameButton.getX(), (int) quitGameButton.getY(), (int) quitGameButton.getWidth(), (int) quitGameButton.getHeight());
            g.drawImage(one.getImage(), one.getCurrentX(), one.getCurrentY(), 200, 100, null);
            g.drawImage(two.getImage(), two.getCurrentX(), two.getCurrentY(), 200, 100, null);
        }
        if ((h.checkShowing()) && !(s.checkShowing()) && !(l.checkShowing())) {
            g.drawImage(h.getImage(), 0, 0, 900, 500, null);
            g.drawImage(t.getImage(), 100, 300, 700, 150, null);
            t.textOne(g);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.BOLD, 20));
            g.drawString("Player 1 uses Arrows to move", 491, 31);
            g.setFont(new Font("Courier New", Font.BOLD, 20));
            g.drawString("Player 2 uses WASD to move", 491, 49);
            g.setFont(new Font("Courier New", Font.BOLD, 20));
            g.drawString("Menu", 540, 90);
            g.drawRect((int) MenuButton.getX(), (int) MenuButton.getY(), (int) MenuButton.getWidth(), (int) MenuButton.getHeight());
            g.drawString("Quit game", 507, 118);
            g.drawRect((int) MenuButton.getX(), (int) quitGameButton.getY(), (int) quitGameButton.getWidth(), (int) quitGameButton.getHeight());
            g.drawImage(one.getImage(), one.getCurrentX(), one.getCurrentY(), 200, 100, null);
            g.drawImage(two.getImage(), two.getCurrentX(), two.getCurrentY(), 200, 100, null);
            }

            if (one.getHealth() == 0){
                System.exit(0);
            }


        }


    public void keyTyped (KeyEvent e){
    }

    public void keyPressed(KeyEvent e) {

        int pressed = e.getKeyCode();

        if (pressed == KeyEvent.VK_M){
            one.attackOn();
        }

        if (pressed == KeyEvent.VK_E){
            two.attackOn();
        }

        if (pressed == KeyEvent.VK_UP) {
            press.set(0, true);

        }
        if (pressed == KeyEvent.VK_DOWN) {
            press.set(1, true);
        }
        if (pressed == KeyEvent.VK_LEFT) {
            press.set(2, true);
        }
        if (pressed == KeyEvent.VK_RIGHT) {
            press.set(3, true);
        }

        if (pressed == KeyEvent.VK_W) {
            press.set(4, true);
        }
        if (pressed == KeyEvent.VK_S) {
            press.set(5, true);
        }
        if (pressed == KeyEvent.VK_A) {
            press.set(6, true);
        }
        if (pressed == KeyEvent.VK_D) {
            press.set(7, true);
        }

    }

    public void keyReleased(KeyEvent e) {
        int pressed = e.getKeyCode();

       // if (pressed == KeyEvent.VK_M){
     //       one.attackOff();
      //  }

        if (pressed == KeyEvent.VK_E){
            two.attackOff();
        }

        if (pressed == KeyEvent.VK_UP) {
            press.set(0, false);
        }

        if (pressed == KeyEvent.VK_DOWN) {
            press.set(1, false);
        }
        if (pressed == KeyEvent.VK_LEFT) {
            press.set(2, false);
        }
        if (pressed == KeyEvent.VK_RIGHT) {
            press.set(3, false);
        }

        if (pressed == KeyEvent.VK_W) {
            press.set(4, false);
        }
        if (pressed == KeyEvent.VK_S) {
            press.set(5, false);
        }
        if (pressed == KeyEvent.VK_A) {
            press.set(6, false);
        }
        if (pressed == KeyEvent.VK_D) {
            press.set(7, false);
        }
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