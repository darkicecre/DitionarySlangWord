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

public class Feature3_1 extends JFrame{
	private Word dictionary;
	private	ImageIcon background1_1=new ImageIcon("image\\background3_1.PNG");
	private	Icon xn=new ImageIcon("image\\3_1_dice.PNG");
	private	Icon t=new ImageIcon("image\\3_1_home.PNG");
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

	public Feature3_1(Word dictionary){
		this.dictionary = dictionary;
		button_xn.setBounds(135,254,174,84);
		button_t.setBounds(416,254,174,84);
		button_xn.setActionCommand("3_1_xn");
		button_t.setActionCommand("3_1_t");
	    panel1_1.setLayout(null);
	    setTitle("Random Slang");
		setContentPane(panel1_1);
	    setLocation(200,50);
		setLayout(null);
		setSize(750,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
	    panel1_1.add(button_xn);
	    panel1_1.add(button_t);
	}
	public void out(){
		setVisible(false);
	}
	public void on(){
		setVisible(true);
	}
	public void add(ActionListener obj){
		button_xn.addActionListener(obj);
		button_t.addActionListener(obj);
	}
	public void handle(){
		panel1_1.removeAll();
		panel1_1.add(button_t);
		panel1_1.add(button_xn);
		String random=dictionary.random();
		if(random.length()<=35){
			JLabel label=new JLabel(random,JLabel.CENTER);
			label.setOpaque(true);
			label.setBackground(Color.white);
			label.setForeground(Color.gray);
			label.setFont(new java.awt.Font("Tahoma", 1, 32));
			label.setBounds(0,120,750,50);
			panel1_1.add(label);
		}
		else{
			int i=25;
			for(i=25;i<random.length();i++){
				if(random.charAt(i)==' '){
					break;
				}
			}
			String random1=random.substring(0,i);
			String random2=random.substring(i,random.length());
			JLabel label1=new JLabel(random1,JLabel.CENTER);
			label1.setOpaque(true);
			label1.setBackground(Color.white);
			label1.setForeground(Color.gray);
			label1.setFont(new java.awt.Font("Tahoma", 1, 32));
			label1.setBounds(0,120,750,50);
			panel1_1.add(label1);
			JLabel label2=new JLabel(random2,JLabel.CENTER);
			label2.setOpaque(true);
			label2.setBackground(Color.white);
			label2.setForeground(Color.gray);
			label2.setFont(new java.awt.Font("Tahoma", 1, 32));
			label2.setBounds(0,170,750,50);
			panel1_1.add(label2);
		}
		panel1_1.setVisible(false);
		panel1_1.setVisible(true);
	}

}