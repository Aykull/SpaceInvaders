package player;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Ship {
	private String van = "van.png";
	
	private int dx;
	
	private int x;
	private int y;

	
	private Image image;
	
	public Ship() {
		x=350;
		y=450;
		ImageIcon img = new ImageIcon(this.getClass().getResource(van));
		image = img.getImage();
	}
	
	public void move() {
		x += dx;
		
	}
	public int haveX() {
		return x;
	}
	public int haveY() {
		return y;
	}

	
	public Image haveImage() {
		return image;
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			dx=-3;
		}
		if (key == KeyEvent.VK_RIGHT) {
			dx=3;
		}
	}
	public void keyReleassed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT) {
			dx=0;
		}
		if(key == KeyEvent.VK_RIGHT) {
			dx=0;
		}
	}
	

}
