package Main;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import java.util.Iterator;
import java.util.Vector;

public class Feature2_3 extends JFrame{
	private Word dictionary;
	private	ImageIcon background1_1=new ImageIcon("image\\background2_3.PNG");
	private	Icon t=new ImageIcon("image\\2_3_t.PNG");
	private	JButton button_t=new JButton(t);
	private JPanel panel1_1=new JPanel(){
	    @Override
	    protected void paintComponent(Graphics g){
	    	super.paintComponent(g);
	    	if(background1_1!=null){
	    		g.drawImage(background1_1.getImage(),0,0,getWidth(),getHeight(),null);
	    	}
	    }
	};
	private JPanel panel2=new JPanel(new BorderLayout());
	public Feature2_3(Word dictionary){
		this.dictionary = dictionary;
		button_t.setBounds(605,205,98,115);
		button_t.setActionCommand("2_3_t");
	    panel1_1.setLayout(null);
	    setTitle("Show History");
		setContentPane(panel1_1);
	    setLocation(200,50);
		setLayout(null);
		setSize(750,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
		panel1_1.add(button_t);
		panel1_1.add(panel2);
		panel2.setBounds(21,100,560,250);

	}
	public void out(){
		setVisible(false);
	}
	public void on(){

		String[]columnName = {"STT","Slang Word","Definition"};
		JTable table=new JTable(dictionary.dictionary(),columnName);
		JScrollPane sp=new JScrollPane(table,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(352);

		panel2.removeAll();
		panel2.add(sp,BorderLayout.CENTER);

		setVisible(true);
	}
	public void add(ActionListener obj){
		button_t.addActionListener(obj);
	}
	public void handle(){

	}

}


/*




*/