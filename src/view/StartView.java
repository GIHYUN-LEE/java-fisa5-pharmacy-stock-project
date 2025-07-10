package view;

import java.util.Scanner;

import controller.Controller;

public class StartView {
	
	private static void view() {
	    System.out.println("╭ ◜◝ ͡ ◜◝ ͡  ◜◝ ͡ ◜◝ ͡  ◜◝ ╮");
	    System.out.println("        💊  M Y          ");
	    System.out.println("    P H A R M A C Y  🏥   ");
	    System.out.println("╰ ◟◞ ͜  ◟ ͜   ◟◞ ͜  ◟ ͜ ◟◞ ╯");
	    System.out.println("                      O");
	    System.out.println("                    °");
		
	}
	

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Controller controller = new Controller();
		view();
		
		while (true) {
			
			System.out.println("===== 창고형 약국 시스템 =====");
			System.out.println("1. 약 삽입");
			System.out.println("2. 약 삭제");
			System.out.println("3. 약 수량 변경");
			System.out.println("4. 약 정보 변경");
			System.out.println("5. 약 조회");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택: ");

			int option = scan.nextInt();
			scan.nextLine(); // 버퍼 클리어

			boolean continueProgram = controller.process(option);
			if (!continueProgram) break;

		}
	}

}
