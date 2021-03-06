import java.net.Socket;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ChatClientHandler implements Runnable
{
	private Socket connection_socket = null;
	private ArrayList<Socket> socket_list;
	private ArrayList<String> username_list;

	ChatClientHandler(Socket socket, ArrayList<Socket> socket_list, ArrayList<String> username_list)
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
			int m = username_list.size();
			String name = username_list.get(m-1);
			while (true)
			{
				//Get timestamps for user text
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

				BufferedReader client_input = new BufferedReader(
						new InputStreamReader(connection_socket.getInputStream()));
				String client_text = client_input.readLine();

				if (client_text != null)
				{
					System.out.println("Received: " + client_text);
					int i = 0;

					for (Socket s : socket_list)
					{
						if (s != connection_socket)
						{
							DataOutputStream client_output = new DataOutputStream(s.getOutputStream());
							client_output.writeBytes(sdf.format(cal.getTime())+ " " +name+ ": " +client_text + "\n");
						}

						++i;
					}
				}
				else
				{

				  System.out.println("Closing connection for socket " + connection_socket);

				  socket_list.remove(connection_socket);
					username_list.remove(name);
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
