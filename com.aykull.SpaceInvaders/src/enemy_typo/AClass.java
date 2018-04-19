package enemy_typo;

import javax.swing.ImageIcon;

import lists.SimpleLL;
import player.Sprite;


public class AClass extends Sprite implements Comparable<AClass> {

	@Override
	public int compareTo(AClass o) {
		// TODO Auto-generated method stub
		return 0;
	}
	//imagen del enemigo
	private final String alienImg = "RJ.png";

	//contadpres para el movimiento
	public AClass(int x, int y) {

		initAClass(x, y);
	}

	//cambio de posicion
	private void initAClass(int x, int y) {
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


	


