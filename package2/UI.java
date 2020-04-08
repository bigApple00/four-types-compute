package package2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class UI extends JFrame implements ActionListener{  
		
    protected static int x;	
    protected static float y;	
    protected static float z;				//x为被除数，y为除数，z为暂存x,y的商
			
    JLabel[][] lab=new JLabel[10][4];		//存放四则运算的数和运算符
    JTextField[] text=new JTextField[10];		//存放输入结果
	Random random =new Random();
	JButton b1=new JButton("提交");

	public void actionPerformed(ActionEvent a) {
		int right_count=0;		//记录正确的个数
		String char_string;
		if(a.getSource()==b1) {
			for(int i=0;i<10;i++) {
				int j=0;
				char_string=lab[i][j+1].getText();
				
				switch (char_string) {		//判断是哪一个运算符对应的算式
				case "+":
					try {		//Integer.parseInt该方法会抛出异常
					if(Integer.parseInt(lab[i][j].getText().trim())+Integer.parseInt(lab[i][j+2].getText().trim())==Integer.parseInt(text[i].getText().trim()))
					right_count++;
					}catch (NumberFormatException e) {
						e.printStackTrace();
					}
					break;
					
				case "-":
					try {
					if(Integer.parseInt(lab[i][j].getText().trim())-Integer.parseInt(lab[i][j+2].getText().trim())==Integer.parseInt(text[i].getText().trim()))
					right_count++;
					}catch (NumberFormatException e) {
						e.printStackTrace();
					}
					break;
					
				case "*":
					try {
					if(Integer.parseInt(lab[i][j].getText().trim())*Integer.parseInt(lab[i][j+2].getText().trim())==Integer.parseInt(text[i].getText().trim()))
					right_count++;
					}catch (NumberFormatException e) {
						e.printStackTrace();
					}
					break;
					
				case "/":
					try {
					if(Integer.parseInt(lab[i][j].getText().trim())/Integer.parseInt(lab[i][j+2].getText().trim())==Integer.parseInt(text[i].getText().trim()))
					right_count++;
					}catch (NumberFormatException e) {
						e.printStackTrace();
					}
					break;
	
				}
				
			}
			b1.setText("你答对了"+right_count+"题");			//最后评分输出到button上
			
		}
	}
	
	UI(){
		int j=0;
		String ch;
		
		for(int i=0;i<10;i++) {
		x=Logic.produceNumber1();
		y=Logic.produceNumber2();	
		Logic.bigSubtractsmall();
		ch=Logic.chooseCharacter();		
		switch(ch) {		//判断产生的是哪个运算符
		case "+" :
			Logic.underHundred();
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
			Logic.underHundred2();
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
			Logic.exactDivide();
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
		setLayout(new FlowLayout(1,10,3));
		setTitle("四则运算");
		setLocation(1000, 100);
		setSize(500,300);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		UI g=new UI();
		g.setResizable(false);
		
	}
}
