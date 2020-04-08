package package2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class UI extends JFrame implements ActionListener{  
		
    protected static int x;	
    protected static float y;	
    protected static float z;				//xΪ��������yΪ������zΪ�ݴ�x,y����
			
    JLabel[][] lab=new JLabel[10][4];		//���������������������
    JTextField[] text=new JTextField[10];		//���������
	Random random =new Random();
	JButton b1=new JButton("�ύ");

	public void actionPerformed(ActionEvent a) {
		int right_count=0;		//��¼��ȷ�ĸ���
		String char_string;
		if(a.getSource()==b1) {
			for(int i=0;i<10;i++) {
				int j=0;
				char_string=lab[i][j+1].getText();
				
				switch (char_string) {		//�ж�����һ���������Ӧ����ʽ
				case "+":
					try {		//Integer.parseInt�÷������׳��쳣
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
			b1.setText("������"+right_count+"��");			//������������button��
			
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
		switch(ch) {		//�жϲ��������ĸ������
		case "+" :
			Logic.underHundred();
			lab[i][j]=new JLabel(" "+x);
			add(lab[i][j]);
			lab[i][j+1]=new JLabel("+");
	    	add(lab[i][j+1]);
	    	lab[i][j+2]=new JLabel(" "+(int)y);		//������yΪfloat��תΪint��
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
		b1.addActionListener(this);		//��Ӱ�ť����Ӧ��
		add(b1);
		setLayout(new FlowLayout(1,10,3));
		setTitle("��������");
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
