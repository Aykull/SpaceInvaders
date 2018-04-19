package enemy_typo;

import javax.swing.ImageIcon;

import lists.DoubleLL;
import player.Sprite;

public class BClass extends Sprite implements Comparable<BClass> {

	@Override
	public int compareTo(BClass o) {
		// TODO Auto-generated method stub
		return 0;
	}
	//imagen del enemigo
	private final String alienImg = "RJ.png";

	//contadpres para el movimiento
	public BClass(int x, int y) {

		initBClass(x, y);
	}

	//cambio de posicion
	private void initBClass(int x, int y) {
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
