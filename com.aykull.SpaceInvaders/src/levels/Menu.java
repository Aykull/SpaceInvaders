package levels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Menu {
	public static void main(String[] args) {
		//Se crea el frame para el menu
		Frame frame = new Frame();
		frame.setTitle("MENU");
		frame.setResizable(false);
		
	}

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
			Levels l1 = new Levels();
			
		}
		
	}
	
	
	
}
