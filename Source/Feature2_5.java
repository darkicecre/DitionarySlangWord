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

public class Feature2_5 extends JFrame{
	private Word dictionary;
	private Word root;
	private	ImageIcon background1_1=new ImageIcon("image\\background2_5.PNG");
	private	Icon y=new ImageIcon("image\\2_5_y.PNG");
	private	Icon n=new ImageIcon("image\\2_5_n.PNG");
	private	JButton button_y=new JButton(y);
	private	JButton button_n=new JButton(n);
	private JPanel panel1_1=new JPanel(){
	    @Override
	    protected void paintComponent(Graphics g){
	    	super.paintComponent(g);
	    	if(background1_1!=null){
	    		g.drawImage(background1_1.getImage(),0,0,getWidth(),getHeight(),null);
	    	}
	    }
	};

	public Feature2_5(Word dictionary){
		ReadFile rootData=new ReadFile();
		rootData.Read();
		root=rootData.getStore();
		this.dictionary = dictionary;
		button_y.setBounds(165,200,142,112);
		button_n.setBounds(410,200,142,112);
		button_y.setActionCommand("2_5_y");
		button_n.setActionCommand("2_5_n");
	    panel1_1.setLayout(null);
	    setTitle("Reset Dictionary");
		setContentPane(panel1_1);
	    setLocation(200,50);
		setLayout(null);
		setSize(750,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
	    panel1_1.add(button_y);
	    panel1_1.add(button_n);
	    button_y.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dictionary.reset();
				SaveData data = new SaveData(dictionary);
				data.saveToDatabase();
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
		button_y.addActionListener(obj);
		button_n.addActionListener(obj);
	}

}