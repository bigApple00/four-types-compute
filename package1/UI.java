package package1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UI extends JFrame implements ActionListener{  
	public 
    int x;		//x为被除数，y除数，z为暂存x,y的商
	float z,y;
   
    JLabel[][] lab=new JLabel[10][4];		//存放四则运算的数和运算符
    JTextField[] text=new JTextField[10];		//存放输入结果
	Random random =new Random();
	JButton b1=new JButton("提交");

public int produceNumber1() {		//产生被除数
		int random_number_x;
		random_number_x=random.nextInt(50)+1;
		return random_number_x;
	}

public int produceNumber2() {		//产生除数
		
		int random_number_y;
		random_number_y=random.nextInt(50)+1;
		return random_number_y;
	}


public boolean underHundred() {		//使加法结果小于一百
		
		while(x+y>100) {
			y--;
			if(x+y<100)
				break;
		}
		
	}

	public void underHundred2() {	//使乘积结果小于一百
		while(x*y>100) {
			y--;
			if(x*y<100) 
				break;
		}
	}


	public boolean bigSubtractsmall() {//完成大减小
		if(x-y<0) {
			return false;
		}
		else {
			return true;
		}
	}


	UI(){
		int j=0;
		String ch;
		
		for(int i=0;i<10;i++) {
		x=produceNumber1();
		y=produceNumber2();	
		bigSubtractsmall();
		ch=chooseCharacter();		
		switch(ch) {		//判断产生的是哪个运算符
		case "+" :
			underHundred();
			lab[i][j]=new JLabel(" "+x);
			add(lab[i][j]);
			lab[i][j+1]=new JLabel("+");
	    	add(lab[i][j+1]);
	    	lab[i][j+2]=new JLabel(" "+(int)y);		//被除数y为float型转为int型
	    	add(lab[i][j+2]);
	    	lab[i][j+3]=new JLabel("=");
	    	add(lab[i][j+3]);
	    	text[i] =new JTextField("      ");
			add(text[i]);
			break;
		
		case "-":
			lab[i][j]=new JLabel(" "+x);
			add(lab[i][j]);
			lab[i][j+1]=new JLabel("-");
	    	add(lab[i][j+1]);
	    	lab[i][j+2]=new JLabel(" "+(int)y);
	    	add(lab[i][j+2]);
	    	lab[i][j+3]=new JLabel("=");
	    	add(lab[i][j+3]);
	    	text[i] =new JTextField("      ");
			add(text[i]);
			break;
			
		case "*":
			underHundred2();
			lab[i][j]=new JLabel(" "+x);
			add(lab[i][j]);
			lab[i][j+1]=new JLabel("*");
	    	add(lab[i][j+1]);
	    	lab[i][j+2]=new JLabel(" "+(int)y);
	    	add(lab[i][j+2]);
	    	lab[i][j+3]=new JLabel("=");
	    	add(lab[i][j+3]);
	    	text[i] =new JTextField("      ");
			add(text[i]);
			break;
			
		case "/":
			exactDivide();
			lab[i][j]=new JLabel(" "+x);
			add(lab[i][j]);
			lab[i][j+1]=new JLabel("/");
	    	add(lab[i][j+1]);
	    	lab[i][j+2]=new JLabel(" "+(int)y);
	    	add(lab[i][j+2]);
	    	lab[i][j+3]=new JLabel("=");
	    	add(lab[i][j+3]);
	    	text[i] =new JTextField("      ");
			add(text[i]);
			break;
			
			}
			
		}
		 b1.addActionListener(this);		//添加按钮做出应答
		 add(b1);
	}

	
	public static void main(String[] args) {
		UI g=new UI();
		g.setLayout(new FlowLayout(1,10,3));
		g.setTitle("四则运算");
		g.setLocation(1000, 100);
		g.setSize(500,300);
		g.setVisible(true);
		g.setResizable(false);
		g.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}



	