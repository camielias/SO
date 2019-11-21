package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import objects.users.User;
import ui.admin.AdminHomePanel;

public class LoginPanel {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LoginPanel window = new LoginPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	JFrame frame;
	/**
	 * Create the application.
	 * 
	 * @param mainFrame
	 */
	MainFrame parentframe;

	private JTextField PasswordField;

	private JTextField UsernameField;

	public LoginPanel() {
		initialize();
	}

	public LoginPanel(MainFrame mainframe) {
		parentframe = mainframe;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(new Color(231, 232, 236));
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 348, 473);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		;
		;

		JTextPane MessagePane = new JTextPane();
		MessagePane.setEditable(false);
		MessagePane.setForeground(Color.WHITE);
		MessagePane.setBackground(Color.DARK_GRAY);
		MessagePane.setBounds(0, 345, 348, 128);
		panel.add(MessagePane);
		MessagePane.setText("\n\tWelcome\n\n\n\tDBConnection: localhost");

		JLabel LeftPanelImage = new JLabel("");
		LeftPanelImage.setIcon(new ImageIcon(LoginPanel.class.getResource("/images/3006446190_9010cd334e_o.jpg")));
		LeftPanelImage.setBounds(0, -72, 348, 473);
		panel.add(LeftPanelImage);

		JButton SignUpButton = new JButton("SignUp");
		SignUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				parentframe.show(MainFrame.signup);
			}
		});
		SignUpButton.setForeground(Color.WHITE);
		SignUpButton.setBackground(new Color(241, 57, 63));
		SignUpButton.setBounds(589, 375, 142, 44);
		frame.getContentPane().add(SignUpButton);

		UsernameField = new JTextField();
		UsernameField.setBounds(360, 60, 416, 37);
		frame.getContentPane().add(UsernameField);
		UsernameField.setColumns(10);

		JButton LoginButton = new JButton("Login");
		LoginButton.setForeground(Color.WHITE);
		LoginButton.setBackground(new Color(241, 57, 63));
		LoginButton.setBounds(387, 375, 142, 44);
		frame.getContentPane().add(LoginButton);
		LoginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String Username = UsernameField.getText();
				if (parentframe.userDB.ValidateCredentials(Username, PasswordField.getText())) {
					int AcessLevel = parentframe.userDB.getAcessLevel(Username);
					if (AcessLevel == User.ADMINISTRATOR) {
						parentframe.update((JPanel) new AdminHomePanel(parentframe, Username).frame.getContentPane(),
								MainFrame.adminhome);
						parentframe.show(MainFrame.adminhome);
					} else if (AcessLevel == User.PATIENT) {
						parentframe.show(MainFrame.adminhome);
					}
				}
			}
		});

		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setBounds(360, 35, 102, 25);
		frame.getContentPane().add(UsernameLabel);

		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setBounds(360, 109, 102, 25);
		frame.getContentPane().add(PasswordLabel);

		PasswordField = new JTextField();
		PasswordField.setColumns(10);
		PasswordField.setBounds(360, 134, 416, 37);
		frame.getContentPane().add(PasswordField);
		frame.setBounds(100, 100, 800, 502);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
