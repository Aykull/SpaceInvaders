package enemy_typo;
import lists.SimpleLL;
import player.Ship;

import java.awt.Color;
import java.awt.Graphics2D;

import levels.*;
public abstract class EnemyTypo implements Comparable<EnemyTypo> {
	public abstract void draw(Graphics2D g);
	public abstract void update(double delta, Ship ship);
	public abstract void changeDirection(double delta);
	
	public abstract boolean deathScene();
	public abstract boolean collide(int i, Ship ship, SimpleLL<EnemyTypo> enemys);
	public abstract boolean isOutOfBounds();
	
	
	}

