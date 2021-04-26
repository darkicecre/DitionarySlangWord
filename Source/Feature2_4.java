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

public class Feature2_4 extends JFrame{
	private Word dictionary;
	private	ImageIcon background1_1=new ImageIcon("image\\background2_4.PNG");
	private ImageIcon zero=new ImageIcon("image\\2_4_zero.PNG");
	private ImageIcon white=new ImageIcon("image\\2_4_white.PNG");
	private ImageIcon success=new ImageIcon("image\\2_4_success.PNG");
	private ImageIcon notFound=new ImageIcon("image\\2_4_notFound.PNG");
	private ImageIcon confirm=new ImageIcon("image\\2_4_confirm.PNG");
	private	Icon xn=new ImageIcon("image\\2_4_xn.PNG");
	private	Icon t=new ImageIcon("image\\2_4_t.PNG");
	private	Icon y=new ImageIcon("image\\2_4_y.PNG");
	private	Icon n=new ImageIcon("image\\2_4_x.PNG");
	private	JButton button_xn=new JButton(xn);
	private	JButton button_t=new JButton(t);
	private	JButton button_y=new JButton(y);
	private	JButton button_n=new JButton(n);
	private	JTextField text=new JTextField();
	private JPanel panelFr=new JPanel(new BorderLayout());
	private JPanel panelConfirmFrame=new JPanel(){
		@Override
	    protected void paintComponent(Graphics g){
	    	super.paintComponent(g);
	    	if(white!=null){
	    		g.drawImage(white.getImage(),0,0,350,120,null);
	    	}
	    }
	};
	private JPanel panel1_1=new JPanel(){
	    @Override
	    protected void paintComponent(Graphics g){
	    	super.paintComponent(g);
	    	if(background1_1!=null){
	    		g.drawImage(background1_1.getImage(),0,0,getWidth(),getHeight(),null);
	    	}
	    }
	};
	private JPanel panelZero=new JPanel(){
	    @Override
	    protected void paintComponent(Graphics g){
	    	super.paintComponent(g);
	    	if(zero!=null){
	    		g.drawImage(zero.getImage(),0,0,400,110,null);
	    	}
	    }
	};
	private JPanel panelWhite=new JPanel(){
	    @Override
	    protected void paintComponent(Graphics g){
	    	super.paintComponent(g);
	    	if(white!=null){
	    		g.drawImage(white.getImage(),0,0,400,110,null);
	    	}
	    }
	};
	private JPanel panelSuccess=new JPanel(){
	    @Override
	    protected void paintComponent(Graphics g){
	    	super.paintComponent(g);
	    	if(success!=null){
	    		g.drawImage(success.getImage(),0,0,400,110,null);
	    	}
	    }
	};
	private JPanel panelNotFound=new JPanel(){
	    @Override
	    protected void paintComponent(Graphics g){
	    	super.paintComponent(g);
	    	if(notFound!=null){
	    		g.drawImage(notFound.getImage(),0,0,400,110,null);
	    	}
	    }
	};
	private JPanel panelConfirm=new JPanel(){
	    @Override
	    protected void paintComponent(Graphics g){
	    	super.paintComponent(g);
	    	if(confirm!=null){
	    		g.drawImage(confirm.getImage(),0,0,400,110,null);
	    	}
	    }
	};

	public Feature2_4(Word dictionary){
		this.dictionary = dictionary;
		button_xn.setBounds(400,240,141,105);
		button_t.setBounds(565,240,141,105);
		//button_y.setBounds(250,240,141,105);
		button_y.setBounds(15,10,141,105);
		button_n.setBounds(185,10,141,105);
		button_xn.setActionCommand("2_4_xn");
		button_t.setActionCommand("2_4_t");
	    panel1_1.setLayout(null);
	    setTitle("Delete Slang");
		setContentPane(panel1_1);
	    setLocation(200,50);
		setLayout(null);
		setSize(750,400);
		JPanel panel =new JPanel(new BorderLayout());
		panel.setBounds(430,125,260,40);
		panel.add(text);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
		panel1_1.add(panel);
		panel1_1.add(button_xn);
		panel1_1.add(button_t);
		panelFr.setBounds(20,110,400,110);
		panelFr.add(panelWhite,BorderLayout.CENTER);
		panel1_1.add(panelFr);
		panelConfirmFrame.setLayout(null);
		panelConfirmFrame.setBounds(20,230,350,120);
		panel1_1.add(panelConfirmFrame);
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
		if(text.getText().length()==0){
			panelFr.removeAll();
			panelFr.add(panelZero,BorderLayout.CENTER);
			panelFr.setVisible(false);
			panelFr.setVisible(true);
		}
		else{
			String s=dictionary.find(text.getText());
			if(s==null){
				panelFr.removeAll();
				panelFr.add(panelNotFound,BorderLayout.CENTER);
				panelFr.setVisible(false);
				panelFr.setVisible(true);
			}
			else{
				panelFr.removeAll();
				panelFr.add(panelConfirm,BorderLayout.CENTER);		
				panelConfirmFrame.add(button_y);
				panelConfirmFrame.add(button_n);
				panelFr.setVisible(false);
				panelFr.setVisible(true);
				button_n.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						panelConfirmFrame.removeAll();
						panelConfirmFrame.add(panelWhite,BorderLayout.CENTER);
						panelConfirmFrame.setVisible(false);
						panelConfirmFrame.setVisible(true);
						panelFr.removeAll();
						panelFr.add(panelWhite,BorderLayout.CENTER);
						panelFr.setVisible(false);
						panelFr.setVisible(true);
					}
				});
				button_y.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						panelConfirmFrame.removeAll();
						panelConfirmFrame.add(panelWhite,BorderLayout.CENTER);
						panelConfirmFrame.setVisible(false);
						panelConfirmFrame.setVisible(true);
						panelFr.removeAll();
						panelFr.add(panelSuccess,BorderLayout.CENTER);
						panelFr.setVisible(false);
						panelFr.setVisible(true);
						dictionary.remove(text.getText());
						SaveData data = new SaveData(dictionary);
						data.saveToDatabase();
					}
				});
			}
		}
	}

}