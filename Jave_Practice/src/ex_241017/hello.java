package ex_241017;

public class hello {
	// 전역 메서드
	public static int sum(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		// 위에서 정의한 함수 이용해보기
		int result = sum(1, 2);
		System.out.println("클래스 메서드(static) 이용해보기, result : " + result);
	}
}