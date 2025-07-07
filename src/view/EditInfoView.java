package view;

import java.util.Scanner;

public class EditInfoView {

    private static final Scanner sc = new Scanner(System.in);

    /** 수정 대상 약 이름 */
    public static String inputTargetMedicineName() {
        System.out.println("수정할 약품 정보를 입력하세요.");
        return InputView.inputMedicineName();   // 기존 메서드 재사용
    }

    /** 새 이름(엔터=유지) */
    public static String inputNewMedicineName() {
        System.out.print("새로운 약 이름을 입력하세요 (변경하지 않으려면 엔터): ");
        return sc.nextLine();                  // 엔터 그대로 반환
    }

    /** 새 가격(0=유지) */
    public static int inputNewMedicinePrice() {
        System.out.print("새로운 약 가격을 입력하세요 (0 입력 시 유지): ");
        return Integer.parseInt(sc.nextLine());   // 빈 입력 방지 → 숫자만 허용
    }

    /** 새 수량(0=유지) */
    public static int inputNewMedicineAmount() {
        System.out.print("새로운 약 수량을 입력하세요 (0 입력 시 유지): ");
        return Integer.parseInt(sc.nextLine());
    }
}
