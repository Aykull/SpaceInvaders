package player;

import java.awt.Graphics2D;

import levels.Timer;
import lists.SimpleLL;

public class PlayerWeapon {
	private Timer timer;
	
	public SimpleLL<PlayerWeaponType> weapons = new SimpleLL<PlayerWeaponType>();
	
	
	public PlayerWeapon(){
		
		timer = new Timer();
		
	}
	
	public void draw(Graphics2D g){
		
	
		for(int i = 0; i < weapons.getSize();i++) {
			weapons.getData(i).draw(g);
		}
	}
	
	public void update(double delta){
		
		
		for(int i = 0; i < weapons.getSize(); i++){
			weapons.getData(i).update(delta);
			if(weapons.getData(i).destory()) {
				
				weapons.deleteValue(i);
			}
		}
	}
	
	public void shootBullet(double xPos, double yPos, int width, int height){
		if(timer.timerEvent(250)) {
			weapons.add(new Bullet(xPos + 22, yPos + 15, width, height));
		}
	}

	public void reset() {
		weapons.clear();
	}

}
