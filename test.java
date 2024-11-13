import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class test extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private int clawX = 100, clawY = 50;    // Initial claw position
    private int clawWidth = 20, clawHeight = 20;
    private boolean isGrabbing = false;
    private int attempts = 5, score = 0;
    
    public ClawMachineGame() {
        timer = new Timer(30, this);  // Set up a timer to repaint the screen
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawClaw(g);
        drawPrizes(g);
        drawScoreboard(g);
    }

    private void drawClaw(Graphics g) {
        g.setColor(Color.GRAY);
        
        // Draw the claw "arm" (the vertical line) at the current claw position
        g.drawLine(clawX + clawWidth / 2, 0, clawX + clawWidth / 2, clawY);
        
        // Draw the actual claw at the bottom of the arm
        g.fillRect(clawX, clawY, clawWidth, clawHeight);
    }
    

    private void drawPrizes(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(150, 300, 30, 30);  // Simple prize
    }

    private void drawScoreboard(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 10);
        g.drawString("Attempts: " + attempts, 10, 25);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isGrabbing) {
            clawY += 5;  // Move claw down when grabbing
            if (clawY >= 300) {  // Check for prize collision
                checkForPrize();
                isGrabbing = false;  // Stop grabbing and move claw up
            }
        } else if (clawY > 50) {
            clawY -= 5;  // Move claw back up
        }
        repaint();
    }

    private void checkForPrize() {
        // Check if claw overlaps with a prize (simple collision check)
        Rectangle clawRect = new Rectangle(clawX, clawY, clawWidth, clawHeight);
        Rectangle prizeRect = new Rectangle(150, 300, 30, 30); // Prize position

        if (clawRect.intersects(prizeRect)) {
            score++;
            attempts--;
        } else {
            attempts--;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT && clawX > 0) {
            clawX -= 5;
        } else if (key == KeyEvent.VK_RIGHT && clawX < getWidth() - clawWidth) {
            clawX += 5;
        } else if (key == KeyEvent.VK_SPACE && clawY == 50) {
            isGrabbing = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Claw Machine Game");
        test game = new test();
        frame.add(game);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
