package levels;
import java.awt.Canvas;
import java.awt.Graphics2D;
import java.util.ArrayList;

import levels.Levels;
import levels.SuperStateMachine;
import lists.SimpleLL;
public class StateMachine {
	
	private SimpleLL<SuperStateMachine> states = new SimpleLL<SuperStateMachine>();
	private Canvas canvas;
	private byte selectState = 0;
	
	public StateMachine(Canvas canvas){
		SuperStateMachine game = new GameScreen(this);
		SuperStateMachine menu = new Menu(this);
		states.add(menu);
		states.add(game);
		
		this.canvas = canvas;
	}
	
	public void draw(Graphics2D g){
		states.getData((selectState)).draw(g);
	}
	
	public void update(double delta){
		states.getData((selectState)).update(delta);
	}
	
	public void setState(byte i){
		for(int r = 0; r < canvas.getKeyListeners().length; r++)
			canvas.removeKeyListener(canvas.getKeyListeners()[r]);
		selectState = i;
		states.getData((selectState)).init(canvas);
	}

	public byte getStates() {
		return selectState;
	}
}
