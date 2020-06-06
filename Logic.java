package ind.calc;

import java.util.Random;

public class Logic {
  static Random random = new Random();
  
  /**
   * 产生被除数.
   */
  public static int produceNumber1() {
    int randomRumberx;
    randomRumberx = random.nextInt(50) + 1;
    return randomRumberx;
  }
  
  /**
   * 产生除数.
   * @return
   **/
  public static float produceNumber2() {
    int randomNumbery;
    randomNumbery = random.nextInt(50) + 1;
    return randomNumbery;
  }
  
  /**
   * 使加法结果小于一百.
   */
  public static void underHundred() {
    while (Ui.x + Ui.y > 100) {
      Ui.y--;
      if (Ui.x + Ui.y < 100) {
        break;
      }
    }
  }

  /**
   * 使乘积结果小于一百.
   */
  public static void underHundred2() {
    while (Ui.x * Ui.y > 100) {
      Ui.y--;
      if (Ui.x * Ui.y < 100) {
        break;
      }
    }
  }

  /**
   * 完成大减小.
   */
  public static void bigSubtractsmall() {
		  Ui.y = random.nextInt(Ui.x);
	  }

  
  /**
   * 使整除.
   */
  public static void exactDivide() {
	  Ui.x = Logic.produceNumber1();
		 Ui.y = Logic.produceNumber1();
	  int []a = new int[40];
	  a[0] = 1;
	  bigSubtractsmall();
	  if(Ui.x % Ui.y != 0) {
		  for (int i = 1;i<=Ui.x/2;i++) {
			  if(Ui.x % i == 0) {
				  a[i]=i;
				  
			  }
		  }
		  Ui.y =a[random.nextInt(a.length)];
			
		} 
		  
}
	  
	/*  try {
      Ui.z = Ui.x / Ui.y;
    } catch (ArithmeticException e) {
      e.printStackTrace();
    }
    //若不是以.0结尾，就没有整除
    Pattern pattern = Pattern.compile("\\.0$");
    String s = String.valueOf(Ui.z);
    Matcher matcher = pattern.matcher(s);
    //改变被除数y的值
    while (!matcher.find()) {
      Ui.y = 1f;
      Ui.y++;
      Ui.z = Ui.x / Ui.y;
      s = String.valueOf(Ui.z);
      matcher = pattern.matcher(s);
      if (matcher.find()) {
        break;
      }
    }
  }
  */
  /**
   * 随机选择四种运算符的一个.
   * @return
   */
  
  public static String chooseCharacter() {
    char[] a = {'+','-','*','/'};
    String charString = String.valueOf(a[random.nextInt(a.length)]);
    return charString;

  }

}
