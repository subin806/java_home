package ex_241022;

public class Animal {
	//public, 모든 곳에서 다 볼 수 있음
	//private, 해당 파일 내에서만 볼 수 있음
	//protected, 상속 받은 자식 클래스에서 볼 수 있음
	protected String name;
	protected int age;
	static String color;
	
 public void speak() {
	 System.out.println("야호~");
 }
	

}
