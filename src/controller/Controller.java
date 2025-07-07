package controller;

import java.util.HashMap;
import java.util.Scanner;

import domain.Medicine;
import model.Model;
import view.InputView;
import view.OutputView;
import view.SearchView;
import view.StartView;

public class Controller {

    /* ---------------------------------
       필드 및 헬퍼 메서드
    --------------------------------- */
    Model model = new Model();

    /** 다른 클래스에서 Medicine 목록을 얻고 싶을 때 사용 */
    public HashMap<String, Medicine> getMedicineList() {
        return model.getMedicineList();
    }

    /* ---------------------------------
       프로그램 진입점
    --------------------------------- */
    public static void main(String[] args) throws Exception {

        /* 공통 객체 준비 */
        Scanner scan = new Scanner(System.in);
        Model model = Model.getModel();

        InsertDeleteMedicine insertDelete = new InsertDeleteMedicine();
        UpdateMedicineStock  updateMedicine = new UpdateMedicineStock();
        EditMedicineInfo     editController = new EditMedicineInfo();
        SearchView           search = new SearchView();

        /* 메인 루프 */
        while (true) {
            StartView.startView();
            int option = scan.nextInt();
            scan.nextLine();            // 버퍼 클리어

            switch (option) {

                case 1: // 약 삽입
                    insertDelete.insertMedicine(model);
                    break;

                case 2: // 약 삭제
                    insertDelete.deleteMedicine(model);
                    break;

                case 3: // 수량만 수정
                    updateMedicine.updateMedicine(model);
                    break;

                case 4: // 약 정보(이름·가격·수량) 수정
                    editController.editMedicine(model);
                    break;

                case 5: // 약 조회
                    search.showMedicine();
                    break;

                case 0: // 종료
                    System.out.println("프로그램 종료합니다");
                    return;

                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해 주세요.");
            }
        }
    }
}
