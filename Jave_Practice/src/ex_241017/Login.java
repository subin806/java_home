package ex_241017;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.println("ID를 입력하세요");
		String userID = scanner.next();
		System.out.println("Password를 입력하세요");
		int userPw = scanner.nextInt();

		String admin = "admin";

		if (userID.equals(admin) && userPw == 1234) {
			System.out.println("환영 합니다.");
		} else {
			System.out.println("로그인이 실패 되었습니다.");
		}
		scanner.close();

	}

}

