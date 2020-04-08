package package2;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logic {
	
	static Random random =new Random();
	
	public static int produceNumber1() {	//产生被除数
		int random_number_x;
		random_number_x=random.nextInt(50)+1;
		return random_number_x;
	}
	
	public static float produceNumber2() {		//产生除数
		int random_number_y;
		random_number_y=random.nextInt(50)+1;
		return random_number_y;
	}
	
	public static void underHundred() {	//使加法结果小于一百
		while(UI.x+UI.y>100) {
			UI.y--;
			if(UI.x+UI.y<100)
				break;
		}
	}
	
	public static void underHundred2() {	//使乘积结果小于一百
		while(UI.x*UI.y>100) {
			UI.y--;
			if(UI.x*UI.y<100) 
				break;
		}
	}
	
	
	public static void bigSubtractsmall() {	//完成大减小
		while(UI.x-UI.y<0) {
			UI.x++;
			if(UI.x-UI.y>0)
				break;
		}
	}
	
	public static void exactDivide() {	//使整除
		try {
			UI.z=UI.x/UI.y;
		}
		catch (ArithmeticException e) {
			e.printStackTrace();
		}
		
		Pattern pattern=Pattern.compile("\\.0$");	//若不是以.0结尾，就没有整除
		String s = String.valueOf(UI.z);
		Matcher matcher=pattern.matcher(s);
		while(!matcher.find()) {		//改变被除数y的值
			UI.y=1f;
			UI.y++;
			UI.z=UI.x/UI.y;
			s = String.valueOf(UI.z);
			matcher=pattern.matcher(s);
			if(matcher.find())
				break;
		}
	}
	
	public static String chooseCharacter() {		//随机选择四种运算符的一个
		char[] a={'+','-','*','/'};
		String charString=String.valueOf(a[random.nextInt(a.length)]);
		return charString;
		
	}

}
