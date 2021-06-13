import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
 Rocketship rocketship = new Rocketship(250,300,50,50);
 Random random = new Random();
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
ArrayList<Alien> aliens;

 ObjectManager(Rocketship rocketship, Projectile projectile){
	 this.rocketship = rocketship;

 }
 
 void addProjectile(Projectile projectile) {
	 projectiles.add(projectile);
 }
 void addAlien() {
	 aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
 }
 void update(){
	 for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
 }

}
