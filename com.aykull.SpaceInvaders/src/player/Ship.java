package player;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Ship {
	//Imagen para la nave
	private String van = "van.png";
	//contadores para movimiento
	private int dx;
	
	private int x;
	private int y;

	//cargar la imagen
	private Image image;
	
	public Ship() {
		x=350;
		y=450;
		ImageIcon img = new ImageIcon(this.getClass().getResource(van));
		image = img.getImage();
	}
	//logica del movimieto
	public void move() {
		x += dx;
		
	}
	public int haveX() {
		return x;
	}
	public int haveY() {
		return y;
	}

	//movimiento de la imagen
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
