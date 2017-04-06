//Import packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Main class
public class GUI{
	//Declare variables
	static JFrame frame1;
	static Container pane;
	static JButton btnConnect, btnDisconnect;
	static JLabel lblServer, lblUsername, lblPassword, lblPort;
	static JTextField txtServer, txtUsername, txtPassword, txtPort;
	static Insets insets;

	public static void main (String args[]){
		//Set Look and Feel
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch (ClassNotFoundException e) {}
		catch (InstantiationException e) {}
		catch (IllegalAccessException e) {}
		catch (UnsupportedLookAndFeelException e) {}

		//Create the frame
		frame1 = new JFrame ("Sample GUI Application");
		frame1.setSize (850,500);
		pane = frame1.getContentPane();
		insets = pane.getInsets();
		pane.setLayout (null);

		//Create controls
		btnConnect = new JButton ("Connect");
		btnDisconnect = new JButton ("Disconnect");
		lblServer = new JLabel ("Remote host:");
		lblUsername = new JLabel ("Username:");
		lblPassword = new JLabel ("Password:");
		lblPort = new JLabel ("Port #:");
		txtServer = new JTextField (10);
		txtUsername = new JTextField  (10);
		txtPassword = new JTextField  (10);
		txtPort = new JTextField  (5);

		//Add all components to panel
		pane.add (lblServer);
		pane.add (lblUsername);
		pane.add (lblPassword);
		pane.add (lblPort);
		pane.add (txtServer);
		pane.add (txtUsername);
		pane.add (txtPassword);
		pane.add (txtPort);
		pane.add (btnConnect);
		pane.add (btnDisconnect);

		//Place all components
		lblServer.setBounds (insets.left + 10, insets.top + 10, lblServer.getPreferredSize().width, lblServer.getPreferredSize().height);
		txtServer.setBounds (lblServer.getX() + lblServer.getWidth() + 10, insets.top + 10, txtServer.getPreferredSize().width, txtServer.getPreferredSize().height);
		lblUsername.setBounds (txtServer.getX() + txtServer.getWidth() + 10, insets.top + 10, lblUsername.getPreferredSize().width, lblUsername.getPreferredSize().height);
		txtUsername.setBounds (lblUsername.getX() + lblUsername.getWidth() + 10, insets.top + 10, txtUsername.getPreferredSize().width, txtUsername.getPreferredSize().height);
		lblPassword.setBounds (txtUsername.getX() + txtUsername.getWidth() + 10, insets.top + 10, lblPassword.getPreferredSize().width, lblPassword.getPreferredSize().height);
		txtPassword.setBounds (lblPassword.getX() + lblPassword.getWidth() + 10, insets.top + 10, txtPassword.getPreferredSize().width, txtPassword.getPreferredSize().height);
		lblPort.setBounds (txtPassword.getX() + txtPassword.getWidth() + 10, insets.top + 10, lblPort.getPreferredSize().width, lblPort.getPreferredSize().height);
		txtPort.setBounds (lblPort.getX() + lblPort.getWidth() + 10, insets.top + 10, txtPort.getPreferredSize().width, txtPort.getPreferredSize().height);
		btnConnect.setBounds (txtPort.getX() + txtPort.getWidth() + 10, insets.top + 10, btnConnect.getPreferredSize().width, btnConnect.getPreferredSize().height);
		btnDisconnect.setBounds (insets.left + 15, lblServer.getY() + lblServer.getHeight() + 10, btnDisconnect.getPreferredSize().width, btnDisconnect.getPreferredSize().height);

		//Set frame visible
		frame1.setVisible (true);

		//Button's action
		btnConnect.addActionListener(new btnConnectAction()); //Register action
	}

	public static class btnConnectAction implements ActionListener{
		public void actionPerformed (ActionEvent e){
			System.out.println("You entered "+txtUsername.getText());
		}
	}
}
