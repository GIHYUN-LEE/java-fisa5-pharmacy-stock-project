package controller;

import java.util.HashMap;
import domain.Medicine;
import model.Model;
import view.SearchView;

public class Controller {

	/*
	 * --------------------------------- 필드 및 헬퍼 메서드
	 * ---------------------------------
	 */
	private static Model model = Model.getModel();

	/** 다른 클래스에서 Medicine 목록을 얻고 싶을 때 사용 */
	public HashMap<String, Medicine> getMedicineList() {
		return model.getMedicineList();
	}

	private final InsertDeleteMedicine insertDelete = new InsertDeleteMedicine();
	private final UpdateMedicineStock updateMedicine = new UpdateMedicineStock();
	private final EditMedicineInfo editController = new EditMedicineInfo();
	private final SearchView search = new SearchView();

	/*
	 * --------------------------------- 프로그램 진입점 ---------------------------------
	 */
	public boolean process(int option) {
		switch (option) {

		case 1: // 약 삽입
			insertDelete.insertMedicine();
			break;

		case 2: // 약 삭제
			insertDelete.deleteMedicine();
			break;

		case 3: // 수량만 수정
			updateMedicine.updateMedicine();
			break;

		case 4: // 약 정보(이름·가격·수량) 수정
			editController.editMedicine();
			break;

		case 5: // 약 조회
			search.showMedicine();
			break;

		case 0: // 종료
			System.out.println("프로그램 종료합니다");
			return false;

		default:
			System.out.println("잘못된 선택입니다. 다시 선택해 주세요.");
		}

		return true;
	}
}
