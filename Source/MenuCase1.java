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

public class MenuCase1 extends JFrame{
	private JButton button1_Home;
	private	Icon bySlang=new ImageIcon("image\\BySlang.PNG");
	private	Icon byDefinition=new ImageIcon("image\\ByDefinition.PNG");
	private	Icon historySearch=new ImageIcon("image\\HistorySearch.PNG");
	private	Icon backHome=new ImageIcon("image\\BackHome.PNG");
	private	ImageIcon background1=new ImageIcon("image\\background1.PNG");
    private JButton button1_Slang = new JButton(bySlang);
    private JButton button1_Definition = new JButton(byDefinition);
    private JButton button1_History = new JButton(historySearch);
	public MenuCase1(){
      	button1_Home = new JButton(backHome);
      	button1_Slang.setBounds(40,150,300,75);
      	button1_Definition.setBounds(380,150,300,75);
      	button1_History.setBounds(40,250,300,75);
      	button1_Home.setBounds(380,250,300,75);
      	button1_Slang.setActionCommand("1_1");
      	button1_Definition.setActionCommand("1_2");
      	button1_History.setActionCommand("1_3");
      	button1_Home.setActionCommand("1_4");
	    JPanel panelSearch=new JPanel(){
	    	@Override
	    	protected void paintComponent(Graphics g){
	    		super.paintComponent(g);
	    		if(background1!=null){
	    			g.drawImage(background1.getImage(),0,0,getWidth(),getHeight(),null);
	    		}
	    	}
	    };
	    panelSearch.setLayout(null);
	    panelSearch.add(button1_Slang);
	    panelSearch.add(button1_Definition);
	    panelSearch.add(button1_History);
	    panelSearch.add(button1_Home);
	    setResizable(false);
	    setLayout(null);
	    setTitle("Search Dictionary");
	    setContentPane(panelSearch);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setLocation(200,50);
	    //setLocationByPlatform(true);
	    setSize(750,400);
	    setVisible(false);
	    button1_Slang.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent event){
	    		/*setVisible(false);
	    		Feature1(dictionary);*/
	    	}
	    });
	}
	public void out(){
		setVisible(false);
	}
	public void on(){
		setVisible(true);
	}
	public void add(ActionListener obj){
		button1_Home.addActionListener(obj);
		button1_History.addActionListener(obj);
		button1_Slang.addActionListener(obj);
		button1_Definition.addActionListener(obj);
	}
	public static void main(String[]args){/*
		Feature1();*/
	}
}