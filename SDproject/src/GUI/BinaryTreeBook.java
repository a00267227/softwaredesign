package GUI;

import java.awt.EventQueue;
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
import entity.Node;
import entity.Person;

public class BinaryTreeBook extends JFrame {
	private Border lineBorder;
	private JPanel contentPane;
	private JTextField textField_04;
	private JTextField textField_02;
	private JTextField textField_03;
	private JTextField IdField;
	private JTable table_1;
	private BSTree tree = BSTree.getInstance();
	private JTextField amountField;
	private JTextField AvgAgeField;
	private JTextField insertStep;
	private int []keyArray = new int[20];
	private int count = 0;
	private JTextField idField2;
	private JTextField iteratorField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BinaryTreeBook frame = new BinaryTreeBook();
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
	public BinaryTreeBook() {
		
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
		panel.setBounds(497, 124, 400, 183);
		contentPane.add(panel);

		JLabel lblGender = new JLabel("gender");
		lblGender.setBounds(20, 124, 81, 25);
		panel.add(lblGender);

		textField_04 = new JTextField();
		textField_04.setColumns(10);
		textField_04.setBounds(154, 123, 121, 25);
		panel.add(textField_04);

		textField_02 = new JTextField();
		textField_02.setColumns(10);
		textField_02.setBounds(154, 53, 121, 25);
		panel.add(textField_02);

		JLabel label_3 = new JLabel("name");
		label_3.setBounds(20, 53, 81, 25);
		panel.add(label_3);

		textField_03 = new JTextField();
		textField_03.setColumns(10);
		textField_03.setBounds(154, 88, 121, 25);
		panel.add(textField_03);

		JLabel label_4 = new JLabel("age");
		label_4.setBounds(20, 88, 81, 25);
		panel.add(label_4);

		JButton button_2 = new JButton("Insert");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = IdField.getText();
				String name = textField_02.getText();
				String age = textField_03.getText();
				String gender = textField_04.getText();
				Person p = new Person(name, Integer.parseInt(age), gender.charAt(0));
				int steps = tree.insert(Integer.parseInt(id), name, Integer.parseInt(age), gender.charAt(0));
				insertStep.setText(""+steps);
				keyArray[count] = Integer.parseInt(id);
				count++;
				setTable();
			}
		});
		button_2.setBounds(287, 18, 92, 36);
		panel.add(button_2);

		/*tree.insert(0, "J.Smith", 22, 'M');
		tree.insert(1, "T.Black", 24, 'M');
		tree.insert(2, "M.Gray", 24, 'M');*/
		IdField = new JTextField();
		IdField.setColumns(10);
		IdField.setBounds(154, 18, 121, 25);
		panel.add(IdField);

		JLabel label_7 = new JLabel("id");
		label_7.setBounds(20, 24, 81, 25);
		panel.add(label_7);
		
		JLabel label = new JLabel("num of steps");
		label.setBounds(20, 152, 106, 25);
		panel.add(label);
		
		insertStep = new JTextField();
		insertStep.setBackground(SystemColor.menu);
		insertStep.setEditable(false);
		insertStep.setColumns(10);
		insertStep.setBounds(154, 152, 121, 25);
		panel.add(insertStep);
		setTable();

	}

	public void setTable() {
		Object[][] obj = new Object[tree.readNodeNum()][6];
		if(tree.readNodeNum() == 0) {
			
		}else {
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
		
		String[] columnNames = { "Id", "Name", "Gender", "Age" };
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
		scrollPane.setBounds(72, 35, 400, 450);
		contentPane.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder(lineBorder, "Iterator"));
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(497, 329, 400, 63);
		contentPane.add(panel_1);
		
		JButton btnCalculate = new JButton("calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amountField.setText(""+tree.readNodeNum());
			}
		});
		btnCalculate.setBounds(287, 18, 92, 36);
		panel_1.add(btnCalculate);
		
		amountField = new JTextField();
		amountField.setColumns(10);
		amountField.setBounds(154, 18, 121, 25);
		panel_1.add(amountField);
		
		JLabel lblAVG = new JLabel("detailNum");
		lblAVG.setBounds(20, 24, 92, 25);
		panel_1.add(lblAVG);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createTitledBorder(lineBorder, "Iterator"));
		panel_3.setBackground(SystemColor.menu);
		panel_3.setBounds(497, 422, 400, 63);
		contentPane.add(panel_3);
		
		JButton button_7 = new JButton("calculate");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AvgAgeField.setText(""+tree.inSearchAvgAge());
			}
		});
		button_7.setBounds(287, 14, 92, 36);
		panel_3.add(button_7);
		
		AvgAgeField = new JTextField();
		AvgAgeField.setColumns(10);
		AvgAgeField.setBounds(154, 18, 121, 25);
		panel_3.add(AvgAgeField);
		
		JLabel lblAvgage = new JLabel("avgAge");
		lblAvgage.setBounds(20, 24, 92, 25);
		panel_3.add(lblAvgage);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder(lineBorder, "Iterator"));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(497, 35, 400, 88);
		contentPane.add(panel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(20, 21, 81, 25);
		panel.add(lblId);
		
		idField2 = new JTextField();
		idField2.setBounds(155, 20, 121, 28);
		panel.add(idField2);
		idField2.setColumns(10);
		
		iteratorField = new JTextField();
		iteratorField.setEditable(false);
		iteratorField.setColumns(10);
		iteratorField.setBackground(SystemColor.menu);
		iteratorField.setBounds(155, 53, 121, 25);
		panel.add(iteratorField);
		
		JLabel label_1 = new JLabel("num of steps");
		label_1.setBounds(21, 53, 106, 25);
		panel.add(label_1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(idField2.getText());
				if(idField2.getText().length()!=0) {
					Node nd = tree.search(Integer.parseInt(idField2.getText()));
					Object[][] obj = new Object[tree.readNodeNum()][6];
								obj[0][0] = nd.readKey();
								obj[0][1] = nd.readName();
								obj[0][2] = nd.readGender();
								obj[0][3] = nd.readAge();
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
					scrollPane.setBorder(BorderFactory.createTitledBorder(lineBorder, "Binarry Tree Storage"));
					scrollPane.setBounds(72, 35, 400, 450);
					contentPane.add(scrollPane);
				}else {
					setTable();
				}
			}
		});
		btnSearch.setBounds(286, 22, 92, 36);
		panel.add(btnSearch);
		
	}
}