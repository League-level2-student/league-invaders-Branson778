import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
 Rocketship rocketship = new Rocketship(250,300,50,50);
 Random random = new Random();
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
ArrayList<Alien> aliens = new ArrayList<Alien>();

 ObjectManager(Rocketship rocketship){
	 this.rocketship = rocketship;

 }
 void draw(Graphics h){
	rocketship.draw(h);
	 for (int i = 0; i < aliens.size(); i++) {
		aliens.get(i).draw(h);
	}
	 for (int i = 0; i < projectiles.size(); i++) {
		projectiles.get(i).draw(h);
	}
 }
 void purgeObjects() {
	 for (int i = 0; i < aliens.size(); i++) {
		if (aliens.get(i).isActive == false) {
			aliens.remove(i);
		}
	}
	 for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}
		}
 }
 void addProjectile(Projectile projectile) {
	 projectiles.add(projectile);
 }
 void addAlien() {
	 aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
 }
 void update(){
	 for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).y > LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive = false;
			}
			else {
				aliens.get(i).update();
			}
			}
	 for (int i = 0; i < projectiles.size(); i++) {
		if (projectiles.get(i).y < 0) {
		 projectiles.get(i).isActive = false;
	}
		else {
			projectiles.get(i).update();
		}
 }

}
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	addAlien();
}
}
