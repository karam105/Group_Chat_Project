import java.net.Socket;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class ChatClient
{
	public static void main(String[] args)
	{
		try
		{
			String hostname = "localhost";
			int port = 7654;

			System.out.println("Connecting to server on port " + port);
			Socket connection_socket = new Socket(hostname, port);

			DataOutputStream server_output = new DataOutputStream(connection_socket.getOutputStream());

			System.out.println("Connection made.");
			System.out.println("What is your username? ")

			ClientListener listener = new ClientListener(connection_socket);
			Thread thread = new Thread(listener);
			thread.start();

			Scanner keyboard = new Scanner(System.in);
			while (true)
			{
				String data = keyboard.nextLine();
				server_out.writeBytes(data + "\n");
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
