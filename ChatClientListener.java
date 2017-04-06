import java.net.Socket;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class ClientListener implements Runnable
{
	private Socket connection_socket = null;

	ClientListener(Socket socket)
	{
		this.connection_socket = socket;
	}

	public void run()
	{

		try
		{
			BufferedReader server_input = new BufferedReader(new InputStreamReader(connection_socket.getInputStream()));
			while (true)
			{

				String server_text = server_input.readLine();
				if (server_input != null)
				{
					System.out.println(server_text);
				}
				else
				{

					System.out.println("Closing connection for socket " + connection_socket);
					connection_socket.close();
					break;
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.toString());
		}
	}
}
