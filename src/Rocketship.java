import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 14;
		// TODO Auto-generated constructor stub
	}
	

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		System.out.println("test");
	}
    public void right() {
        x+=speed;
    }
    public void left() {
        x-=speed;
    }
    public void up() {
        y-=speed;
    }
    public void down() {
        y+=speed;
    }
}
