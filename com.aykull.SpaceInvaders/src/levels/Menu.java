package levels;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import display.Display;
import levels.StateMachine;
import levels.SuperStateMachine;



public class Menu extends SuperStateMachine implements KeyListener {
	
	private Font tittleFont = new Font("Tahoma", Font.PLAIN, 64);
	private Font startFont = new Font("Tahoma", Font.PLAIN, 32);
	private String tittle = "Space Invaders";
	private String start = "Press Enter";
	
	
	public Menu(StateMachine stateMachine) {
		super(stateMachine);
		// TODO Auto-generated constructor stub
		
	}
	@Override
	public void update(double delta) {
		// TODO Auto-generated method stub

	}
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setFont(tittleFont);
		int tittleWidth = g.getFontMetrics().stringWidth(tittle);
		g.setColor(Color.yellow);
		g.drawString(tittle, ((Display.WIDTH/2)-(tittleWidth/2))-2, (Display.HEIGHT/2)-123);
		g.setColor(Color.green);
		g.drawString(tittle, (Display.WIDTH/2)-(tittleWidth/2), (Display.HEIGHT/2)-125);
		
		g.setFont(startFont);
		g.setColor(Color.white);
		int startWidth = g.getFontMetrics().stringWidth(start);
		g.drawString(start, (Display.WIDTH/2)-(startWidth/2), (Display.HEIGHT/2)+75);
		
	}
	@Override
	public void init(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			getStateMachine().setState((byte) 1);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	

	
/*
}
class Frame extends JFrame{
	//caracteristicas del frame
		public Frame(){
		
			setBounds(450,300,280,200);
			
			Panel panel = new Panel();
			
			
			add(panel);
		
			setVisible(true);
		}
	
}

class Panel extends JPanel{
	//panel dentro del frame
	//contiene un espacio para texto y un boton
	private JTextField text;
	
	private JButton button;
	
	public Panel() {
	
		JLabel usuario =new JLabel("Usuario");
		usuario.setFont(new java.awt.Font("Tahoma", 1, 50));
		usuario.setForeground(Color.white);
		
		
		add(usuario);
	
		text=new JTextField(20);
	
		add(text);		
	
		button=new JButton("Jugar");
		
		
		newGame evento = new newGame();
		
		button.addActionListener(evento);
		
		add(button);
	}
	
	//Cargar imagenes
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Image image= new ImageIcon("C:\\Users\\lucia\\Desktop\\Semestre 2018\\Datos\\Imagenes\\galaxy.jpg").getImage();
		g.drawImage(image,0, 0, null);
		
	}
	
	
	//Creacion de evento para iniciar el primer nivel
	private class newGame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Inicia");
			System.out.println(text.getText());
						
		}
		
	}
	
	
	*/
}
