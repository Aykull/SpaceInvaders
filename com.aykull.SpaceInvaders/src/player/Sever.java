package player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import display.Display;
import levels.Levels;

public class Sever implements Runnable {
	private Ship user = Levels.ship;

	@Override
	public void run() {
		try {
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(9000);
			while(true) {
				System.out.println("Esperando....");
				Socket socket= server.accept();
				System.out.println("Recibido");
				BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String texto= entrada.readLine();
				System.out.println(texto);
				if(texto.equals("Left")) {
					user.left = true;
					user.right = false;
					user.shoot = false;
					//user.update(Levels.delta1);
				}else if(texto.equals("Right")) {
					user.right = true;
					user.left = false;
					user.shoot = false;
					//user.update(Levels.delta1);
				}else if(texto.equals("FIRE!")) {
					user.shoot = true;
				}else {
					user.right = false;
					user.left = false;
					user.shoot = false;
				}
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}