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
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class Feature2 extends JFrame{
	private Word dictionary;
	private	ImageIcon background1_2=new ImageIcon("image\\background1_2.PNG");
	private	Icon xn=new ImageIcon("image\\1_2_xn.PNG");
	private	Icon t=new ImageIcon("image\\1_2_t.PNG");
	private	JButton button_xn=new JButton(xn);
	private	JButton button_t=new JButton(t);
	private	JTextField text=new JTextField();
	private JPanel panel1_2=new JPanel(){
	    	@Override
	    	protected void paintComponent(Graphics g){
	    		super.paintComponent(g);
	    		if(background1_2!=null){
	    			g.drawImage(background1_2.getImage(),0,0,getWidth(),getHeight(),null);
	    		}
	    	}
	    };
	private JPanel panel2 = new JPanel(new BorderLayout());
	public Feature2(Word dictionary){
		this.dictionary = dictionary;
		button_xn.setBounds(470,185,100,150);
		button_t.setBounds(600,185,100,150);
		button_xn.setActionCommand("1_2_xn");
		button_t.setActionCommand("1_2_t");
	    panel1_2.setLayout(null);
	    setTitle("Search By Definition");
		setContentPane(panel1_2);
	    setLocation(200,50);
		setLayout(null);
		setSize(750,400);
		JPanel panel =new JPanel(new BorderLayout());
		panel.setBounds(470,125,230,40);
		panel.add(text);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
		panel1_2.add(panel);
		panel1_2.add(button_xn);
		panel1_2.add(button_t);

		panel2.setBounds(30,130,400,200);
		panel1_2.add(panel2);
	}
	public void out(){
		setVisible(false);
	}
	public void on(){
		setVisible(true);
	}
	public void add(ActionListener obj){
		button_t.addActionListener(obj);
		button_xn.addActionListener(obj);
	}
	public void handle(){
		if(text.getText().length()!=0){
			List<String> s=dictionary.findD(text.getText());
			if(s.size()==0){
				s.add("404 NOT FOUND");
			}
			String[][] res=new String[s.size()][1];
			Date date=new Date();
			String result=date.getDateTime()+" "+text.getText()+"`";
			ListIterator<String> itr = s.listIterator();
			int index=0;
			while (itr.hasNext()) {
				res[index][0]=itr.next();
				result=result+res[index][0]+"  ";
				index=index+1;
			}
			String[]columnName = {"Slang Word"};
			JTable table=new JTable(res,columnName);
			JScrollPane sp=new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			panel2.removeAll();
			panel2.add(sp,BorderLayout.CENTER);
			panel2.setVisible(false);
			panel2.setVisible(true);
			SaveData save=new SaveData(dictionary);
			save.saveHistory(result);
		
		}
	}

}