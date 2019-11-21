package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientListener extends Thread {
	final DataInputStream dis;
	final DataOutputStream dos;
	DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
	DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
	final Socket socket;

	// Constructor
	public ClientListener(Socket socket, DataInputStream dis, DataOutputStream dos) {
		this.socket = socket;
		this.dis = dis;
		this.dos = dos;
	}

	public void close() {
		System.out.println("Client " + this.socket + " sends exit...");
		System.out.println("Closing this connection.");
		try {
			this.socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connection closed");
	}

	@Override
	public void run() {
		String received;
		String toreturn;
		while (true) {
			try {

				// Ask user what he wants

				dos.writeUTF("Connected to Server");

				// receive the answer from client
				received = dis.readUTF();

				if (received.equals("Exit")) {
					close();
					break;
				}

				// creating Date object
				Date date = new Date();

				// write on output stream based on the
				// answer from the client
				switch (received) {

				case "Date":
					toreturn = fordate.format(date);
					dos.writeUTF(toreturn);
					break;

				case "Time":
					toreturn = fortime.format(date);
					dos.writeUTF(toreturn);
					break;

				default:
					dos.writeUTF("Invalid input");
					break;
				}
			} catch (IOException e) {
				close();
				e.printStackTrace();
				break;
			}
		}

		try {
			// closing resources
			this.dis.close();
			this.dos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}