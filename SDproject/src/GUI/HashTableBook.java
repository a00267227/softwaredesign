package GUI;

import java.awt.EventQueue;
import java.awt.SystemColor;

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

import entity.HashTable;
import entity.Person;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HashTableBook extends JFrame {
	private Border lineBorder;
	private JPanel contentPane;
	private JTextField textField_04;
	private JTextField textField_02;
	private JTextField textField_03;
	private JTextField textField_01;
	private JTable table_1;
	private HashTable htable = HashTable.getInstance();
	private int current = 0; // This is new

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HashTableBook frame = new HashTableBook();
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
	public HashTableBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1089, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder(lineBorder, "CRUD Actions"));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(470, 149, 575, 266);
		contentPane.add(panel);

		JLabel lblGender = new JLabel("gender");
		lblGender.setBounds(20, 123, 81, 25);
		panel.add(lblGender);

		textField_04 = new JTextField();
		textField_04.setColumns(10);
		textField_04.setBounds(82, 123, 252, 25);
		panel.add(textField_04);

		JButton button_1 = new JButton("Clear");
		button_1.setBounds(391, 231, 174, 36);
		panel.add(button_1);

		textField_02 = new JTextField();
		textField_02.setColumns(10);
		textField_02.setBounds(82, 53, 252, 25);
		panel.add(textField_02);

		JLabel label_3 = new JLabel("name");
		label_3.setBounds(20, 53, 81, 25);
		panel.add(label_3);

		textField_03 = new JTextField();
		textField_03.setColumns(10);
		textField_03.setBounds(82, 88, 252, 25);
		panel.add(textField_03);

		JLabel label_4 = new JLabel("age");
		label_4.setBounds(20, 88, 81, 25);
		panel.add(label_4);

		JButton button_2 = new JButton("Insert");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField_01.getText();
				String name = textField_02.getText();
				String age = textField_03.getText();
				String gender = textField_04.getText();
				Person p = new Person(name, Integer.parseInt(age), gender.charAt(0));
				htable.insert(Integer.parseInt(id), p);
				setTable();
			}
		});
		button_2.setBounds(391, 24, 174, 36);
		panel.add(button_2);

		JButton button_3 = new JButton("Delete");
		button_3.setBounds(391, 85, 174, 36);
		panel.add(button_3);

		JButton button_4 = new JButton("Update");
		button_4.setBounds(391, 157, 174, 36);
		panel.add(button_4);

		Person p1 = new Person("J.Smith", 22, 'M');
		Person p3 = new Person("J.Smith", 22, 'M');
		Person p2 = new Person("J.Smith", 22, 'M');

		htable.insert(0, p1);
		htable.insert(1, p2);
		htable.insert(2, p3);

		textField_01 = new JTextField();
		textField_01.setColumns(10);
		textField_01.setBounds(82, 18, 252, 25);
		panel.add(textField_01);

		JLabel label_7 = new JLabel("id");
		label_7.setBounds(20, 24, 81, 25);
		panel.add(label_7);
		setTable();

	}

	public void setTable() {
		Object[][] obj = new Object[htable.readNodeNum()][6];
		for (int i = 0; i < htable.readNodeNum(); i++) {
			for (int j = 0; j < 6; j++) {
				switch (j) {
				case 0:
					obj[i][j] = htable.search(i).readKey();
					break;
				case 1:
					obj[i][j] = htable.search(i).getPerson().getName();
					break;
				case 2:
					obj[i][j] = htable.search(i).getPerson().getAge();
					break;
				case 3:
					obj[i][j] = htable.search(i).getPerson().getGender();
					break;
				}
			}
		}
		String[] columnNames = { "Id", "Name", "Gender", "Age" };
		table_1 = new JTable(obj, columnNames);
		int colunms = table_1.getColumnCount();
		TableColumn column = null;
		for (int i = 0; i < colunms; i++) {
			column = table_1.getColumnModel().getColumn(i);
			column.setPreferredWidth(100);
		}
		JScrollPane scrollPane = new JScrollPane(table_1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(40, 159, 400, 256);
		contentPane.add(scrollPane);
	}

}