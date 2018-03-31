package levels;

import javax.swing.JFrame;


public class GameScreen extends JFrame  {
	public GameScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Draw());
		setTitle("Space Invaders");
		setSize(800, 600);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
	}
	
	
	public static void main(String[] args) {
		new GameScreen();
		
	}
}


