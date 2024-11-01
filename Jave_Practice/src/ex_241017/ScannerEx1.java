package ex_241017;

import java.util.Scanner;

public class ScannerEx1 {

	public static void main(String[] args) {
		
		System.out.println("Scanner를 이용한, 콘솔에 입력한 문자열, 숫자 입력 받기.");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("오늘 먹고 싶은 점심 메뉴입력해주세요 : ");
		String lunchMenu = scanner.next();
		System.out.println("먹고 싶은 메뉴 : " + lunchMenu);
		
		System.out.println("주말에 먹고싶은 메뉴 입력하기 :");
		String weekendMenu = scanner.next();
		System.out.println("주말에 먹고싶은 메뉴 : " + weekendMenu);

		
		
	}

}
