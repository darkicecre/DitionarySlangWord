
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

	
public class DoAnJava{
	private	static ReadFile rf = new ReadFile("dtb\\dtb.bin");
	private static SaveData data=new SaveData();
	private static Word dictionary=new Word();
	private static Menu menu;
	private static MenuCase1 case1;
	private static MenuCase2 case2;
	private static MenuCase3 case3;
	private static Feature1 fea1;
	private static Feature2 fea2;
	private static Feature3 fea3;
	private static Feature2_1 fea2_1;
	private static Feature2_2 fea2_2;
	private static Feature2_3 fea2_3;
	private static Feature2_4 fea2_4;
	private static Feature2_5 fea2_5;
	private static Feature3_1 fea3_1;
	private static Feature3_2 fea3_2;
	private static Feature3_3 fea3_3;
	public static void main(String[] args){
		rf.Read();
		dictionary=rf.getStore();
		menu=new Menu(dictionary);
		case1=new MenuCase1();
		case2=new MenuCase2(dictionary);
		case3=new MenuCase3(dictionary);
		fea1=new Feature1(dictionary);
		fea2=new Feature2(dictionary);
		fea3=new Feature3();
		fea2_1=new Feature2_1(dictionary);
		fea2_2=new Feature2_2(dictionary);
		fea2_3=new Feature2_3(dictionary);
		fea2_4=new Feature2_4(dictionary);
		fea2_5=new Feature2_5(dictionary);
		fea3_1=new Feature3_1(dictionary);
		fea3_2=new Feature3_2(dictionary);
		fea3_3=new Feature3_3(dictionary);
		ActionListener actionListener=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String str=e.getActionCommand();
				if(str=="1")  { 	menu.out();	                 case1.on();                      }
				if(str=="1_1_t"){   fea1.out();                  case1.on();                      }
				if(str=="1_1_xn"){  fea1.handle();                                                }
				if(str=="1_2_t"){   fea2.out();                  case1.on();                      }
				if(str=="1_2_xn"){  fea2.handle();                                                }
				if(str=="1_3_t"){   fea3.out();                  case1.on();                      }
				if(str=="1_3_xn"){  data.deleteAllHistory();     fea3.on(data.getHistory());      }
				if(str=="1_1"){     case1.out();                 fea1.on();                       }
				if(str=="1_2"){     case1.out();                 fea2.on();                       }
				if(str=="1_3"){     case1.out();                 fea3.on(data.getHistory());      }
				if(str=="1_4"){     case1.out();                 menu.on();                       }

				if(str=="2")  {     menu.out();                  case2.on();                      }
				if(str=="2_1"){     case2.out();                 fea2_1.on();                     }
				if(str=="2_1_xn"){   fea2_1.handle();                  }
				if(str=="2_1_t"){     fea2_1.out();                 case2.on();                     }
				if(str=="2_2"){     case2.out();                 fea2_2.on();                     }
				if(str=="2_2_xn"){   fea2_2.handle();                  }
				if(str=="2_2_t"){     fea2_2.out();                 case2.on();                     }
				if(str=="2_3"){		case2.out();				fea2_3.on();  				}
				if(str=="2_3_t"){	fea2_3.out();				case2.on();				}
				if(str=="2_4"){		case2.out();				fea2_4.on();  				}
				if(str=="2_4_t"){	fea2_4.out();				case2.on();				}
				if(str=="2_4_xn"){	fea2_4.handle();}
				if(str=="2_5"){		case2.out();	fea2_5.on();}
				if(str=="2_5_n"){	fea2_5.out();	case2.on();}
				if(str=="2_5_y"){	fea2_5.out();	case2.on();}
				if(str=="2_6"){     case2.out();                 menu.on();                       }
				if(str=="3")  {     menu.out();                  case3.on();                      }
				if(str=="3_1")  {     case3.out();                  fea3_1.on();                      }
				if(str=="3_1_t")  {     fea3_1.out();                  case3.on();                      }
				if(str=="3_1_xn")  {     fea3_1.handle();                                 }
				if(str=="3_2"){		case3.out();	fea3_2.on();	fea3_2.handle();}
				if(str=="3_2_t"){	fea3_2.out();	fea3_2.resetScore();	case3.on();	}
				if(str=="3_2_c"){	fea3_2.reset();	}
				if(str=="3_3"){		case3.out();	fea3_3.on();	fea3_3.handle();}
				if(str=="3_3_t"){	fea3_3.out();	fea3_3.resetScore();	case3.on();	}
				if(str=="3_3_c"){	fea3_3.reset();	}
				if(str=="3_4"){     case3.out();                 menu.on();                       }
			}
		};
		menu.add(actionListener);
		case1.add(actionListener);
		case2.add(actionListener);
		case3.add(actionListener);
		fea1.add(actionListener);
		fea2.add(actionListener);
		fea3.add(actionListener);
		fea2_1.add(actionListener);
		fea2_2.add(actionListener);
		fea2_3.add(actionListener);
		fea2_4.add(actionListener);
		fea2_5.add(actionListener);
		fea3_1.add(actionListener);
		fea3_2.add(actionListener);
		fea3_3.add(actionListener);
	}
}