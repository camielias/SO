package ui.admin;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import ui.MainFrame;

public class AdminTestPanel {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AdminTestPanel window = new AdminTestPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String AdminName;

	public JFrame frame;
	MainFrame parentframe;

	public AdminTestPanel() {
		initialize();
	}

	public AdminTestPanel(MainFrame mainframe) {
		parentframe = mainframe;
		initialize();
	}

	public AdminTestPanel(MainFrame mainframe, String username) {
		AdminName = username;
		parentframe = mainframe;
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

		JButton btnUsers = new JButton("Users");
		btnUsers.addActionListener(new ActionListener() {
			@Override
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
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnTests.setForeground(Color.WHITE);
		btnTests.setBackground(new Color(211, 27, 33));
		btnTests.setBounds(0, 68, 348, 44);
		panel.add(btnTests);

		JButton LogOutButton = new JButton("LogOut");
		LogOutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				parentframe.show(MainFrame.login);
			}
		});
		LogOutButton.setForeground(Color.WHITE);
		LogOutButton.setBackground(new Color(241, 57, 63));
		LogOutButton.setBounds(0, 293, 348, 44);
		panel.add(LogOutButton);

		Panel panel_2 = new Panel();
		panel_2.setBounds(354, 10, 380, 458);
		panel.add(panel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(354, 10, 380, 458);
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JScrollPane TestScroll = new JScrollPane();
		TestScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		TestScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		TestScroll.setBounds(346, 53, 452, 420);
		frame.getContentPane().add(TestScroll);

		JPanel TestPane = new JPanel();
		TestPane.setBackground(Color.DARK_GRAY);
		TestScroll.setViewportView(TestPane);
		TestPane.setLayout(new BoxLayout(TestPane, BoxLayout.Y_AXIS));

		TestPane.add(TestPanel());

		int separation = 30;
		TestPane.add(Box.createRigidArea(new Dimension(0, separation)));
		TestPane.add(TestPanel());
		TestPane.add(Box.createRigidArea(new Dimension(0, separation)));
		TestPane.add(TestPanel());
		TestPane.add(Box.createRigidArea(new Dimension(0, separation)));
		TestPane.add(TestPanel());
		TestPane.add(Box.createRigidArea(new Dimension(0, separation)));
		TestPane.add(TestPanel());
		TestPane.add(Box.createRigidArea(new Dimension(0, separation)));
		TestPane.add(TestPanel());

		JButton AddTestButton = new JButton("Add");
		AddTestButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		AddTestButton.setForeground(Color.WHITE);
		AddTestButton.setBackground(new Color(241, 57, 63));
		AddTestButton.setBounds(691, 12, 95, 32);
		frame.getContentPane().add(AddTestButton);

		JLabel lblListOfTest = new JLabel("List of test");
		lblListOfTest.setBounds(366, 21, 111, 15);
		frame.getContentPane().add(lblListOfTest);
		frame.setBounds(100, 100, 800, 502);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@SuppressWarnings("unchecked")
	public Component TestPanel() {

		JPanel Test1 = new JPanel();
		Test1.setBackground(SystemColor.controlHighlight);
		Test1.setMaximumSize(new Dimension(452, 222));
		Test1.setLayout(new BoxLayout(Test1, BoxLayout.Y_AXIS));

		Dimension bigtestpanel = new Dimension(452, 100);
		JPanel TestPanel = new JPanel();
		TestPanel.setBackground(SystemColor.window);
		Test1.add(TestPanel);
		TestPanel.setLayout(new BoxLayout(TestPanel, BoxLayout.X_AXIS));
		TestPanel.setMaximumSize(bigtestpanel);

		JPanel meta = new JPanel();
		meta.setBackground(SystemColor.controlHighlight);
		TestPanel.add(meta);
		meta.setLayout(new BoxLayout(meta, BoxLayout.Y_AXIS));

		JLabel lblTestNameLeeeeeeeeeenght = new JLabel("   Test Name leeeeeeeeeenght   ");
		lblTestNameLeeeeeeeeeenght.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTestNameLeeeeeeeeeenght.setBackground(Color.LIGHT_GRAY);
		lblTestNameLeeeeeeeeeenght.setPreferredSize(new Dimension(0, 20));
		meta.add(lblTestNameLeeeeeeeeeenght);

		JTextPane descriptionpanel = new JTextPane();
		descriptionpanel.setText("Description\nDescription\n");
		descriptionpanel.setEditable(false);
		descriptionpanel.setBackground(Color.LIGHT_GRAY);
		meta.add(descriptionpanel);

		JPanel TestOptions = new JPanel();
		TestOptions.setForeground(SystemColor.controlHighlight);
		TestOptions.setBackground(SystemColor.window);
		TestPanel.add(TestOptions);

		int testbuttonwidth = 90;
		int testbuttonheight = 10;
		JButton btnRemove = new JButton("Show");
		btnRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setBackground(new Color(241, 57, 63));

		btnRemove.setPreferredSize(new Dimension(testbuttonwidth, testbuttonheight));
		btnRemove.setMaximumSize(new Dimension(testbuttonwidth, 0));
		JButton EditTestButton = new JButton("Edit");
		EditTestButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		EditTestButton.setVerticalAlignment(SwingConstants.TOP);
		EditTestButton.setForeground(Color.WHITE);
		EditTestButton.setBackground(new Color(241, 57, 63));
		EditTestButton.setPreferredSize(new Dimension(testbuttonwidth, testbuttonheight));
		EditTestButton.setMaximumSize(new Dimension(testbuttonwidth, 0));
		JButton btnRemov = new JButton("Remove");
		btnRemov.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRemov.setForeground(Color.WHITE);
		btnRemov.setBackground(new Color(241, 57, 63));
		btnRemov.setPreferredSize(new Dimension(testbuttonwidth, testbuttonheight));
		btnRemov.setMaximumSize(new Dimension(testbuttonwidth, 0));
		TestOptions.setLayout(new GridLayout(0, 1, 0, 0));
		TestOptions.add(btnRemove);
		TestOptions.add(EditTestButton);
		TestOptions.add(btnRemov);

		JLabel lblTestTakers = new JLabel("Test takers");
		lblTestTakers.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTestTakers.setHorizontalAlignment(SwingConstants.CENTER);
		lblTestTakers.setForeground(SystemColor.infoText);
		lblTestTakers.setBackground(SystemColor.controlHighlight);
		lblTestTakers.setPreferredSize(new Dimension(0, 20));
		Test1.add(lblTestTakers);

		JPanel TakerPanel = new JPanel();
		Test1.add(TakerPanel);
		TakerPanel.setLayout(new BoxLayout(TakerPanel, BoxLayout.X_AXIS));
		TakerPanel.setMaximumSize(bigtestpanel);

		JList<String> list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			private static final long serialVersionUID = 4764823992980048399L;
			String[] values = new String[] { "Taker 1", "Taker 2Taker 1", "Taker 2Taker 1", "Taker 2Taker 1",
					"Taker 2Taker 1", "Taker 2Taker 1", "Taker 2Taker 1", "Taker 2Taker 1", "Taker 2Taker 1",
					"Taker 2Taker 1", "Taker 2" };

			@Override
			public Object getElementAt(int index) {
				return values[index];
			}

			@Override
			public int getSize() {
				return values.length;
			}
		});
		list.setVisibleRowCount(4);
		JScrollPane scrollPane = new JScrollPane(list);
		TakerPanel.add(scrollPane);

		JPanel panel_3 = new JPanel();
		TakerPanel.add(panel_3);
		panel_3.setForeground(SystemColor.controlHighlight);
		panel_3.setBackground(SystemColor.window);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		JButton button = new JButton("Show");
		button.setPreferredSize(new Dimension(90, 10));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 63));
		panel_3.add(button);

		JButton button_2 = new JButton("Remove");
		button_2.setPreferredSize(new Dimension(90, 10));
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(241, 57, 63));
		panel_3.add(button_2);

		return Test1;
	}
}
