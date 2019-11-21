package network.serverside;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import network.ClientListener;
import network.Network;

public class Server implements Network {

	public static void main(String[] args) throws IOException {
		new Server();
	}
	ServerSocket serverSocket = null;

	Socket socket = null;

	public Server() {
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Initialazing ClientListenerLoop");
		ClientListener();
	}

	// running infinite loop for getting
	// client request
	void ClientListener() {
		while (true) {

			try {
				// socket object to receive incoming client requests
				socket = serverSocket.accept();

				System.out.println("A new client is connected : " + socket);

				// obtaining input and out streams
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

				System.out.println("Assigning new thread for this client");

				// create a new thread object
				Thread t = new ClientListener(socket, dis, dos);

				// Invoking the start() method
				t.start();

			} catch (Exception e) {
				try {
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}
}