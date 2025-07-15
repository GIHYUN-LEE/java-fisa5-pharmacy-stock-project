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
			System.out.print("👉 사용자 이름을 입력해주세요: ");

			String name = scan.nextLine();
			scan.nextLine(); // 버퍼 클리어
			
			String role = Controller.getUserRole(name);
			
			if (role == null) {
                System.out.println("🚫 로그인 실패: 존재하지 않는 사용자입니다.");
                continue;
            }
			if("admin".equals(role)) {
				AdminView.startAdminView(controller);
			} else if("user".equals(role)) {
				UserView.startUserView(controller);
			} else {
			    System.out.println("🚫 알 수 없는 권한입니다: ");
			}
			
		}
	}

}
