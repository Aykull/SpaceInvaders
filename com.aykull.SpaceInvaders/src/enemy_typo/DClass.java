package enemy_typo;

import lists.DoubleLL;

import javax.swing.ImageIcon;

import player.Sprite;

public class DClass extends Sprite implements Comparable<DClass>{

	@Override
	public int compareTo(DClass o) {
		// TODO Auto-generated method stub
		return 0;
	}
	//imagen del enemigo
	private final String alienImg = "RJ.png";

	//contadpres para el movimiento
	public DClass(int x, int y) {

		initDClass(x, y);
	}

	//cambio de posicion
	private void initDClass(int x, int y) {
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
