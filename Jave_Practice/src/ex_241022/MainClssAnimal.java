package ex_241022;

public class MainClssAnimal {
	public static void main(String[] args) {
 JinDog jinDog = new JinDog();
 jinDog.name = "진돗개";
 jinDog.age = 1;
 //현재, 부모 클래스의 기본 기능을 그대로 이용 할 경우
 //오버라이드 하고, 사용시, 자식 클래스의 메서드를 이요함
 jinDog.setHobby("공놀이");
 jinDog.speak();
 jinDog.introduce();
 jinDog.introduce("개껌","서면");
	}
}
