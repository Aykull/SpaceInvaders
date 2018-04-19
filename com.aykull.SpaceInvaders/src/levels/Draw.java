package levels;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import enemy_typo.*;
import lists.*;
import player.*;

public class Draw extends JPanel implements ActionListener {
	//Creacion de objetos para dibujar
	private Ship ship;
	private Timer timer;
	private SimpleLL<AClass> aclass;
	private Bullet bullet;
	//Contadores para movimiento, direccion y muertes
	
	private final int ALIEN_INIT_X = 150;
    private final int ALIEN_INIT_Y = 5;
    private int direction = -1;
    private int deaths = 0;
    
    //esta en juego o no
    private boolean ingame = true;
    
    //Thread para animacion
	
	private Thread animator;

	//Constructor
	public Draw() {
		
		addKeyListener(new TAdapter());
		setFocusable(true);
		
		
		ship= new Ship();
		timer = new Timer(15,this);
		
		gameInit();
        setDoubleBuffered(true);
		
		timer.start();
	}
	
	@Override
    public void addNotify() {

        super.addNotify();
        gameInit();
    }
	//Creacion de los invasores, nave y disparos
	public void gameInit() {

        aclass = new SimpleLL<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {

                AClass alien = new AClass(ALIEN_INIT_X + 18 * j, ALIEN_INIT_Y + 18 * i);
                aclass.add(alien);
            }
        }

        ship=new Ship();
        bullet = new Bullet();

        if (animator == null || !ingame) {

            //animator = new Thread(this);
            animator.start();
        }
       
    }
	//Se dibujan los objetos
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(ship.haveImage(),ship.haveX(),ship.haveY(),null);
				
	}
	public void drawBullet(Graphics g) {

        if (bullet.isVisible()) {
            
            g.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), this);
        }
    }
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Image image= new ImageIcon("C:\\Users\\lucia\\Desktop\\Semestre 2018\\Datos\\Imagenes\\space.jpg").getImage();
		g.drawImage(image,0, 0, null);
		
	}
	
	//Movimiento de la nave
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ship.move();
		repaint();
	}

	
		//Disparar
	   private class TAdapter extends KeyAdapter {

	        @Override
	        public void keyReleased(KeyEvent e) {

	            ship.keyReleassed(e);
	        }

	        @Override
	        public void keyPressed(KeyEvent e) {

	            ship.keyPressed(e);
	            int x = ship.haveX();
	            int y = ship.haveY();

	            int key = e.getKeyCode();

	            if (key == KeyEvent.VK_SPACE) {
	                
	                if (ingame) {
	                    if (!bullet.isVisible()) {
	                        bullet = new Bullet(x, y);
	                    }
	                }
	            }
	        }
	    }
}







