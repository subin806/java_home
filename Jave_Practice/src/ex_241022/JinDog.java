package ex_241022;

public class JinDog  extends Animal{
	private String hobby;

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	//재정의, 부모 클래스의 메서드의 이름은 똑같고
	//내부 기능만 다르게 구현하는 방법
	@Override
	public void speak() {
		System.out.println("멍멍");
	}
	
	public void introduce() {
		System.out.println("이름 :" + super.name);	
	}
	public void introduce(String food) {
		System.out.println("이름 :" + super.name + ",취미 :" + this.hobby +
				 ",좋아하는 음식:" + food);	
	}
	
	public void introduce(String food, String location) {
		System.out.println("이름 :" + super.name + ",취미 :" + this.hobby +
				",사는곳: "+ location + ",좋아하는 음식:" + food);	
	}
	
	
	
	
	
	
	
}

