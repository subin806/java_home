package ex_241022;

class Sample {
	public int a;
	private int b;
	int c;
}

public class AccessEx {
	public static void main(String[] args) {
		Sample aClass = new Sample();
		aClass.a = 10;
		//private라서 할라면 게터세터 적용해서 해야댐
		//aClass.b = 10;
		aClass.c = 10;
	}
}
