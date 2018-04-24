package levels;

import java.awt.Graphics2D;

import enemy_typo.Basic;
import enemy_typo.Basic;
import enemy_typo.EnemyTypo;
import lists.SimpleLL;
import player.Ship;

public class Levels {
	public static Ship ship;
	public static double delta1;
	private SimpleLL<EnemyTypo> enemies = new SimpleLL<EnemyTypo>();

	public Levels(Ship ship){
		this.ship = ship;

		addEnemies();

	}
	public void draw(Graphics2D g) {
		if(enemies == null)
			return;

		for(int i = 0; i < enemies.getSize(); i++){
			enemies.getData(i).draw(g);
		}
		
	}


	public void update(double delta) {
		if(enemies == null)
			return;

		for(int i = 0; i < enemies.getSize(); i++){
			enemies.getData(i).update(delta, ship);
		}
		for(int i = 0; i < enemies.getSize(); i++){
			enemies.getData(i).collide(i, ship, enemies);
		}
		hasDirectionChange(delta);
	}

	
	public void hasDirectionChange(double delta) {
		if(enemies == null)
			return;
		
		for(int i = 0; i < enemies.getSize(); i++){
			if(enemies.getData(i).isOutOfBounds()){
				changeDurectionAllEnemys(delta);
			}
		}
	}

	
	public void changeDurectionAllEnemys(double delta) {
		for(int i = 0; i < enemies.getSize(); i++){
			enemies.getData(i).changeDirection(delta);
		}
		
	}

	
	public boolean isGameOver() {
		return ship.getHealth() <= 0;
	}

	public void destory() {
		
	}

	public void reset() {
		ship.reset();
		enemies.clear();
		addEnemies();
		
		
	}
	
	public void addEnemies() {
		for(int y = 0; y < 2; y++){
			for(int x = 0; x < 10; x++){
				EnemyTypo e = new Basic(150 + (x * 40), 25 + (y * 40), 1 , 3);
				enemies.add(e);
			}
		}
	}

	
	public boolean isComplete() {
		return enemies.isEmpty();
		
	}
}

