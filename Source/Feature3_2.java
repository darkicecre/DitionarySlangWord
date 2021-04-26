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

public class Feature3_2 extends JFrame{
	private int heart = 3;
	private Word dictionary;
	private int keyQues=0;
	private	ImageIcon background1_1=new ImageIcon("image\\background3_2.PNG");
	private ImageIcon nullFrame=new ImageIcon("image\\3_2_button.PNG");
	private ImageIcon correct = new ImageIcon("image\\3_2_correct.PNG");
	private ImageIcon nullHeart=new ImageIcon("image\\nullHeart.PNG");
	private ImageIcon falseIcon = new ImageIcon("image\\3_2_false.PNG");
	private	Icon t=new ImageIcon("image\\3_2_home.PNG");
	private Icon c=new ImageIcon("image\\3_2_continue.PNG");
	private	JButton button_t=new JButton(t);
	private JButton button_c=new JButton(c);
	private	JLabel ques=new JLabel("",JLabel.CENTER);
	private	JLabel ques1=new JLabel("",JLabel.CENTER);
	private JPanel framePanel(int wid,int hei,ImageIcon image){
		JPanel paneltmp=new JPanel(){
			@Override
		    protected void paintComponent(Graphics g){
		    	super.paintComponent(g);
		    	if(image!=null){
		    		g.drawImage(image.getImage(),0,0,wid,hei,null);
		    	}
		    }
		};
		paneltmp.setLayout(null);
	    return paneltmp;
	}
	private JPanel nullHeart1=framePanel(44,40,nullHeart);
	private JPanel nullHeart2=framePanel(44,40,nullHeart);
	private JPanel nullHeart3=framePanel(44,40,nullHeart);
	private JPanel panel1=framePanel(184,61,nullFrame);
	private JPanel panel2=framePanel(184,61,nullFrame);
	private JPanel panel3=framePanel(184,61,nullFrame);
	private JPanel panel4=framePanel(184,61,nullFrame);
	private JPanel panel1_1=framePanel(734,361,background1_1);
	private JLabel highScore=new JLabel("",JLabel.CENTER);
	private JLabel score=new JLabel("",JLabel.CENTER);
	private void prepareLabel(JLabel label){
		label.setOpaque(true);
		label.setBackground(Color.white);
		Color myBlue = new Color(11,129,159);
		label.setForeground(myBlue);
		label.setFont(new java.awt.Font("Tahoma", 1, 32));		
	}
	private JButton prepareButton(String command){
		JButton buttontmp=new JButton();
		buttontmp.setBackground(Color.white);
		Color myBlue = new Color(11,129,159);
		buttontmp.setForeground(myBlue);
		buttontmp.setBounds(8,8,168,45);
		buttontmp.setActionCommand(command);
		return buttontmp;
	}
	private JButton button1=prepareButton("1");
	private JButton button2=prepareButton("2");
	private JButton button3=prepareButton("3");
	private JButton button4=prepareButton("4");
	public Feature3_2(Word dictionary){
		ReadFile data = new ReadFile("dtb\\scoreSlang.txt");
		data.writeString("0");
		prepareLabel(score);
		prepareLabel(highScore);
		score.setBounds(552,143,147,46);
		highScore.setBounds(552,54,147,46);
		this.dictionary = dictionary;
		button_t.setBounds(596,214,105,116);
		button_t.setActionCommand("3_2_t");
		button_c.setBounds(40,20,470,118);
		button_c.setActionCommand("3_2_c");
	    panel1_1.setLayout(null);
	    setTitle("Random Slang");
		setContentPane(panel1_1);
	    setLocation(200,50);
		setLayout(null);
		setSize(750,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
	    button1.addActionListener(actionListener);
	    button2.addActionListener(actionListener);
	    button3.addActionListener(actionListener);
	    button4.addActionListener(actionListener);
	}
	public void out(){
		setVisible(false);
	}
	public void on(){
	    button1.setActionCommand("1");
	    button2.setActionCommand("2");
	    button3.setActionCommand("3");
	    button4.setActionCommand("4");
		setVisible(true);
	}
	public void add(ActionListener obj){
		button_t.addActionListener(obj);
		button_c.addActionListener(obj);
	}
	public void reset(){
	    button1.setActionCommand("1");
	    button2.setActionCommand("2");
	    button3.setActionCommand("3");
	    button4.setActionCommand("4");
	    handle();
	    panel1_1.setVisible(false);
	    panel1_1.setVisible(true);

	}
	public void resetScore(){
		int a=Integer.parseInt(score.getText());
		int b=Integer.parseInt(highScore.getText());
		if(a>b){
			b=a;
			ReadFile dataHigh=new ReadFile("dtb\\highscoreSlang.txt");
			dataHigh.writeString(""+b);
		}
		ReadFile data = new ReadFile("dtb\\scoreSlang.txt");
		data.writeString("0");
	}
	private void addNullHeart(){
		if(heart==2){
			panel1_1.add(nullHeart1);
		}
		else if(heart==1){
			panel1_1.add(nullHeart1);
			panel1_1.add(nullHeart2);
		}
		else if(heart==0){
			panel1_1.add(nullHeart1);
			panel1_1.add(nullHeart2);
			panel1_1.add(nullHeart3);
			ReadFile data = new ReadFile("dtb\\scoreSlang.txt");
			data.writeString("0");
			heart=3;
		}
	}
	public void handle(){
		ReadFile high = new ReadFile("dtb\\highscoreSlang.txt");
		ReadFile scoreMine=new ReadFile("dtb\\scoreSlang.txt");
		highScore.setText(high.readString());
		score.setText(scoreMine.readString());
		String[] key=dictionary.guessSlang();
		prepareLabel(ques);
		prepareLabel(ques1);
		keyQues=Integer.parseInt(key[5]);
		button1.setText(key[0]);
		button2.setText(key[1]);
		button3.setText(key[2]);
		button4.setText(key[3]);
		ques.setText(key[4]);
		ques1.setText("");
		if(key[4].length()>=26){
			int i=0;
			for(i=17;i<key[4].length();i++){
				if(key[4].charAt(i)==' '){
					ques.setText(key[4].substring(0,i));
					ques1.setText(key[4].substring(i,key[4].length()));
					break;
				}
			}
		}
		ques.setBounds(20,70,500,50);
		ques1.setBounds(20,125,500,50);
		panel1_1.removeAll();
	    panel1_1.add(button_t);
	    panel1_1.add(highScore);
	    panel1_1.add(score);
	    panel1_1.add(ques);
	    panel1_1.add(ques1);
	    panel1.setBounds(60,190,184,61);
	    panel1_1.add(panel1);
	    panel2.setBounds(323,190,184,61);
	    panel1_1.add(panel2);
	    panel3.setBounds(60,265,184,61);
	    panel1_1.add(panel3);
	    panel4.setBounds(323,265,184,61);
	    panel1_1.add(panel4);
	    panel1.add(button1);
	    panel2.add(button2);
	    panel3.add(button3);
	    panel4.add(button4);
	    nullHeart1.setBounds(520,200,44,40);
	    nullHeart2.setBounds(520,244,44,40);
	    nullHeart3.setBounds(520,288,44,40);
		addNullHeart();
	}
	private ActionListener actionListener=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String str=e.getActionCommand();
			if(str=="@"){

			}
			else{
				JPanel correctPanel= framePanel(184,61,correct);
	 			JPanel falsePanel= framePanel(184,61,falseIcon);
				panel1_1.removeAll();
				panel1_1.add(button_c);
				panel1_1.add(highScore);
				panel1_1.add(score);
				panel1_1.add(button_t);
				if(Integer.parseInt(str)==keyQues){
					addNullHeart();
					int int_score=Integer.parseInt(score.getText())+1;
					if(int_score>Integer.parseInt(highScore.getText())){
						highScore.setText(""+int_score);
						ReadFile highdata = new ReadFile("dtb\\highscoreSlang.txt");
						highdata.writeString(highScore.getText());
					}
					score.setText(""+int_score);
					ReadFile write =new ReadFile("dtb\\scoreSlang.txt");
					write.writeString(score.getText());
					panel1_1.add(correctPanel);
					if(keyQues==1){
		    			correctPanel.setBounds(60,190,184,61);
						correctPanel.add(button1);
		    			panel1_1.add(panel2);
		    			panel1_1.add(panel3);
		    			panel1_1.add(panel4);
					}
					else if(keyQues==2){
		    			correctPanel.setBounds(323,190,184,61);
						correctPanel.add(button2);
		    			panel1_1.add(panel1);
		    			panel1_1.add(panel3);
		    			panel1_1.add(panel4);
					}
					else if(keyQues==3){
		    			correctPanel.setBounds(60,265,184,61);
						correctPanel.add(button3);
		    			panel1_1.add(panel2);
		    			panel1_1.add(panel1);
		    			panel1_1.add(panel4);
					}
					else{
		    			correctPanel.setBounds(324,265,184,61);
						correctPanel.add(button4);
		    			panel1_1.add(panel2);
		    			panel1_1.add(panel1);
		    			panel1_1.add(panel3);
					}
				}
				else{
					heart=heart-1;
					addNullHeart();
					falsePanel.removeAll();
					panel1_1.add(falsePanel);
					if(str=="1"){
		    			falsePanel.setBounds(60,190,184,61);
						falsePanel.add(button1);
		    			panel1_1.add(panel2);
		    			panel1_1.add(panel3);
		    			panel1_1.add(panel4);
					}
					else if(str=="2"){
		    			falsePanel.setBounds(323,190,184,61);
						falsePanel.add(button2);
		    			panel1_1.add(panel1);
		    			panel1_1.add(panel3);
		    			panel1_1.add(panel4);
					}
					else if(str=="3"){
		    			falsePanel.setBounds(60,265,184,61);
						falsePanel.add(button3);
		    			panel1_1.add(panel2);
		    			panel1_1.add(panel1);
		    			panel1_1.add(panel4);
					}
					else{
		    			falsePanel.setBounds(323,265,184,61);
						falsePanel.add(button4);
		    			panel1_1.add(panel2);
		    			panel1_1.add(panel1);
		    			panel1_1.add(panel3);
					}
				}
			}

			button1.setActionCommand("@");
			button2.setActionCommand("@");
			button3.setActionCommand("@");
			button4.setActionCommand("@");
			panel1_1.setVisible(false);
			panel1_1.setVisible(true);
			/*
			String questio = ques.getText()+ques1.getText();
			if(str!="@"){
				System.out.println(ques.getText());
				panel1_1.removeAll();
				panel1_1.add(button_t);
			    panel1_1.add(highScore);
			    panel1_1.add(score);
			    ques.setText("Choi tiep ?");
			    ques1.setText(" ");
			    panel1_1.add(ques);
			    panel1_1.add(ques1);
			}
			if(str=="1"){
				if(dictionary.find(button1.getText()).contains(questio)){
					correctPanel.removeAll();
					correctPanel.add(button1);
					panel1_1.add(correctPanel);
	    			correctPanel.setBounds(60,190,184,61);
	    			panel1_1.add(panel2);
	    			panel1_1.add(panel3);
	    			panel1_1.add(panel4);
				}
				else{
					falsePanel.removeAll();
					falsePanel.add(button1);
	    			falsePanel.setBounds(60,190,184,61);
					panel1_1.add(falsePanel);
					panel1_1.add(panel2);
					panel1_1.add(panel3);
					panel1_1.add(panel4);
				}
			}
			else if(str=="2"){
				if(dictionary.find(button2.getText()).contains(questio)){
					correctPanel.removeAll();
					correctPanel.add(button2);
					panel1_1.add(correctPanel);
	    			correctPanel.setBounds(323,190,184,61);
	    			panel1_1.add(panel1);
	    			panel1_1.add(panel3);
	    			panel1_1.add(panel4);
				}
				else{
					falsePanel.removeAll();
					falsePanel.add(button2);
	    			falsePanel.setBounds(323,190,184,61);
					panel1_1.add(falsePanel);
					panel1_1.add(panel1);
					panel1_1.add(panel3);
					panel1_1.add(panel4);
				}
			}
			else if(str=="3"){
				if(dictionary.find(button3.getText()).contains(questio)){
					correctPanel.removeAll();
					correctPanel.add(button3);
					panel1_1.add(correctPanel);
	    			correctPanel.setBounds(60,265,184,61);
	    			panel1_1.add(panel1);
	    			panel1_1.add(panel2);
	    			panel1_1.add(panel4);
				}
				else{
					falsePanel.removeAll();
					falsePanel.add(button3);
	    			falsePanel.setBounds(60,265,184,61);
					panel1_1.add(falsePanel);
					panel1_1.add(panel2);
					panel1_1.add(panel1);
					panel1_1.add(panel4);
				}
			}
			else if(str=="4"){
				if(dictionary.find(button4.getText()).contains(questio)){
					correctPanel.removeAll();
					correctPanel.add(button4);
					panel1_1.add(correctPanel);
	    			correctPanel.setBounds(323,265,184,61);
	    			panel1_1.add(panel1);
	    			panel1_1.add(panel2);
	    			panel1_1.add(panel3);
				}
				else{
					falsePanel.removeAll();
					falsePanel.add(button4);
	    			falsePanel.setBounds(323,265,184,61);
					panel1_1.add(falsePanel);
					panel1_1.add(panel2);
					panel1_1.add(panel3);
					panel1_1.add(panel1);
				}
			}
			button1.setActionCommand("@");
			button2.setActionCommand("@");
			button3.setActionCommand("@");
			button4.setActionCommand("@");
			panel1_1.setVisible(false);
			panel1_1.setVisible(true);*/
		}
	};

}