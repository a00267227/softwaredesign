package GUI;

import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		super("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Binary Tree Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.this.setVisible(false);
				BTS bts= new BTS(Menu.this);
				bts.setVisible(true);
			}
		});
		btnNewButton.setBounds(135, 58, 171, 62);
		contentPane.add(btnNewButton);
		
		JButton btnHashTableSearch = new JButton("Hash Table Search");
		btnHashTableSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.this.setVisible(false);
				HTS hts= new HTS(Menu.this);
				hts.setVisible(true);
			}
		});
		btnHashTableSearch.setBounds(135, 130, 171, 62);
		contentPane.add(btnHashTableSearch);
		
		JButton btnExist = new JButton("Exit");
		btnExist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExist.setBounds(135, 207, 171, 62);
		contentPane.add(btnExist);
	}
}
