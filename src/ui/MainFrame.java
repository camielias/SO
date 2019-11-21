package ui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import objects.users.UserDB;
import ui.admin.AdminHomePanel;
import ui.admin.AdminTestPanel;

public class MainFrame {
	public final static String adminhome = "adminhome";
	public final static String admintest = "admintest";
	public final static String login = "login";
	public final static String signup = "signup";
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MainFrame();
			}
		});
	}
	JPanel adminhomePanel = (JPanel) new AdminHomePanel(this).frame.getContentPane();
	JPanel admintestPanel = (JPanel) new AdminTestPanel(this).frame.getContentPane();
	CardLayout cl = new CardLayout();

	JFrame frame = new JFrame("SO");
	JPanel loginPanel = (JPanel) new LoginPanel(this).frame.getContentPane();
	JPanel panelCont = new JPanel();
	JPanel signupPanel = (JPanel) new SignUpPanel(this).frame.getContentPane();

	public UserDB userDB = new UserDB();

	public MainFrame() {
		System.out.println();
		panelCont.setLayout(cl);
		panelCont.add(loginPanel, login);
		panelCont.add(signupPanel, signup);
		panelCont.add(adminhomePanel, adminhome);
		panelCont.add(admintestPanel, admintest);
		show(login);
		frame.add(panelCont);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setBounds(100, 100, 800, 502);
		frame.setVisible(true);
	}

	public void show(String panel) {
		cl.show(panelCont, panel);
	}

	public void update(JPanel updatedcomp, String constrainer) {
		panelCont.add(updatedcomp, constrainer);
	}

}