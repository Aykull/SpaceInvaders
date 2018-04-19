package player;

import javax.swing.ImageIcon;


public class Bullet extends Sprite {
	
	
		//Imagen para el disparo
	    private final String shotImg = "boom.png";
	    //Contadores para el disparo
	    private final int H_SPACE = 6;
	    private final int V_SPACE = 1;

	    public Bullet() {
	    }
	    //movimiento
	    public Bullet(int x, int y) {

	        initShot(x, y);
	    }
	    //cargar la imagen
	    private void initShot(int x, int y) {

	        ImageIcon ii = new ImageIcon(shotImg);
	        setImage(ii.getImage());
	        
	        setX(x + H_SPACE);
	        setY(y - V_SPACE);
	    }
	}
	
	