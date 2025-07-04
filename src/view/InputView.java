package view;

import java.util.Scanner;

public class InputView {
	private static Scanner sc = new Scanner(System.in);

    public static String inputMedicineName() {
        System.out.print("약 이름을 입력하세요: ");
        return sc.nextLine();
    }

    public static int inputMedicineAmount() {
        System.out.print("약 개수를 입력하세요: ");
        return Integer.parseInt(sc.nextLine());
    }
    
    public static int inputMedicinePrice() {
        System.out.print("약 가격을 입력하세요: ");
        return Integer.parseInt(sc.nextLine());
    }

    public static int inputMenuOption() {
        System.out.print("메뉴 번호를 선택하세요: ");
        return Integer.parseInt(sc.nextLine());
    }

    public static void confirmExit() {
        System.out.print("종료하시겠습니까? (y/n): ");
        String input = sc.nextLine().trim().toLowerCase();

        if (input.equals("y")) {
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        } else {
            System.out.println("메인 메뉴로 돌아갑니다.");
        }
    }
}