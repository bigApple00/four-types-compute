package ind.calc;

import java.util.Random;

public class Logic {
  static Random random = new Random();
  
  /**
   * ����������.
   */
  public static int produceNumber1() {
    int randomRumberx;
    randomRumberx = random.nextInt(50) + 1;
    return randomRumberx;
  }
  
  /**
   * ��������.
   * @return
   **/
  public static float produceNumber2() {
    int randomNumbery;
    randomNumbery = random.nextInt(50) + 1;
    return randomNumbery;
  }
  
  /**
   * ʹ�ӷ����С��һ��.
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
   * ʹ�˻����С��һ��.
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
   * ��ɴ��С.
   */
  public static void bigSubtractsmall() {
		  Ui.y = random.nextInt(Ui.x);
	  }

  
  /**
   * ʹ����.
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
    //��������.0��β����û������
    Pattern pattern = Pattern.compile("\\.0$");
    String s = String.valueOf(Ui.z);
    Matcher matcher = pattern.matcher(s);
    //�ı䱻����y��ֵ
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
   * ���ѡ�������������һ��.
   * @return
   */
  
  public static String chooseCharacter() {
    char[] a = {'+','-','*','/'};
    String charString = String.valueOf(a[random.nextInt(a.length)]);
    return charString;

  }

}
