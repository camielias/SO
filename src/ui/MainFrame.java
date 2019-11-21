package ui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import objects.users.UserDB;
import ui.admin.AdminHomePanel;
import ui.admin.AdminTestPanel;

public class MainFrame {
	JFrame frame = new JFrame("SO");
	JPanel panelCont = new JPanel();
	CardLayout cl = new CardLayout();
	public UserDB userDB = new UserDB();
	public final static String login = "login";
	public final static String signup = "signup";
	public final static String adminhome = "adminhome";
	public final static String admintest = "admintest";

	JPanel loginPanel = (JPanel) new LoginPanel(this).frame.getContentPane();
	JPanel signupPanel = (JPanel) new SignUpPanel(this).frame.getContentPane();
	JPanel adminhomePanel = (JPanel) new AdminHomePanel(this).frame.getContentPane();
	JPanel admintestPanel = (JPanel) new AdminTestPanel(this).frame.getContentPane();

	public MainFrame() {
		System.out.println();
		panelCont.setLayout(cl);
		panelCont.add(loginPanel, login);
		panelCont.add(signupPanel, signup);
		panelCont.add(adminhomePanel, adminhome);
		panelCont.add(admintestPanel, admintest);
		show(login);
		frame.add(panelCont);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setBounds(100, 100, 800, 502);
		frame.setVisible(true);
	}

	public void update(JPanel updatedcomp, String constrainer) {
		panelCont.add(updatedcomp, constrainer);
	}

	public void show(String panel) {
		cl.show(panelCont, panel);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new MainFrame();
			}
		});
	}

}