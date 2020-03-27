package package1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class UI extends JFrame implements ActionListener{  
	public 
    int x,y,z;//x为被除数，y除数，z结果
   
	
    //y=produceNumber2();
    
	//x=produceNumber1();
	
    JLabel[][] lab=new JLabel[10][4];
    JTextField[] text=new JTextField[10];
	Random random =new Random();
	JButton b1=new JButton("提交");

public int produceNumber1() {//产生被除数
		int random_number_x;
		random_number_x=random.nextInt(100)+1;
		return random_number_x;
	}
	