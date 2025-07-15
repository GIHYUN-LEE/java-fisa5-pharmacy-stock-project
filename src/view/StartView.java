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

			
		        System.out.println("╔════════════════════════════════════════════════════╗");
		        System.out.println("║              💊 창고형 약국 시스템 메인 메뉴               ║");
		        System.out.println("╠════════════════════════════════════════════════════╣");
		        System.out.println("║  1. 약 삽입       →   새로운 약을 창고에 등록합니다          ║");
		        System.out.println("║  2. 약 삭제       →   약을 창고에서 제거합니다              ║");
		        System.out.println("║  3. 약 수량 변경  →   약의 재고 수량을 수정합니다             ║");
		        System.out.println("║  4. 약 정보 변경  →   약의 이름 및 정보를 수정합니다           ║");
		        System.out.println("║  5. 약 조회       →   현재 보관 중인 약 목록을 확인합니다      ║");
		        System.out.println("║  0. 프로그램 종료 →   시스템을 종료합니다                    ║");
		        System.out.println("╚════════════════════════════════════════════════════╝");
		        System.out.print("👉 메뉴 번호를 선택하세요: ");
			
			

			int option = scan.nextInt();
			scan.nextLine(); // 버퍼 클리어

			boolean continueProgram = controller.process(option);
			if (!continueProgram) break;

		}
	}

}
