package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;

import objects.users.User;

public class SignUpPanel {

	JFrame frame;
	private JTextField PasswordField;
	private JTextField PasswordConfirmationField;
	private JTextField UsernameField;
	private JComboBox<String> GenderBox;
	private JSpinner AgeSpinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPanel window = new SignUpPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	MainFrame parentframe;

	public SignUpPanel(MainFrame mainframe) {
		parentframe = mainframe;
		initialize();
	}

	public SignUpPanel() {
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

		JTextPane txtpnWelcomeDbconnectionLocalhost = new JTextPane();
		txtpnWelcomeDbconnectionLocalhost.setEditable(false);
		txtpnWelcomeDbconnectionLocalhost.setBounds(0, 345, 348, 128);
		panel.add(txtpnWelcomeDbconnectionLocalhost);
		txtpnWelcomeDbconnectionLocalhost.setText("\n\tWelcome\n\n\n\tDBConnection: localhost");
		txtpnWelcomeDbconnectionLocalhost.setForeground(Color.WHITE);
		txtpnWelcomeDbconnectionLocalhost.setBackground(Color.DARK_GRAY);

		JLabel LeftPanelImage = new JLabel("");
		LeftPanelImage.setIcon(new ImageIcon(SignUpPanel.class.getResource("/images/3006446190_9010cd334e_o.jpg")));
		LeftPanelImage.setBounds(0, -72, 348, 473);
		panel.add(LeftPanelImage);

		JButton SignUpButton = new JButton("SignUp");
		SignUpButton.setForeground(Color.WHITE);
		SignUpButton.setBackground(new Color(241, 57, 63));
		SignUpButton.setBounds(589, 375, 142, 44);
		frame.getContentPane().add(SignUpButton);
		SignUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				parentframe.userDB.AddObj(new User(UsernameField.getText(), PasswordField.getText(),
						(Integer) AgeSpinner.getValue(), (String) GenderBox.getSelectedItem()));
				parentframe.show(MainFrame.login);
			}
		});

		PasswordField = new JTextField();
		PasswordField.setBounds(360, 208, 416, 37);
		frame.getContentPane().add(PasswordField);
		PasswordField.setColumns(10);

		JButton LoginButton = new JButton("Login");
		LoginButton.setForeground(Color.WHITE);
		LoginButton.setBackground(new Color(241, 57, 63));
		LoginButton.setBounds(387, 375, 142, 44);
		frame.getContentPane().add(LoginButton);
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parentframe.show(MainFrame.login);
			}
		});

		JLabel UsernameLabel = new JLabel("Password");
		UsernameLabel.setBounds(360, 183, 102, 25);
		frame.getContentPane().add(UsernameLabel);

		JLabel PasswordLabel = new JLabel("Password Confirmation");
		PasswordLabel.setBounds(360, 257, 246, 25);
		frame.getContentPane().add(PasswordLabel);

		PasswordConfirmationField = new JTextField();
		PasswordConfirmationField.setColumns(10);
		PasswordConfirmationField.setBounds(360, 282, 416, 37);
		frame.getContentPane().add(PasswordConfirmationField);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(360, 109, 102, 25);
		frame.getContentPane().add(lblGender);

		UsernameField = new JTextField();
		UsernameField.setColumns(10);
		UsernameField.setBounds(360, 60, 416, 37);
		frame.getContentPane().add(UsernameField);

		JLabel label_1 = new JLabel("Username");
		label_1.setBounds(360, 35, 102, 25);
		frame.getContentPane().add(label_1);

		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(585, 109, 102, 25);
		frame.getContentPane().add(lblAge);

		GenderBox = new JComboBox<String>();
		GenderBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Male", "Female", "Other" }));
		GenderBox.setBounds(360, 134, 142, 37);
		frame.getContentPane().add(GenderBox);

		AgeSpinner = new JSpinner();
		AgeSpinner.setModel(new SpinnerNumberModel(0, 0, 110, 1));
		AgeSpinner.setBounds(585, 134, 60, 37);
		frame.getContentPane().add(AgeSpinner);
		frame.setBounds(100, 100, 800, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
