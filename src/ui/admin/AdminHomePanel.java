package ui.admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import ui.MainFrame;

public class AdminHomePanel {

	public JFrame frame;
	public JLabel UsernameLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHomePanel window = new AdminHomePanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	MainFrame parentframe;
	String AdminName;

	public AdminHomePanel(MainFrame mainframe, String username) {
		AdminName = username;
		parentframe = mainframe;
		initialize();
	}

	public AdminHomePanel(MainFrame mainframe) {
		parentframe = mainframe;
		initialize();
	}

	public AdminHomePanel() {
		initialize();
	}

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

		JButton btnUsers = new JButton("Users");
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JTextPane txtpnWelcomeDbconnectionLocalhost = new JTextPane();
		txtpnWelcomeDbconnectionLocalhost.setEditable(false);
		txtpnWelcomeDbconnectionLocalhost.setText("\n\tWelcome\n\n\n\tDBConnection: localhost");
		txtpnWelcomeDbconnectionLocalhost.setForeground(Color.WHITE);
		txtpnWelcomeDbconnectionLocalhost.setBackground(Color.DARK_GRAY);
		txtpnWelcomeDbconnectionLocalhost.setBounds(0, 345, 348, 128);
		panel.add(txtpnWelcomeDbconnectionLocalhost);
		btnUsers.setForeground(Color.WHITE);
		btnUsers.setBackground(new Color(241, 57, 63));
		btnUsers.setBounds(0, 12, 348, 44);
		panel.add(btnUsers);

		JButton btnTests = new JButton("Tests");
		btnTests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("ShowingTEST");
				parentframe.show(MainFrame.admintest);
			}
		});
		btnTests.setForeground(Color.WHITE);
		btnTests.setBackground(new Color(241, 57, 63));
		btnTests.setBounds(0, 68, 348, 44);
		panel.add(btnTests);

		JButton LogOutButton = new JButton("LogOut");
		LogOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parentframe.show(MainFrame.login);
			}
		});
		LogOutButton.setForeground(Color.WHITE);
		LogOutButton.setBackground(new Color(241, 57, 63));
		LogOutButton.setBounds(0, 293, 348, 44);
		panel.add(LogOutButton);

		JLabel WelcomeLabel = new JLabel("Welcome back");
		WelcomeLabel.setBounds(360, 35, 158, 25);
		frame.getContentPane().add(WelcomeLabel);

		UsernameLabel = new JLabel(AdminName);
		UsernameLabel.setBounds(360, 72, 102, 25);
		frame.getContentPane().add(UsernameLabel);
		frame.setBounds(100, 100, 800, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
