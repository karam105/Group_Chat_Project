package my.chatui;

import java.net.Socket;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class ChatClientListener implements Runnable
{
	private Socket connection_socket = null;

	ChatClientListener(Socket socket)
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
					jTextArea1.append(server_text);
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
