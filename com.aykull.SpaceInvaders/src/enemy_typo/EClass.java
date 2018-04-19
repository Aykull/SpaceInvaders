package enemy_typo;

import javax.swing.ImageIcon;

import lists.DoubleLL;
import lists.SimpleCL;
import player.Sprite;

public class EClass extends Sprite  implements Comparable<EClass>  {

	@Override
	public int compareTo(EClass o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//imagen del enemigo
		private final String alienImg = "RJ.png";

		//contadpres para el movimiento
		public EClass(int x, int y) {

			initEClass(x, y);
		}

		//cambio de posicion
		private void initEClass(int x, int y) {
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


