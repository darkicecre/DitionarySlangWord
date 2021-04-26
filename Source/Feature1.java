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

public class Feature1 extends JFrame{
	private Word dictionary;
	private	ImageIcon background1_1=new ImageIcon("image\\background1_1.PNG");
	private	Icon xn=new ImageIcon("image\\1_1_xn.PNG");
	private	Icon t=new ImageIcon("image\\1_1_t.PNG");
	private	JButton button_xn=new JButton(xn);
	private	JButton button_t=new JButton(t);
	private	JTextField text=new JTextField();
	private JPanel panel1_1=new JPanel(){
	    	@Override
	    	protected void paintComponent(Graphics g){
	    		super.paintComponent(g);
	    		if(background1_1!=null){
	    			g.drawImage(background1_1.getImage(),0,0,getWidth(),getHeight(),null);
	    		}
	    	}
	    };
	private JPanel panel2 = new JPanel(new BorderLayout());
	public Feature1(Word dictionary){
		this.dictionary = dictionary;
		button_xn.setBounds(470,185,100,150);
		button_t.setBounds(600,185,100,150);
		button_xn.setActionCommand("1_1_xn");
		button_t.setActionCommand("1_1_t");
	    panel1_1.setLayout(null);
	    setTitle("Search By Slang");
		setContentPane(panel1_1);
	    setLocation(200,50);
		setLayout(null);
		setSize(750,400);
		JPanel panel =new JPanel(new BorderLayout());
		panel.setBounds(470,125,230,40);
		panel.add(text);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
		panel1_1.add(panel);
		panel1_1.add(button_xn);
		panel1_1.add(button_t);

		panel2.setBounds(30,130,400,200);
		panel1_1.add(panel2);
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
		String s=dictionary.find(text.getText());
		if(s==null){
			s="404 NOT FOUND";
		}
		int i=0;
		int index=0;
		Vector<String> list=new Vector<>();
		for(i=0;i<s.length();i++){
			if(s.charAt(i)=='|'||s.charAt(i)==','||s.charAt(i)=='/'){
				list.add(s.substring(index,i));
				index=i+2;
			}
		}
		list.add(s.substring(index,s.length()));
		Iterator<String> iterate = list.iterator();
		String [][]result=new String[list.size()][1];
        index=0;
        while(iterate.hasNext()) {
        	result[index][0]=iterate.next();
            index=index+1;
        }
		String[]columnName = {"Definition"};
		
		JTable table=new JTable(result,columnName);

		JScrollPane sp=new JScrollPane(table,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel2.removeAll();
		panel2.add(sp,BorderLayout.CENTER);
		panel2.setVisible(false);
		panel2.setVisible(true);

		if(text.getText().length()>0){
			Date date=new Date();
			String history=date.getDateTime()+" "+text.getText()+"`"+s;
			SaveData save=new SaveData(dictionary);
			save.saveHistory(history);
		}
	}

}