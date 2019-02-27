package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;

public class MainPage extends JFrame {
	private Border lineBorder;
	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTable table_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1117, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		initT1();
		initT2();
			
		
			
			
		
		
		
			
		
			
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(BorderFactory.createTitledBorder(lineBorder, "CRUD Actions"));
			panel.setBackground(SystemColor.menu);
			panel.setBounds(444, 269, 587, 176);
			contentPane.add(panel);
			
			JButton button_1 = new JButton("Clear");
			button_1.setBounds(373, 126, 169, 36);
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
			
			JLabel lblGender = new JLabel("gender");
			lblGender.setBounds(20, 88, 81, 25);
			panel.add(lblGender);
			
			JButton button_3 = new JButton("Delete");
			button_3.setBounds(373, 55, 169, 36);
			panel.add(button_3);
			
			JButton button_4 = new JButton("Update");
			button_4.setBounds(373, 91, 169, 36);
			panel.add(button_4);
			
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(82, 18, 252, 25);
			panel.add(textField_5);
			
			JLabel label_7 = new JLabel("id");
			label_7.setBounds(20, 24, 81, 25);
			panel.add(label_7);
			
			JLabel label = new JLabel("age");
			label.setBounds(20, 123, 81, 25);
			panel.add(label);
			
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(82, 123, 252, 25);
			panel.add(textField);
			
			JButton button_2 = new JButton("Insert");
			button_2.setBounds(373, 18, 169, 36);
			panel.add(button_2);
			
			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(BorderFactory.createTitledBorder(lineBorder, "CRUD Actions"));
			panel_2.setBackground(SystemColor.menu);
			panel_2.setBounds(22, 10, 411, 160);
			contentPane.add(panel_2);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(111, 61, 91, 25);
			panel_2.add(textField_1);
			
			JLabel label_1 = new JLabel("name");
			label_1.setBounds(49, 61, 81, 25);
			panel_2.add(label_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(274, 26, 91, 25);
			panel_2.add(textField_2);
			
			JLabel label_2 = new JLabel("gender");
			label_2.setBounds(226, 26, 81, 25);
			panel_2.add(label_2);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.setBounds(49, 96, 319, 36);
			panel_2.add(btnSearch);
			
			textField_12 = new JTextField();
			textField_12.setColumns(10);
			textField_12.setBounds(111, 26, 91, 25);
			panel_2.add(textField_12);
			
			JLabel label_4 = new JLabel("id");
			label_4.setBounds(49, 32, 81, 25);
			panel_2.add(label_4);
			
			JLabel label_5 = new JLabel("age");
			label_5.setBounds(226, 61, 81, 25);
			panel_2.add(label_5);
			
			textField_13 = new JTextField();
			textField_13.setColumns(10);
			textField_13.setBounds(274, 61, 91, 25);
			panel_2.add(textField_13);
			
	
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
				
				table_2 = new JTable(obj, columnNames);
				int colunms = table_2.getColumnCount();  
				
		        
		        
		        /* 
		         * 设置JTable自动调整列表的状态，此处设置为关闭 
		         */  
		          
		        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
		        
		    	TableColumn column = null;  
		        for(int i = 0; i < colunms; i++)  
		        {  
		            column = table_2.getColumnModel().getColumn(i);  
		            /*将每一列的默认宽度设置为100*/  
		            column.setPreferredWidth(100);  
		        }  
				
				JScrollPane scroll2 = new JScrollPane(table_2, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				
				scroll2.setBounds(36, 189, 400, 256);
				contentPane.add(scroll2);
	}
	
	public void initT1() {
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
	        
			JTable table_1 = new JTable(obj, columnNames);
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
	        
	}
	
	public void initT2() {
	
	}
}
