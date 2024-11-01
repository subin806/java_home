package ex_241021;

import java.util.Scanner;

public class LunchMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		String[] menu = new String[3];
		
		System.out.println("=======오늘 먹고 싶은 점심 메뉴 3개 작성해보기=======");
		for(int i=0; i< menu.length; i++) {
			System.out.println("메뉴" +(i+1) + ":");
			menu[i] = scanner.nextLine();
		}
		System.out.println("======================");
		
		System.out.println("오늘 먹고 싶은 메뉴 출력");
		for(String mString : menu) {
			System.out.println();
		}
		scanner.close();
		
	}

}
