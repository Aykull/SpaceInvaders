package enemy_typo;

import javax.swing.ImageIcon;

import player.Sprite;

import lists.SimpleCL;

public class CClass extends Sprite implements Comparable<CClass> {
	@Override
		public int compareTo(CClass o) {
			// TODO Auto-generated method stub
			return 0;
		}
	//imagen del enemigo
	private final String alienImg = "RJ.png";

	//contadpres para el movimiento
	public CClass(int x, int y) {

		initCClass(x, y);
	}

	//cambio de posicion
	private void initCClass(int x, int y) {
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
