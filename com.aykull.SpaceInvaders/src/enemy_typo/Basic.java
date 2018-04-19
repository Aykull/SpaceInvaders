package enemy_typo;

import javax.swing.ImageIcon;

import lists.SimpleLL; 
import player.Sprite;

public class Basic extends Sprite implements Comparable<Basic>{

	@Override
	public int compareTo(Basic o) {
		// TODO Auto-generated method stub
		return 0;
	}
	//imagen del enemigo
	private final String alienImg = "RJ.png";

	//contadpres para el movimiento
	public Basic(int x, int y) {

		initBasic(x, y);
	}

	//cambio de posicion
	private void initBasic(int x, int y) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;

		ImageIcon ii = new ImageIcon(alienImg);
		setImage(ii.getImage());
	}

		public void act(int direction) {

			this.x += direction;
		
	}

}
