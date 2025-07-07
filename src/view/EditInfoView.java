package view;

import domain.Medicine;
import java.util.Scanner;

public class EditInfoView {

    // 약 정보 입력 (수정 대상)
    public static String inputTargetMedicineName() {
        System.out.println("수정할 약품 정보를 입력하세요.");
        return InputView.inputMedicineName();
    }

    // 새로운 이름 입력
    public static String inputNewMedicineName() {
        System.out.print("새로운 약 이름을 입력하세요 (변경하지 않으려면 엔터): ");
        return new Scanner(System.in).nextLine();
    }

    // 새로운 가격 입력
    public static int inputNewMedicinePrice() {
        System.out.print("새로운 약 가격을 입력하세요 (변경하지 않으려면 0 입력): ");
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }
}
