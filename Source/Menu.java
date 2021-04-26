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
public class Menu extends JFrame{
	private Word dictionary;
	private	Icon search = new ImageIcon("image\\search.PNG");
	private	Icon edit = new ImageIcon("image\\edit.PNG");
	private	Icon play = new ImageIcon("image\\play.PNG");
	private	ImageIcon background=new ImageIcon("image\\background.PNG");
	private	JButton buttonSearch = new JButton(search);
	private	JButton buttonEdit = new JButton(edit);
    private JButton buttonPlay = new JButton(play);
	public Menu(Word dictionary){
		this.dictionary=dictionary;
		JPanel panel=new JPanel(){
			@Override
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				if(background!=null){
					g.drawImage(background.getImage(),0,0,getWidth(),getHeight(),null);
				}
			}
		};
      	buttonSearch.setBounds(40,150,170,162);
      	buttonEdit.setBounds(270,150,170,162);
      	buttonPlay.setBounds(515,150,170,162);
      	buttonSearch.setActionCommand("1");
      	buttonEdit.setActionCommand("2");
      	buttonPlay.setActionCommand("3");
	    setLayout(null);
	    setTitle("Slang Dictionary");
	    setContentPane(panel);
	    panel.setLayout(null);
	    panel.add(buttonSearch);
	    panel.add(buttonEdit);
	    panel.add(buttonPlay);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*
	    setLocationByPlatform(true);*/
	    setLocation(200,50);
	    setSize(750,400);
	    setVisible(true);
	    /*buttonSearch.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent event){
	    		setVisible(false);
	    		MenuCase1 case1=new MenuCase1(dictionary);
	    		//case1.eventExit(;
	    	}
	    });
	    buttonEdit.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent event){
	    		setVisible(false);
	    		MenuCase2 case2=new MenuCase2(dictionary);
	    	}
	    });
	    buttonPlay.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent event){
	    		setVisible(false);
	    		MenuCase3 case3=new MenuCase3(dictionary);
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
		buttonSearch.addActionListener(obj);
		buttonEdit.addActionListener(obj);
		buttonPlay.addActionListener(obj);
	}
	public static void main(String[]args){
	}
}