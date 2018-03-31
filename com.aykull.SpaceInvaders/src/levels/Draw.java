package levels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import player.*;

public class Draw extends JPanel implements ActionListener {
	private Ship ship;
	private Timer timer;
	
	public Draw() {
		setFocusable(true);
		addKeyListener(new teclado());
		
		ship= new Ship();
		timer = new Timer(15,this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(ship.haveImage(),ship.haveX(),ship.haveY(),null);
				
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Image image= new ImageIcon("C:\\Users\\lucia\\Desktop\\Semestre 2018\\Datos\\Imagenes\\space.jpg").getImage();
		g.drawImage(image,0, 0, null);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ship.move();
		repaint();
	}

	
	private class teclado extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			ship.keyReleassed(e);
		}
		public void keyPressed(KeyEvent e) {
			ship.keyPressed(e);
		}
	}
}

