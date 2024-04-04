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

    public DrawPanel() {
        button = new Rectangle(150, 100, 150, 25);
        this.addMouseListener(this);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 50;
        int y = 10;
        StartScreen s = new StartScreen(true);
        s.setStartBoxLocation(x, y);
        g.drawImage(s.getImage(), 0, 0, 700, 500, null);
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.drawString("Start", 150, 120);
        g.drawRect((int)button.getX(), (int)button.getY(), (int)button.getWidth(), (int)button.getHeight());
    }

    public void mousePressed(MouseEvent e) { }

    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
}