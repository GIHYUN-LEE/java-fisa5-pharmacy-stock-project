package view;

import java.util.Scanner;

import controller.Controller;

public class UserView {
	public static void startUserView(Controller controller) {
		Scanner scan = new Scanner(System.in);

		while (true) {

			System.out.println("===== 창고형 약국 시스템 =====");
			System.out.println("1. 약 조회");
			System.out.println("0. 프로그램 종료");
			System.out.print("👉 메뉴 번호를 선택하세요: ");

			int option = scan.nextInt();
			scan.nextLine(); // 버퍼 클리어

			boolean continueProgram = controller.userProcess(option);
			if (!continueProgram)
				break;

		}
		scan.close();
	}

}
