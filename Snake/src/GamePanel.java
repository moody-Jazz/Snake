import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	static final int SCREEN_HEIGHT = 600;
    static final int SCREEN_WIDTH = 600;
    static final int UNIT_SIZE = 20;
    static final int GAME_UNIT = (SCREEN_HEIGHT * SCREEN_WIDTH) / UNIT_SIZE;
    static int DELAY = 200;
    final int x[] = new int[GAME_UNIT];
    final int y[] = new int[GAME_UNIT];
    int bodyParts = 5;
    int applesEaten;
    short counter;
    int applex;
    int appley;
    static Color bgColor = new Color(102, 255, 102);
    static Color headColor = new Color(0, 20, 51);
    static Color bodyColor = new Color(0, 71, 179);
    String direction = "Right";
    boolean running = false;
    static Timer timer;
    Random random;

    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_HEIGHT, SCREEN_WIDTH));
        this.setBackground(bgColor);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.setVisible(true);
        startGame();
    }

    private void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics grafix) {
        /**
         * The paintComponent() method is a method of the JComponent class in
         * Java Swing that is used to paint the component on the screen. When a
         * JComponent is displayed on the screen, Swing calls the
         * paintComponent() method to render the component.
         *
         * The paintComponent() method takes a single parameter, a Graphics
         * object, which represents the graphics context used for painting. The
         * Graphics object provides methods for drawing shapes, text, and images
         * on the component.
         */
        super.paintComponent(grafix);
        draw(grafix);
    }

    public void draw(Graphics grafix) {
        if (running) {
            //this for loop draws a grid
//            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
//                grafix.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
//                grafix.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
//            }
            grafix.setColor(new Color(255, 51, 51));
            grafix.fillOval(applex, appley, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    grafix.setColor(headColor);
                    grafix.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    grafix.setColor(bodyColor);
                    grafix.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
        } else {
            gameOver(grafix);
        }
    }

    public void newApple() {
        //here we are multiplying the random number with UNIT_SIZE so that that
        //apple align with the box which we made with drawing vertical and horizontal lines
        applex = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appley = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
        
        // checking if apple's coordinate matches the body cooridnate and respawninsg it
        for (int i = bodyParts; i >= 0; i--) {
            if (x[i] == applex && y[i] == appley) {
                i = bodyParts;
                applex = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
                appley = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
            }
        }
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case "Right" :
                x[0] += UNIT_SIZE;
                break;
            case "Left" :
                x[0] -= UNIT_SIZE;
                break;
            case "Up" :
                y[0] -= UNIT_SIZE;
                break;
            case "Down" :
                y[0] += UNIT_SIZE;
                break;
        }
    }

    public void checkApple() {
        if (x[0] == applex && y[0] == appley) {
            bodyParts++;
            applesEaten++;
            ScorePanel.scoreLabel.setText("Score: " + applesEaten);
            counter++;
            newApple();
        }
    }

    public void checkCollision() {
        for (int i = bodyParts; i > 0; i--) {
            //checks if head collids with body
            if (x[0] == x[i] && y[0] == y[i]) {
                running = false;
            }
        }

        if (x[0] < 0) {//check if head collids in left wall
            running = false;
        }
        if (x[0] >= SCREEN_WIDTH) {//check if head collids in right wall
            running = false;
        }
        if (y[0] < 0) { //check if head collids in upper wall
            running = false;
        }
        if (y[0] >= SCREEN_HEIGHT) { //check if head collids in lower wall
            running = false;
        }
        if (!running) {
            timer.stop();
        }
    }

    public void gameOver(Graphics grafix) {
        grafix.setColor(Color.white);
        grafix.setFont(new Font("Arial", Font.BOLD, 75));
        FontMetrics metrix = getFontMetrics(grafix.getFont());
        grafix.drawString("Game Over", (SCREEN_WIDTH - metrix.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);
        
        this.add(new Button(this,"Retry",(SCREEN_WIDTH-100)/4,SCREEN_HEIGHT/2+SCREEN_HEIGHT/4,100,50));
        this.add(new Button(this,"Quit",((SCREEN_WIDTH/2 + SCREEN_WIDTH/4) - 100),SCREEN_HEIGHT/2+SCREEN_HEIGHT/4,100,50));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (running) {
            move();
            checkApple();
            checkCollision();
            repaint();
        }
        //After snake eats 3 apples each time its speed increases
        if (counter % 3 == 0 && counter != 0) {
            counter = 0;
            DELAY -= 10;
            timer.setDelay(DELAY);
        }

    }

    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent kevent) {
            switch (kevent.getKeyCode()) {
                case KeyEvent.VK_LEFT : 
                    if (!(direction.equals("Right"))) {
                        direction = "Left";
                    }
                    break;
                
                case KeyEvent.VK_RIGHT : 
                    if (!(direction.equals("Left"))) {
                        direction = "Right";
                    }
                    break;
                
                case KeyEvent.VK_UP : 
                    if (!(direction.equals("Down"))) {
                        direction = "Up";
                    }
                    break;
                
                case KeyEvent.VK_DOWN : 
                    if (!(direction.equals("Up"))) {
                        direction = "Down";
                    }
                    break;
                
            }
        }
    }
}