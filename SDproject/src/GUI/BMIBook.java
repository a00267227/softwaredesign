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

public class BMIBook extends JFrame {
	private Border lineBorder;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table_1;
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
		panel.setBounds(470, 149, 575, 300);
		contentPane.add(panel);
		
		JLabel label = new JLabel("BMI");
		label.setBounds(20, 193, 81, 25);
		panel.add(label);
		
		JLabel label_1 = new JLabel("weight");
		label_1.setBounds(20, 123, 81, 25);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("height");
		label_2.setBounds(20, 158, 66, 25);
		panel.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(82, 158, 252, 25);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(82, 123, 252, 25);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(82, 191, 252, 30);
		panel.add(textField_2);
		
		JButton button = new JButton("Caculate");
		button.setBounds(10, 231, 324, 43);
		panel.add(button);
		
		JButton button_1 = new JButton("Clear");
		button_1.setBounds(391, 231, 174, 36);
		panel.add(button_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(82, 53, 252, 25);
		panel.add(textField_3);
		
		JLabel label_3 = new JLabel("name");
		label_3.setBounds(20, 53, 81, 25);
		panel.add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(82, 88, 252, 25);
		panel.add(textField_4);
		
		JLabel label_4 = new JLabel("age");
		label_4.setBounds(20, 88, 81, 25);
		panel.add(label_4);
		
		JButton button_2 = new JButton("Insert");
		button_2.setBounds(391, 24, 174, 36);
		panel.add(button_2);
		
		JButton button_3 = new JButton("Delete");
		button_3.setBounds(391, 85, 174, 36);
		panel.add(button_3);
		
		JButton button_4 = new JButton("Update");
		button_4.setBounds(391, 157, 174, 36);
		panel.add(button_4);
		
		JLabel label_5 = new JLabel("kg");
		label_5.setBounds(344, 109, 81, 25);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("m");
		label_6.setBounds(344, 146, 81, 25);
		panel.add(label_6);
		String[] columnNames =  
	        { "Id", "Name", "Gender", "Age" };  
	 
	 Object[][] obj = new Object[2][6];  
        for (int i = 0; i < 2; i++)  
        {  
            for (int j = 0; j < 6; j++)  
            {  
                switch (j)  
                {  
                case 0:  
                    obj[i][j] = "赵匡义";  
                    break;  
                case 1:  
                    obj[i][j] = "123215";  
                    break;  
                case 2:  
                    obj[i][j] = "男";  
                    break;  
                case 3:  
                    obj[i][j] = "两年";  
                    break;  
                }  
            }  
        }
        
		table_1 = new JTable(obj, columnNames);
		int colunms = table_1.getColumnCount();  
        
        /* 
         * 设置JTable自动调整列表的状态，此处设置为关闭 
         */  
          
        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
        
    	TableColumn column = null;  
        for(int i = 0; i < colunms; i++)  
        {  
            column = table_1.getColumnModel().getColumn(i);  
            /*将每一列的默认宽度设置为100*/  
            column.setPreferredWidth(100);  
        }  
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(82, 18, 252, 25);
		panel.add(textField_5);
		
		JLabel label_7 = new JLabel("id");
		label_7.setBounds(20, 24, 81, 25);
		panel.add(label_7);
		
		JScrollPane scrollPane = new JScrollPane(table_1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(40, 159, 400, 256);
		contentPane.add(scrollPane);
	}

}
