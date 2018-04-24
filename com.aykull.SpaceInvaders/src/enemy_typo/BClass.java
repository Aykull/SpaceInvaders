package enemy_typo;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import display.Display;
import levels.GameScreen;
import levels.SpriteAnimation;
import levels.Timer;
import lists.DoubleLL;
import lists.SimpleLL;
import player.Ship;


public class BClass  extends  EnemyTypo  implements Comparable<EnemyTypo> {
	private double speed = 1.0d; 
	
	private SpriteAnimation enemySprite;
	private Rectangle rect;
	private int shootTime;
	private Timer shootTimer;
	
	@Override
	public int compareTo(EnemyTypo o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	public BClass(double xPos, double yPos, int rows, int columns){
		
		enemySprite = new SpriteAnimation(xPos, yPos, rows, columns, 300, "/Img/Tata.png");
		enemySprite.setWidth(50);
		enemySprite.setHeight(50);
		enemySprite.setLimit(2);
		
		this.setRect(new Rectangle((int) enemySprite.getxPos(), (int) enemySprite.getyPos(), enemySprite.getWidth(), enemySprite.getHeight()));
		enemySprite.setLoop(true);
		
		shootTimer = new Timer();
		shootTime = new Random().nextInt(12000);
	}
	@Override
	public void draw(Graphics2D g) {
		enemySprite.draw(g);
	}

	public void update(double delta, Ship ship) {
		enemySprite.update(delta);
		
		enemySprite.setxPos(enemySprite.getxPos() - (delta * speed));
		this.getRect().x = (int) enemySprite.getxPos();
		
	}

	@Override
	public void changeDirection(double delta) {
		speed *= -1.15d;
		enemySprite.setxPos(enemySprite.getxPos() - (delta * speed));
		this.getRect().x = (int) enemySprite.getxPos();
		
		enemySprite.setyPos(enemySprite.getyPos() + (delta * 15));
		this.getRect().y = (int) enemySprite.getyPos();
	
	}

	

	@Override
	public boolean collide(int i, Ship ship,  SimpleLL<EnemyTypo> enemys) {
		if(enemySprite.isPlay()) {
			if(enemys.getData(i).deathScene()) {
				enemys.deleteValue(i);
			}
			return false;
		}
		
		for(int w = 0; w < ship.playerWeapon.weapons.getSize(); w++) {
			if(enemys != null && ship.playerWeapon.weapons.getData(w).collisionRect(((Basic) enemys.getData(i)).getRect())) {
				enemySprite.resetLimit();
				enemySprite.setAnimationSpeed(120);
				enemySprite.setPlay(true, true);
				GameScreen.SCORE += 8;
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean isOutOfBounds() {
		if(rect.x > 0 && rect.x < Display.WIDTH - rect.width)
			return false;
		return true;
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
	


	@Override
	public boolean deathScene() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
