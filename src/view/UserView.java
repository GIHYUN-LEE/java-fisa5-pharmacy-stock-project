package view;

import java.util.Scanner;

import controller.Controller;

public class UserView {
	public static void startUserView(Controller controller, Scanner scan) {
	    while (true) {
	        try {
	            System.out.println("===== 창고형 약국 시스템 =====");
	            System.out.println("1. 약 조회");
	            System.out.println("0. 프로그램 종료");
	            System.out.print("👉 메뉴 번호를 선택하세요: ");

	            if (!scan.hasNextInt()) {
	                System.out.println("❗ 숫자를 입력해주세요.");
	                scan.nextLine();
	                continue;
	            }

	            int option = scan.nextInt();
	            scan.nextLine();

	            if (!controller.userProcess(option)) break;

	        } catch (Exception e) {
	            System.out.println("⚠️ 오류가 발생했습니다: " + e.getMessage());
	            scan.nextLine();
	        }
	    }
	}
}
