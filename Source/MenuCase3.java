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
public class MenuCase3 extends JFrame{
	private Word dictionary;
	public JButton button3_home=new JButton();
	private	Icon random=new ImageIcon("image\\random.PNG");
	private	Icon guessSlang=new ImageIcon("image\\guessSlang.PNG");
	private	Icon guessDefinition=new ImageIcon("image\\guessDefinition.PNG");
	private	Icon returnHome=new ImageIcon("image\\returnHome.PNG");
	private	ImageIcon background3=new ImageIcon("image\\background3.PNG");
	private	JButton button3_random=new JButton(random);
	private	JButton button3_slang=new JButton(guessSlang);
	private	JButton button3_definition=new JButton(guessDefinition);
	public MenuCase3(){

	}
	public MenuCase3(Word dictionary){
		this.dictionary=dictionary;
		button3_home=new JButton(returnHome);
      	button3_random.setBounds(40,150,315,75);
      	button3_slang.setBounds(380,150,315,75);
      	button3_definition.setBounds(40,250,315,75);
      	button3_home.setBounds(380,250,315,75);
      	button3_random.setActionCommand("3_1");
      	button3_slang.setActionCommand("3_2");
      	button3_definition.setActionCommand("3_3");
      	button3_home.setActionCommand("3_4");
	    JPanel panelPlay=new JPanel(){
	    	@Override
	    	protected void paintComponent(Graphics g){
	    		super.paintComponent(g);
	    		if(background3!=null){
	    			g.drawImage(background3.getImage(),0,0,getWidth(),getHeight(),null);
	    		}
	    	}
	    };
	    panelPlay.setLayout(null);
	    panelPlay.add(button3_random);
	    panelPlay.add(button3_slang);
	    panelPlay.add(button3_definition);
	    panelPlay.add(button3_home);
	    setLayout(null);
	    setTitle("Play Game");
	    setContentPane(panelPlay);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setResizable(false);
	    //setLocationByPlatform(true);
	    setLocation(200,50);
	    setSize(750,400);
	    setVisible(false);
	    /*button3_home.addActionListener(new ActionListener(){
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
		button3_random.addActionListener(obj);
		button3_slang.addActionListener(obj);
		button3_definition.addActionListener(obj);
		button3_home.addActionListener(obj);
	}
	public static void main(String[]args){
	}
}