package view;

import java.util.Scanner;

import controller.Controller;

public class AdminView {
	public static void startAdminView(Controller controller) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("\u001B[31m"+"관리자"+"\u001B[0m"+" 계정입니다.");
		while (true) {

			
			System.out.println("1. 약 삽입");
			System.out.println("2. 약 삭제");
			System.out.println("3. 약 수량 변경");
			System.out.println("4. 약 정보 변경");
			System.out.println("5. 약 조회");
			System.out.println("0. 프로그램 종료");
			System.out.print("👉 메뉴 번호를 선택하세요: ");

			int option = scan.nextInt();
			scan.nextLine(); // 버퍼 클리어

			boolean continueProgram = controller.adminProcess(option);
			if (!continueProgram)
				break;

		}
		scan.close();
	}
}
