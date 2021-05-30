import javax.swing.JFrame;

public class LeagueInvaders {
 JFrame frame = new JFrame();
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	GamePanel gamePanel = new GamePanel();
	public static void main(String[] args) {
		LeagueInvaders runner = new LeagueInvaders();
		runner.setup();
	}
	void setup() {
		frame.add(gamePanel);
		frame.setSize(WIDTH,HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
