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
public class MenuCase2 extends JFrame{
	private Word dictionary;
	public JButton button2_Home=new JButton();Icon add=new ImageIcon("image\\Add.PNG");
	private	Icon edit=new ImageIcon("image\\Edit_2.PNG");
	private	Icon delete=new ImageIcon("image\\Delete.PNG");
	private	Icon reset=new ImageIcon("image\\Reset.PNG");
	private	Icon show=new ImageIcon("image\\Show.PNG");
	private	Icon home=new ImageIcon("image\\Home.PNG");
	private	ImageIcon background2=new ImageIcon("image\\background2.PNG");
	private	JButton button2_Add=new JButton(add);
	private	JButton button2_Edit=new JButton(edit);
	private	JButton button2_Reset=new JButton(reset);
	private	JButton button2_Delete=new JButton(delete);
	private	JButton button2_Show=new JButton(show);
	public MenuCase2(){
	}
	public MenuCase2(Word dictionary){
		this.dictionary=dictionary;
		
		button2_Home=new JButton(home);
		button2_Add.setBounds(20,150,221,75);
		button2_Edit.setBounds(260,150,221,75);
		button2_Show.setBounds(500,150,221,75);
		button2_Delete.setBounds(20,250,221,75);
		button2_Reset.setBounds(260,250,221,75);
		button2_Home.setBounds(500,250,221,75);
		button2_Add.setActionCommand("2_1");
		button2_Edit.setActionCommand("2_2");
		button2_Delete.setActionCommand("2_4");
		button2_Show.setActionCommand("2_3");
		button2_Reset.setActionCommand("2_5");
		button2_Home.setActionCommand("2_6");
	    JPanel panelEdit=new JPanel(){
	    	@Override
	    	protected void paintComponent(Graphics g){
	    		super.paintComponent(g);
	    		if(background2!=null){
	    			g.drawImage(background2.getImage(),0,0,getWidth(),getHeight(),null);
	    		}
	    	}
	    };
	    panelEdit.setLayout(null);
	    panelEdit.add(button2_Add);
	    panelEdit.add(button2_Edit);
	    panelEdit.add(button2_Delete);
	    panelEdit.add(button2_Reset);
	    panelEdit.add(button2_Show);
	    panelEdit.add(button2_Home);
	    setLayout(null);
	    setTitle("Edit Dictionary");

	    setResizable(false);
	    setContentPane(panelEdit);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    //setLocationByPlatform(true);
	    setLocation(200,50);
	    setSize(750,400);
	    setVisible(false);/*
	    button2_Home.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent event){
	    		setVisible(false);
	    		Menu menu=new Menu(dictionary);
	    	}
	    });*/
	}

	public void out(){
		setVisible(false);
	}
	public void on(){
		setVisible(true);
	}
	public void add(ActionListener obj){
		button2_Home.addActionListener(obj);
		button2_Show.addActionListener(obj);
		button2_Reset.addActionListener(obj);
		button2_Delete.addActionListener(obj);
		button2_Add.addActionListener(obj);
		button2_Edit.addActionListener(obj);
	}
	public static void main(String[]args){
	}
}