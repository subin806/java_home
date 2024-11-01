package ex_241017;

import java.util.Scanner;

public class Csb806_ScannerPractice {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("======회원가입 폼 작성해보기.=======");
		
		System.out.println("id : ");
		String userId = scanner.next();
		System.out.println("id :" + userId);
		
		System.out.println("name : ");
		String userName = scanner.next();
		System.out.println("name :" + userName);
		
		System.out.println("email : ");
		String userEmail = scanner.next();
		System.out.println("email :" + userEmail);
		
		System.out.println("비밀번호 : ");
		String Password = scanner.next();
		System.out.println("비밀번호 :" + Password);
		
		System.out.println("비밀번호 확인 : ");
		String confirmPassword = scanner.next();
		System.out.println("비밀번호 확인 :" + confirmPassword);
		
		System.out.println("주소 : ");
		String userAddress = scanner.next();
		System.out.println("주소 :" + userAddress);
		
		System.out.println("전화번호 : ");
		String userPhone = scanner.next();
		System.out.println("전화번호:" + userPhone);
		
		System.out.println("좋아하는 메뉴 : ");
		String food = scanner.next();
		System.out.println("좋아하는 메뉴 :" + food);

		System.out.println("=============");
		
		scanner.close();
	}

}
