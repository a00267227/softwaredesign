package GUI;

import java.awt.Color;
import java.awt.Component;
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

import entity.HNode;
import entity.HashTable;
import entity.Iterator;
import entity.Node;
import entity.Person;

public class HTS extends JFrame {
	private HashTable htable = HashTable.getInstance();
	private JPanel contentPane;
	private JTextField genderField;
	private JTextField nameField;
	private JTextField ageField;
	private JTextField idField;
	private JTextField stepsField;
	private JTextField IDField;
	private JTextField steps1;
	private Border lineBorder;
	private JTextField detailNumField;
	private JTextField avgAgeField;
	private int[] keyArray = new int[20];
	private int count = 0;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HTS frame = new HTS();
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
	public HTS() {
		lineBorder = BorderFactory.createEtchedBorder(15, Color.RED, Color.black);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder(lineBorder, "Insert Actions"));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(439, 158, 400, 183);
		contentPane.add(panel);

		JLabel label = new JLabel("gender");
		label.setBounds(20, 82, 81, 25);
		panel.add(label);

		genderField = new JTextField();
		genderField.setColumns(10);
		genderField.setBounds(154, 81, 121, 25);
		panel.add(genderField);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(154, 53, 121, 25);
		panel.add(nameField);

		JLabel label_1 = new JLabel("name");
		label_1.setBounds(20, 53, 81, 25);
		panel.add(label_1);

		ageField = new JTextField();
		ageField.setColumns(10);
		ageField.setBounds(154, 117, 121, 25);
		panel.add(ageField);

		JLabel label_2 = new JLabel("age");
		label_2.setBounds(20, 117, 81, 25);
		panel.add(label_2);

		JButton button = new JButton("Insert");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idField.getText();
				String name = nameField.getText();
				String age = ageField.getText();
				String gender = genderField.getText();
				Person p = new Person(name, age, gender);
				htable.insert(Integer.parseInt(id), p);
				stepsField.setText("1");

				keyArray[count] = Integer.parseInt(id);
				count++;
				setTable();
			}
		});
		button.setBounds(287, 18, 92, 36);
		panel.add(button);

		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(154, 18, 121, 25);
		panel.add(idField);

		JLabel label_3 = new JLabel("key");
		label_3.setBounds(20, 24, 81, 25);
		panel.add(label_3);

		JLabel label_4 = new JLabel("num of steps");
		label_4.setBounds(20, 148, 106, 25);
		panel.add(label_4);

		stepsField = new JTextField();
		stepsField.setEditable(false);
		stepsField.setColumns(10);
		stepsField.setBackground(SystemColor.menu);
		stepsField.setBounds(154, 148, 121, 25);
		panel.add(stepsField);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder(lineBorder, "Search using key"));
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(439, 39, 400, 109);
		contentPane.add(panel_1);

		JButton button_1 = new JButton("Search");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HNode node = htable.search(Integer.parseInt(IDField.getText()));
				steps1.setText("1");
				Object[][] obj = new Object[htable.readNodeNum()][6];
				obj[0][0] = node.readKey();
				obj[0][1] = node.getPerson().getName();
				obj[0][2] = node.getPerson().getGender();
				obj[0][3] = node.getPerson().getAge();
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
				scrollPane.setBounds(10, 39, 400, 302);
				contentPane.add(scrollPane);
			}
		});
		button_1.setBounds(287, 18, 92, 36);
		panel_1.add(button_1);

		JLabel label_5 = new JLabel("key");
		label_5.setBounds(21, 24, 55, 25);
		panel_1.add(label_5);

		IDField = new JTextField();
		IDField.setColumns(10);
		IDField.setBounds(156, 26, 121, 25);
		panel_1.add(IDField);

		steps1 = new JTextField();
		steps1.setEditable(false);
		steps1.setColumns(10);
		steps1.setBackground(SystemColor.menu);
		steps1.setBounds(155, 59, 121, 25);
		panel_1.add(steps1);

		JLabel label_6 = new JLabel("num of steps");
		label_6.setBounds(21, 59, 106, 25);
		panel_1.add(label_6);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createTitledBorder(lineBorder, "Iterator"));
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(10, 363, 829, 156);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel label_7 = new JLabel("NodeAmount :");
		label_7.setFont(new Font("Meiryo", Font.PLAIN, 32));
		panel_2.add(label_7);

		detailNumField = new JTextField();
		detailNumField.setEditable(false);
		detailNumField.setColumns(10);
		panel_2.add(detailNumField);

		JButton button_2 = new JButton("Calculate");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sum = 0;
				Iterator node = htable.iterator();
				while (node.hasNext()) {
					node.next();
					sum++;
				}
				htable.setTemp(0);
				sum--;// head node
				detailNumField.setText("" + sum);
			}
		});
		panel_2.add(button_2);

		JLabel label_8 = new JLabel("AvgAge :");
		label_8.setFont(new Font("Meiryo", Font.PLAIN, 32));
		panel_2.add(label_8);

		avgAgeField = new JTextField();
		avgAgeField.setEditable(false);
		avgAgeField.setColumns(10);
		panel_2.add(avgAgeField);

		JButton button_3 = new JButton("Calculate");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double sum = 0;
				double ageSum = 0;
				Iterator node = htable.iterator();
				while (node.hasNext()) {
					sum++;
					HNode n = (HNode) node.next();
					if (n == null)
						break;
					ageSum += n.getPerson().getAge();
					System.out.println("age: " + n.getPerson().getAge());
				}
				sum--;
				htable.setTemp(0);
				avgAgeField.setText("" + ageSum / sum);
				System.out.println(ageSum);
				System.out.println(sum);
			}
		});
		panel_2.add(button_3);
		setTable();
	}

	public void setTable() {
		Object[][] obj = new Object[htable.readNodeNum()][6];
		if (htable.readNodeNum() == 0) {

		} else {
			for (int i = 0; i < htable.readNodeNum(); i++) {
				for (int j = 0; j < 6; j++) {
					switch (j) {
					case 0:
						obj[i][j] = htable.search(keyArray[i]).readKey();
						break;
					case 1:
						obj[i][j] = htable.search(keyArray[i]).getPerson().getName();
						break;
					case 2:
						obj[i][j] = htable.search(keyArray[i]).getPerson().getGender();
						break;
					case 3:
						obj[i][j] = htable.search(keyArray[i]).getPerson().getAge();
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
		scrollPane.setBorder(BorderFactory.createTitledBorder(lineBorder, "Hash Table Storage"));
		scrollPane.setBounds(10, 39, 400, 302);
		contentPane.add(scrollPane);
	}
}
