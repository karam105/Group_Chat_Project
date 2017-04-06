import java.net.Socket;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class ClientHandler implements Runnable
{
	private Socket connection_socket = null;
	private ArrayList<Socket> socket_list;

	ClientHandler(Socket socket, ArrayList<Socket> socket_list)
	{
		this.connection_socket = socket;
		this.socket_list = socket_list;
	}

	public void run()
	{

		try
		{
			System.out.println("Connection made with socket " + connection_socket);
			BufferedReader client_input = new BufferedReader(
				new InputStreamReader(connection_socket.getInputStream()));
			while (true)
			{

				String client_text = client_input.readLine();
				if (client_text != null)
				{
					System.out.println("Received: " + client_text);

					for (Socket s : socket_list)
					{
						if (s != connection_socket)
						{
							DataOutputStream client_output = new DataOutputStream(s.getOutputStream());
							client_output.writeBytes(client_text + "\n");
						}
					}
				}
				else
				{

				  System.out.println("Closing connection for socket " + connection_socket);

				  socket_list.remove(connection_socket);
				  connection_socket.close();
				  break;
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.toString());
			// Remove from arraylist
			socket_list.remove(connection_socket);
		}
	}
}
