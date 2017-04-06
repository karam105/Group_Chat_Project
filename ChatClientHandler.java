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
	private ArrayList<String> username_list;

	ClientHandler(Socket socket, ArrayList<Socket> socket_list)
	{
		this.connection_socket = socket;
		this.socket_list = socket_list;
		this.username_list = username_list;
	}

	public void run()
	{

		try
		{
			System.out.println("Connection made with socket " + connection_socket);
			BufferedReader client_input = new BufferedReader(
				new InputStreamReader(connection_socket.getInputStream()));
			
			String client_text = client_input.readLine();
			username_list.add(client_text);

			while (true)
			{
				if (client_text != null)
				{
					System.out.println("Received: " + client_text);
					int i = 0;

					for (Socket s : socket_list)
					{
						if (s != connection_socket)
						{
							DataOutputStream client_output = new DataOutputStream(s.getOutputStream());
							String name = username_list.get(i);
							client_output.writeBytes(name+ " " +client_text + "\n");
						}
						++i;
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
