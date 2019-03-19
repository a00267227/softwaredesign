package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import entity.BSTree;
import entity.Iterator;
import entity.Node;

public class BTS extends JFrame {
	private Border lineBorder;
	private JPanel contentPane;
	private JTextField genderField;
	private JTextField nameField;
	private JTextField ageField;
	private JTextField idField;
	private JTextField stepsField;
	private JTextField detailNumField;
	private JTextField avgAgeField;
	private JTextField IDField;
	private JTable table_1;
	private BSTree tree = BSTree.getInstance();
	private int[] keyArray = new int[20];
	private int count = 0;
	private JTextField steps1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BTS frame = new BTS();
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
	public BTS() {
		lineBorder = BorderFactory.createEtchedBorder(15, Color.BLUE, Color.black);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder(lineBorder, "Search using key"));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(461, 23, 400, 109);
		contentPane.add(panel);

		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(IDField.getText());
				if (IDField.getText().length() != 0) {
					Node nd = tree.search(Integer.parseInt(IDField.getText()));
					int step = tree.searchSteps(Integer.parseInt(IDField.getText()));
					steps1.setText("" + step);
					Object[][] obj = new Object[tree.readNodeNum()][6];
					obj[0][0] = nd.readKey();
					obj[0][1] = nd.readName();
					obj[0][2] = nd.readGender();
					obj[0][3] = nd.readAge();
					String[] columnNames = { "Key", "Name", "Gender", "Age" };
					table_1 = new JTable(obj, columnNames);
					int colunms = table_1.getColumnCount();
					TableColumn column = null;
					for (int i = 0; i < colunms; i++) {
						column = table_1.getColumnModel().getColumn(i);
						column.setPreferredWidth(100);
					}
					JScrollPane scrollPane = new JScrollPane(table_1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
							ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					scrollPane.setBorder(BorderFactory.createTitledBorder(lineBorder, "Binarry Tree Storage"));
					scrollPane.setBounds(32, 23, 400, 450);
					contentPane.add(scrollPane);
				} else {
					setTable();
				}
			}

		});
		button.setBounds(287, 18, 92, 36);
		panel.add(button);

		JLabel lblId = new JLabel("key");
		lblId.setBounds(21, 24, 55, 25);
		panel.add(lblId);

		IDField = new JTextField();
		IDField.setColumns(10);
		IDField.setBounds(156, 26, 121, 25);
		panel.add(IDField);

		steps1 = new JTextField();
		steps1.setEditable(false);
		steps1.setColumns(10);
		steps1.setBackground(SystemColor.menu);
		steps1.setBounds(155, 59, 121, 25);
		panel.add(steps1);

		JLabel label = new JLabel("num of steps");
		label.setBounds(21, 59, 106, 25);
		panel.add(label);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder(lineBorder, "Insert Actions"));
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(461, 142, 400, 183);
		contentPane.add(panel_1);

		JLabel label_1 = new JLabel("gender");
		label_1.setBounds(20, 89, 81, 25);
		panel_1.add(label_1);

		genderField = new JTextField();
		genderField.setColumns(10);
		genderField.setBounds(154, 88, 121, 25);
		panel_1.add(genderField);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(154, 53, 121, 25);
		panel_1.add(nameField);

		JLabel label_2 = new JLabel("name");
		label_2.setBounds(20, 53, 81, 25);
		panel_1.add(label_2);

		ageField = new JTextField();
		ageField.setColumns(10);
		ageField.setBounds(154, 124, 121, 25);
		panel_1.add(ageField);

		JLabel label_3 = new JLabel("age");
		label_3.setBounds(20, 124, 81, 25);
		panel_1.add(label_3);

		JButton button_1 = new JButton("Insert");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idField.getText();
				String name = nameField.getText();
				String age = ageField.getText();
				String gender = genderField.getText();
				int steps = tree.insert(Integer.parseInt(id), name, Integer.parseInt(age), gender.charAt(0));
				stepsField.setText("" + steps);
				keyArray[count] = Integer.parseInt(id);
				count++;
				setTable();
			}
		});
		button_1.setBounds(287, 18, 92, 36);
		panel_1.add(button_1);

		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(154, 18, 121, 25);
		panel_1.add(idField);

		JLabel lblKey = new JLabel("key");
		lblKey.setBounds(20, 24, 81, 25);
		panel_1.add(lblKey);

		JLabel label_5 = new JLabel("num of steps");
		label_5.setBounds(20, 152, 106, 25);
		panel_1.add(label_5);

		stepsField = new JTextField();
		stepsField.setEditable(false);
		stepsField.setColumns(10);
		stepsField.setBackground(SystemColor.menu);
		stepsField.setBounds(154, 152, 121, 25);
		panel_1.add(stepsField);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createTitledBorder(lineBorder, "Iterator"));
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(32, 374, 829, 156);
		contentPane.add(panel_2);

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sum = 0;
				Iterator node = tree.iterator();
				while (node.hasNext()) {
					node.next();
					sum++;
				}
				tree.setCursor(-1);
				sum--;// head node
				detailNumField.setText("" + sum);
			}
		});
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblNodeamount = new JLabel("NodeAmount :");
		lblNodeamount.setFont(new Font("Meiryo", Font.PLAIN, 32));
		panel_2.add(lblNodeamount);

		detailNumField = new JTextField();
		detailNumField.setEditable(false);
		detailNumField.setColumns(10);
		panel_2.add(detailNumField);
		panel_2.add(btnCalculate);

		JLabel lblAvgageofnodes = new JLabel("AvgAge :");
		lblAvgageofnodes.setFont(new Font("Meiryo", Font.PLAIN, 32));
		panel_2.add(lblAvgageofnodes);

		avgAgeField = new JTextField();
		avgAgeField.setEditable(false);
		panel_2.add(avgAgeField);
		avgAgeField.setColumns(10);

		JButton btnCalculate_1 = new JButton("Calculate");
		panel_2.add(btnCalculate_1);
		btnCalculate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double sum = 0;
				double ageSum = 0;
				Iterator node = tree.iterator();
				while (node.hasNext()) {
					sum++;
					Node n = (Node) node.next();
					ageSum += n.readAge();
					System.out.println("age: " + n.readAge());
				}
				sum--;
				tree.setCursor(-1);
				avgAgeField.setText("" + ageSum / sum);
				System.out.println(ageSum);
				System.out.println(sum);
			}
		});
		setTable();

	}

	public void setTable() {
		Object[][] obj = new Object[tree.readNodeNum()][6];
		if (tree.readNodeNum() == 0) {

		} else {
			for (int i = 0; i < tree.readNodeNum(); i++) {
				for (int j = 0; j < 6; j++) {
					switch (j) {
					case 0:
						obj[i][j] = tree.search(keyArray[i]).readKey();
						break;
					case 1:
						obj[i][j] = tree.search(keyArray[i]).readName();
						break;
					case 2:
						obj[i][j] = tree.search(keyArray[i]).readGender();
						break;
					case 3:
						obj[i][j] = tree.search(keyArray[i]).readAge();
						break;
					}
				}
			}
		}

		String[] columnNames = { "Key", "Name", "Gender", "Age" };
		table_1 = new JTable(obj, columnNames);
		table_1.setBackground(SystemColor.menu);
		int colunms = table_1.getColumnCount();
		TableColumn column = null;
		for (int i = 0; i < colunms; i++) {
			column = table_1.getColumnModel().getColumn(i);
			column.setPreferredWidth(100);
		}
		JScrollPane scrollPane = new JScrollPane(table_1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(BorderFactory.createTitledBorder(lineBorder, "Binarry Tree Storage"));
		scrollPane.setBounds(32, 23, 400, 302);
		contentPane.add(scrollPane);
	}
}
