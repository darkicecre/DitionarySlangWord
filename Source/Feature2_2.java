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

public class Feature2_2 extends JFrame{
	private Word dictionary;
	private	ImageIcon background1_1=new ImageIcon("image\\background2_2.PNG");
	private ImageIcon white=new ImageIcon("image\\white.PNG");
	private ImageIcon zero=new ImageIcon("image\\2_1_zero.PNG");
	private ImageIcon success=new ImageIcon("image\\success_2.PNG");
	private ImageIcon trung=new ImageIcon("image\\2_2_zero.PNG");
	private	Icon xn=new ImageIcon("image\\2_2_xn.PNG");
	private	Icon t=new ImageIcon("image\\2_2_t.PNG");
	private	JButton button_xn=new JButton(xn);
	private	JButton button_t=new JButton(t);
	private	JTextField text=new JTextField();
	private	JTextField textS=new JTextField();
	private JPanel panelFr=new JPanel(new BorderLayout());
	private JPanel panel1_1=new JPanel(){
	    @Override
	    protected void paintComponent(Graphics g){
	    	super.paintComponent(g);
	    	if(background1_1!=null){
	    		g.drawImage(background1_1.getImage(),0,0,getWidth(),getHeight(),null);
	    	}
	    }
	};
	private JPanel panelWhite=new JPanel(){
	    @Override
	    protected void paintComponent(Graphics g){
	    	super.paintComponent(g);
	    	if(white!=null){
	    		g.drawImage(white.getImage(),0,0,483,119,null);
	    	}
	    }
	};
	private JPanel panelZero=new JPanel(){
	    @Override
	    protected void paintComponent(Graphics g){
	    	super.paintComponent(g);
	    	if(zero!=null){
	    		g.drawImage(zero.getImage(),0,0,483,119,null);
	    	}
	    }
	};
	private JPanel panelSucess=new JPanel(){
	    @Override
	    protected void paintComponent(Graphics g){
	    	super.paintComponent(g);
	    	if(success!=null){
	    		g.drawImage(success.getImage(),0,0,483,119,null);
	    	}
	    }
	};
	private JPanel panelEqual=new JPanel(){
	    @Override
	    protected void paintComponent(Graphics g){
	    	super.paintComponent(g);
	    	if(trung!=null){
	    		g.drawImage(trung.getImage(),0,0,483,119,null);
	    	}
	    }
	};

	public Feature2_2(Word dictionary){
		this.dictionary = dictionary;
		button_xn.setBounds(515,125,141,106);
		button_t.setBounds(515,245,141,105);
		button_xn.setActionCommand("2_2_xn");
		button_t.setActionCommand("2_2_t");
	    panel1_1.setLayout(null);
	    setTitle("Search By Slang");
		setContentPane(panel1_1);
	    setLocation(200,50);
		setLayout(null);
		setSize(750,400);
		JPanel panel =new JPanel(new BorderLayout());
		panel.setBounds(230,120,260,40);
		panel.add(text);
		JPanel panel2 =new JPanel(new BorderLayout());
		panel2.setBounds(50,120,140,40);
		panel2.add(textS);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
	    panel1_1.add(panel2);
		panel1_1.add(panel);
		panel1_1.add(button_xn);
		panel1_1.add(button_t);
		panelFr.setBounds(20,225,483,119);
		panelFr.add(panelWhite,BorderLayout.CENTER);
		panel1_1.add(panelFr);
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
		if(text.getText().length()==0||textS.getText().length()==0){
			panelFr.removeAll();
			panelFr.add(panelZero,BorderLayout.CENTER);
			panelFr.setVisible(false);
			panelFr.setVisible(true);
		}
		else{
			String s=dictionary.find(textS.getText());
			if(s==null){
				panelFr.removeAll();
				panelFr.add(panelEqual,BorderLayout.CENTER);
				panelFr.setVisible(false);
				panelFr.setVisible(true);
			}
			else{
				dictionary.add(textS.getText(),text.getText());
				SaveData save=new SaveData(dictionary);
				save.saveToDatabase();	
				panelFr.removeAll();
				panelFr.add(panelSucess,BorderLayout.CENTER);
				panelFr.setVisible(false);
				panelFr.setVisible(true);
			}
		}
	}

}