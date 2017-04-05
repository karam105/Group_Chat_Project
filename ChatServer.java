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

	public ChatServer()
	{
		socket_list = new ArrayList<Socket>();
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

				ClientHandler handler = new ClientHandler(connection_socket, this.socket_list);
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
