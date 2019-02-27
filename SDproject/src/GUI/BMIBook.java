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

import entity.BSTree;
import entity.Person;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BMIBook extends JFrame {
	private Border lineBorder;
	private JPanel contentPane;
	private JTextField textField_04;
	private JTextField textField_02;
	private JTextField textField_03;
	private JTextField textField_01;
	private JTable table_1;
	private BSTree tree = BSTree.getInstance();
	private int current = 0; // This is new
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_4;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMIBook frame = new BMIBook();
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
	public BMIBook() {
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
		panel.setBounds(497, 35, 400, 172);
		contentPane.add(panel);

		JLabel lblGender = new JLabel("gender");
		lblGender.setBounds(20, 123, 81, 25);
		panel.add(lblGender);

		textField_04 = new JTextField();
		textField_04.setColumns(10);
		textField_04.setBounds(82, 123, 121, 25);
		panel.add(textField_04);

		JButton button_1 = new JButton("Clear");
		button_1.setBounds(287, 123, 92, 36);
		panel.add(button_1);

		textField_02 = new JTextField();
		textField_02.setColumns(10);
		textField_02.setBounds(82, 53, 121, 25);
		panel.add(textField_02);

		JLabel label_3 = new JLabel("name");
		label_3.setBounds(20, 53, 81, 25);
		panel.add(label_3);

		textField_03 = new JTextField();
		textField_03.setColumns(10);
		textField_03.setBounds(82, 88, 121, 25);
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

				tree.insert(Integer.parseInt(id), name, Integer.parseInt(age), gender.charAt(0));
				setTable();
			}
		});
		button_2.setBounds(287, 18, 92, 36);
		panel.add(button_2);

		JButton button_3 = new JButton("Delete");
		button_3.setBounds(287, 53, 92, 36);
		panel.add(button_3);

		JButton button_4 = new JButton("Update");
		button_4.setBounds(287, 88, 92, 36);
		panel.add(button_4);

		tree.insert(0, "J.Smith", 22, 'M');
		tree.insert(1, "T.Black", 24, 'M');
		tree.insert(2, "M.Gray", 24, 'M');

		textField_01 = new JTextField();
		textField_01.setColumns(10);
		textField_01.setBounds(82, 18, 121, 25);
		panel.add(textField_01);

		JLabel label_7 = new JLabel("id");
		label_7.setBounds(20, 24, 81, 25);
		panel.add(label_7);
		setTable();

	}

	public void setTable() {
		Object[][] obj = new Object[tree.readNodeNum()][6];
		for (int i = 0; i < tree.readNodeNum(); i++) {
			for (int j = 0; j < 6; j++) {
				switch (j) {
				case 0:
					obj[i][j] = tree.search(i).readKey();
					break;
				case 1:
					obj[i][j] = tree.search(i).readName();
					break;
				case 2:
					obj[i][j] = tree.search(i).readGender();
					break;
				case 3:
					obj[i][j] = tree.search(i).readAge();
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
		scrollPane.setBorder(BorderFactory.createTitledBorder(lineBorder, "Binary Tree Storage"));
		scrollPane.setBounds(72, 35, 400, 450);
		contentPane.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder(lineBorder, "Iterator"));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(497, 230, 400, 116);
		contentPane.add(panel_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(154, 61, 121, 25);
		panel_1.add(textField_5);
		
		JLabel lblAvgAge = new JLabel("num of steps");
		lblAvgAge.setBounds(20, 61, 106, 25);
		panel_1.add(lblAvgAge);
		
		JButton btnCalculate = new JButton("calculate");
		btnCalculate.setBounds(287, 18, 92, 36);
		panel_1.add(btnCalculate);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(154, 18, 121, 25);
		panel_1.add(textField_7);
		
		JLabel lblAVG = new JLabel("sumNum");
		lblAVG.setBounds(20, 24, 92, 25);
		panel_1.add(lblAVG);
		
		JButton button_4 = new JButton("Clear");
		button_4.setBounds(287, 64, 92, 36);
		panel_1.add(button_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createTitledBorder(lineBorder, "Iterator"));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(497, 373, 400, 116);
		contentPane.add(panel_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(154, 61, 121, 25);
		panel_3.add(textField_4);
		
		JLabel label_8 = new JLabel("num of steps");
		label_8.setBounds(20, 61, 106, 25);
		panel_3.add(label_8);
		
		JButton button_7 = new JButton("calculate");
		button_7.setBounds(287, 18, 92, 36);
		panel_3.add(button_7);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(154, 18, 121, 25);
		panel_3.add(textField_6);
		
		JLabel lblAvgage = new JLabel("avgAge");
		lblAvgage.setBounds(20, 24, 92, 25);
		panel_3.add(lblAvgage);
		
		JButton button_8 = new JButton("Clear");
		button_8.setBounds(287, 64, 92, 36);
		panel_3.add(button_8);
	}
}