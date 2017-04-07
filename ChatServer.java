import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class ChatServer
{

	private ArrayList<Socket> socket_list;
	private ArrayList<String> username_list;

	public ChatServer()
	{
		socket_list = new ArrayList<Socket>();
		username_list = new ArrayList<String>();
	}

	private void getConnection()
	{

		try
		{
			System.out.println("Waiting for client connections on port 7654.");
			ServerSocket server_socket = new ServerSocket(7654);

			while (true)
			{
        		Socket connection_socket = server_socket.accept();
				socket_list.add(connection_socket);

				BufferedReader client_input = new BufferedReader(
						new InputStreamReader(connection_socket.getInputStream()));
				String client_text = client_input.readLine();
				username_list.add(client_text);

				ClientHandler handler = new ClientHandler(connection_socket, this.socket_list, this.username_list);
				Thread thread = new Thread(handler);
				thread.start();
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args)
	{
		ChatServer server = new ChatServer();
		server.getConnection();
	}
}
