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
  //x为被除数，y为除数，z为暂存x,y的商
  protected static int x;
  protected static float y;
  protected static float z;
  //存放四则运算的数和运算符  
  JLabel[][] lab = new JLabel[10][4]; 
  //存放输入结果
  JTextField[] text = new JTextField[10];
  Random random = new Random();
  JButton b1 = new JButton("提交");
  
  /**
   *  implements java.awt.event.ActionListener.actionPerformed
   */
  public void actionPerformed(ActionEvent a) {
    //记录正确的个数
    int rightCount = 0;
    String charString;
    
    if (a.getSource() == b1) {
      for (int i = 0;i < 10;i++) {
        int j = 0;
        charString = lab[i][j + 1].getText();
        //判断是哪一个运算符对应的算式
        switch (charString) {
          case "+":
            //Integer.parseInt该方法会抛出异常  
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
      //最后评分输出到button上
      b1.setText("你答对了" + rightCount + "题");
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
      //判断产生的是哪个运算符
      switch (ch) {
        case "+" :
          Logic.underHundred();
          lab[i][j] = new JLabel(" " + x);
          add(lab[i][j]);
          lab[i][j + 1] = new JLabel("+");
          add(lab[i][j + 1]);
          //被除数y为float型转为int型
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
    
    //添加按钮做出应答
    b1.addActionListener(this);
    add(b1);
    setLayout(new FlowLayout(1,10,3));
    setTitle("四则运算");
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
