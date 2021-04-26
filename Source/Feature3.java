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

public class Feature3 extends JFrame{
	private	ImageIcon background1_1=new ImageIcon("image\\background1_3.PNG");
	private	Icon xn=new ImageIcon("image\\1_3_dl.PNG");
	private	Icon t=new ImageIcon("image\\1_3_t.PNG");
	private	JButton button_xn=new JButton(xn);
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
	private JPanel panel2 = new JPanel(new BorderLayout());
	public Feature3(){
		button_xn.setBounds(473,185,100,150);
		button_t.setBounds(600,185,100,150);
		button_xn.setActionCommand("1_3_xn");
		button_t.setActionCommand("1_3_t");
	    panel1_1.setLayout(null);
	    setTitle("Search By Slang");
		setContentPane(panel1_1);
	    setLocation(200,50);
		setLayout(null);
		setSize(750,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
		panel1_1.add(button_xn);
		panel1_1.add(button_t);
		panel2.setBounds(28,130,428,200);
		panel1_1.add(panel2);
	}
	public void out(){
		setVisible(false);
	}
	public void on(String history){
		handle(history);
		setVisible(true);
	}
	public void add(ActionListener obj){
		button_t.addActionListener(obj);
		button_xn.addActionListener(obj);
	}
	public void handle(String history){
		int i=0;
		int index=0;
		boolean is_N=true;
		boolean is_D=false;
		List<String> date=new ArrayList<String>();
		List<String> time=new ArrayList<String>();
		List<String> wordS=new ArrayList<String>();
		List<String> wordK=new ArrayList<String>();
		for(i=0;i<history.length();i++){
			if(history.charAt(i)==' '){
				if(is_N){
					date.add(history.substring(index,i));
					is_N=false;
					is_D=true;
					index=i+1;
				}
				else if(is_D){
					time.add(history.substring(index,i));
					is_D=false;
					index=i+1;
				}
			}
			else if(history.charAt(i)=='`'){
				wordS.add(history.substring(index,i));
				index=i+1;
			}
			else if(history.charAt(i)=='\n'){
				is_N=true;
				wordK.add(history.substring(index,i));
				index=i+1;
			}
		}
		wordK.add(history.substring(index,history.length()));
		String[][] res=new String[date.size()][4];
		ListIterator<String> itrDate = date.listIterator();
		ListIterator<String> itrTime = time.listIterator();
		ListIterator<String> itrWordS = wordS.listIterator();
		ListIterator<String> itrWordK = wordK.listIterator();
		index=date.size()-1;
		while (itrDate.hasNext()) {
			res[index][0]=itrDate.next();
			index=index-1;
		}
		index=date.size()-1;
		while (itrTime.hasNext()) {
			res[index][1]=itrTime.next();
			index=index-1;
		}
		index=date.size()-1;
		while (itrWordS.hasNext()) {
			res[index][2]=itrWordS.next();
			index=index-1;
		}
		index=date.size()-1;
		while (itrWordK.hasNext()) {
			res[index][3]=itrWordK.next();
			index=index-1;
		}
		String[]columnName = {"Date","Time","Word Searched","Key"};
		JTable table=new JTable(res,columnName);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(114);
		table.getColumnModel().getColumn(1).setPreferredWidth(51);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(155);
		JScrollPane sp=new JScrollPane(table,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel2.removeAll();
		panel2.add(sp,BorderLayout.CENTER);
		panel2.setVisible(false);
		panel2.setVisible(true);
		
	}

}