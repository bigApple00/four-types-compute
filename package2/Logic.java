package package2;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logic {
	
	static Random random =new Random();
	
	public static int produceNumber1() {	//����������
		int random_number_x;
		random_number_x=random.nextInt(50)+1;
		return random_number_x;
	}
	
	public static float produceNumber2() {		//��������
		int random_number_y;
		random_number_y=random.nextInt(50)+1;
		return random_number_y;
	}
	
	public static void underHundred() {	//ʹ�ӷ����С��һ��
		while(UI.x+UI.y>100) {
			UI.y--;
			if(UI.x+UI.y<100)
				break;
		}
	}
	
	public static void underHundred2() {	//ʹ�˻����С��һ��
		while(UI.x*UI.y>100) {
			UI.y--;
			if(UI.x*UI.y<100) 
				break;
		}
	}
	
	
	public static void bigSubtractsmall() {	//��ɴ��С
		while(UI.x-UI.y<0) {
			UI.x++;
			if(UI.x-UI.y>0)
				break;
		}
	}
	
	public static void exactDivide() {	//ʹ����
		try {
			UI.z=UI.x/UI.y;
		}
		catch (ArithmeticException e) {
			e.printStackTrace();
		}
		
		Pattern pattern=Pattern.compile("\\.0$");	//��������.0��β����û������
		String s = String.valueOf(UI.z);
		Matcher matcher=pattern.matcher(s);
		while(!matcher.find()) {		//�ı䱻����y��ֵ
			UI.y=1f;
			UI.y++;
			UI.z=UI.x/UI.y;
			s = String.valueOf(UI.z);
			matcher=pattern.matcher(s);
			if(matcher.find())
				break;
		}
	}
	
	public static String chooseCharacter() {		//���ѡ�������������һ��
		char[] a={'+','-','*','/'};
		String charString=String.valueOf(a[random.nextInt(a.length)]);
		return charString;
		
	}

}
