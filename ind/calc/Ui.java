package ind.calc;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ui extends JFrame implements ActionListener {
  //xΪ��������yΪ������zΪ�ݴ�x,y����
  protected static int x;
  protected static float y;
  protected static float z;
  //���������������������  
  JLabel[][] lab = new JLabel[10][4]; 
  //���������
  JTextField[] text = new JTextField[10];
  Random random = new Random();
  JButton b1 = new JButton("�ύ");
  
  /**
   *  implements java.awt.event.ActionListener.actionPerformed
   */
  public void actionPerformed(ActionEvent a) {
    //��¼��ȷ�ĸ���
    int rightCount = 0;
    String charString;
    
    if (a.getSource() == b1) {
      for (int i = 0;i < 10;i++) {
        int j = 0;
        charString = lab[i][j + 1].getText();
        //�ж�����һ���������Ӧ����ʽ
        switch (charString) {
          case "+":
            //Integer.parseInt�÷������׳��쳣  
            try {
              if (Integer.parseInt(lab[i][j].getText().trim())
                  + Integer.parseInt(lab[i][j + 2].getText().trim())
                  == Integer.parseInt(text[i].getText().trim())) {
                rightCount++;
              }
            } catch (NumberFormatException e) {
              e.printStackTrace();
            }
            break;

          case "-":
            try {
              if (Integer.parseInt(lab[i][j].getText().trim())
                  - Integer.parseInt(lab[i][j + 2].getText().trim())
                  == Integer.parseInt(text[i].getText().trim())) {
                rightCount++;
              }
            } catch (NumberFormatException e) {
              e.printStackTrace();
            }
            break;

          case "*":
            try {
              if (Integer.parseInt(lab[i][j].getText().trim())
                  * Integer.parseInt(lab[i][j + 2].getText().trim()) 
                  == Integer.parseInt(text[i].getText().trim())) {
                rightCount++;
              }
            } catch (NumberFormatException e) {
              e.printStackTrace();
            }
            break;

          case "/":
            try {
              if (Integer.parseInt(lab[i][j].getText().trim())
                  / Integer.parseInt(lab[i][j + 2].getText().trim())
                  == Integer.parseInt(text[i].getText().trim())) {
                rightCount++;
              }
            } catch (NumberFormatException e) {
              e.printStackTrace();
            }
            break;
          default:
            break;
        }
      }
      //������������button��
      b1.setText("������" + rightCount + "��");
    }
  }

  Ui() {
    int j = 0;
    String ch;
    for (int i = 0;i < 10;i++) {
      x = Logic.produceNumber1();
      y = Logic.produceNumber2();
      Logic.bigSubtractsmall();
      ch = Logic.chooseCharacter();
      //�жϲ��������ĸ������
      switch (ch) {
        case "+" :
          Logic.underHundred();
          lab[i][j] = new JLabel(" " + x);
          add(lab[i][j]);
          lab[i][j + 1] = new JLabel("+");
          add(lab[i][j + 1]);
          //������yΪfloat��תΪint��
          lab[i][j + 2] = new JLabel(" " + (int)y);
          add(lab[i][j + 2]);
          lab[i][j + 3] = new JLabel("=");
          add(lab[i][j + 3]);
          text[i] = new JTextField("      ");
          add(text[i]);
          break;

        case "-":
          lab[i][j] = new JLabel(" " + x);
          add(lab[i][j]);
          lab[i][j + 1] = new JLabel("-");
          add(lab[i][j + 1]);
          lab[i][j + 2] = new JLabel(" " + (int)y);
          add(lab[i][j + 2]);
          lab[i][j + 3] = new JLabel("=");
          add(lab[i][j + 3]);
          text[i] = new JTextField("      ");
          add(text[i]);
          break;
          
        case "*":
          Logic.underHundred2();
          lab[i][j] = new JLabel(" " + x);
          add(lab[i][j]);
          lab[i][j + 1] = new JLabel("*");
          add(lab[i][j + 1]);
          lab[i][j + 2] = new JLabel(" " + (int)y);
          add(lab[i][j + 2]);
          lab[i][j + 3] = new JLabel("=");
          add(lab[i][j + 3]);
          text[i] = new JTextField("      ");
          add(text[i]);
          break;
          
        case "/":
          Logic.exactDivide();
          lab[i][j] = new JLabel(" " + x);
          add(lab[i][j]);
          lab[i][j + 1] = new JLabel("/");
          add(lab[i][j + 1]);
          lab[i][j + 2] = new JLabel(" " + (int)y);
          add(lab[i][j + 2]);
          lab[i][j + 3] = new JLabel("=");
          add(lab[i][j + 3]);
          text[i] = new JTextField("      ");
          add(text[i]);
          break;
          
        default:
          break;

      }
    }
    
    //��Ӱ�ť����Ӧ��
    b1.addActionListener(this);
    add(b1);
    setLayout(new FlowLayout(1,10,3));
    setTitle("��������");
    setLocation(1000, 100);
    setSize(500,300);
    setVisible(true);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  /**
   * main.
 
   */
  public static void main(String[] args) {
    Ui g = new Ui();
    g.setResizable(false);

  }
}
