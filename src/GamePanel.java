import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font noteFont = new Font("Arail", Font.PLAIN, 24);
	Timer frameDraw;
	Rocketship rocketship1 = new Rocketship(250, 300, 50, 50);
	ObjectManager obm = new ObjectManager(rocketship1);
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	GamePanel() {
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		if(needImage) {
			loadImage("space.png");
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	void updateMenuState() {
		obm.update();
	}

	void updateGameState() {
	}

	void updateEndState() {
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("League Invaders", 50, 50);
		g.setFont(noteFont);
		g.drawString("Press ENTER To Start!", 125, 150);
		g.drawString("Press SPACE For Instructions", 85, 415);
	}

	// finish fonts and messages next
	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		obm.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Game Over", 110, 50);
		g.setFont(noteFont);
		g.drawString("You Killed 999 Enemies", 110, 150);
		g.drawString("Press ENTER To Restart", 110, 415);
	}

	@Override
	public void actionPerformed(ActionEvent frameUpdate) {
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		System.out.println("action");
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP && rocketship1.y>0) {
			System.out.println("UP");
			rocketship1.up();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN && rocketship1.y<LeagueInvaders.HEIGHT-rocketship1.height) {
			System.out.println("DOWN");
			rocketship1.down();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT && rocketship1.x>0) {
			System.out.println("LEFT");
			rocketship1.left();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && rocketship1.x<LeagueInvaders.WIDTH-rocketship1.width) {
			System.out.println("RIGHT");
			rocketship1.right();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
