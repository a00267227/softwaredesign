
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*; //This is new

class MyFrame2 extends JFrame implements ActionListener{
	private JLabel l0 = new JLabel("Person");
	private JLabel l1 = new JLabel("ID");
	private JLabel l2 = new JLabel("Name");
	private JLabel l3 = new JLabel("Age");
	private JTextField t1=new JTextField("",9);
	private JTextField t2=new JTextField("",9);
	private JTextField t3=new JTextField("",9);

	private JButton b1=new JButton("Insert");
	private JButton b2=new JButton("Search");
	private JButton b3=new JButton("Close");
	private JPanel p1=new JPanel();
	private BSTree tree=new BSTree();//This is new
	private int current=0; //This is new

//CONSTRUCTOR
	public MyFrame2(String s){
		super(s);
		tree.insert(1,"J.Smith",22);
		tree.insert(2,"T.Black",24);
		tree.insert(3,"M.Gray",24);
		Container content=getContentPane();
		content.setLayout(new FlowLayout());
		Font f=new Font("TimesRoman", Font.BOLD,20);
		p1.setLayout(new GridLayout(4,2));
		l0.setFont(f);  l1.setFont(f);
		content.add(l0);
		p1.add(l1); p1.add(t1);
		p1.add(l2); p1.add(t2);
		p1.add(l3); p1.add(t3);
		p1.add(b1); p1.add(b2);
		content.add(p1);content.add(b3);
		b1.addActionListener(this);
		b2.addActionListener(this);b3.addActionListener(this);
		   //Horiz , Vert
		setSize(250,220);    setVisible(true);}



	public void actionPerformed(ActionEvent e){

	  	Object target=e.getSource();
	 	if (target==b1)
	 		{    int id=Integer.parseInt(t1.getText());
	 		     String nm= t2.getText();
	 		     int ag=Integer.parseInt(t3.getText());
	 		     tree.insert(id, nm, ag);
	         }

	     if (target==b2)
	     	{
	    	 int id=Integer.parseInt(t1.getText());
	    	 Node temp=tree.search(id);
	    	 if (temp==null){  t2.setText("Unknown");
	    	                   t3.setText("");}
	    	 else       { t1.setText(""+temp.readKey());
	    	              t2.setText(""+temp.readName());
	    	              t3.setText(""+temp.readAge());
	    	            }
	     	}
	     if (target==b3)
	     	{
	    	this.setVisible(false);
	     	}
          }
}

