package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import domain.Medicine;
import domain.User;
import model.Service;
import model.UserDAO;
import view.InputView;
import view.OutputView;
import view.SearchView;

public class Controller {

	private final InsertDeleteMedicine insertDelete = new InsertDeleteMedicine();
	private final UpdateMedicineStock updateMedicine = new UpdateMedicineStock();
	private final EditMedicineInfo editController = new EditMedicineInfo();
	private final SearchMedicine searchMedicine = new SearchMedicine();

	/*
	 * --------------------------------- 프로그램 진입점 ---------------------------------
	 */
	public boolean adminProcess(int option) {
	    try {
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
	                searchMedicine.searchMedicine();
	                break;

	            case 0: // 종료
	                System.out.println("프로그램 종료합니다");
	                return false;

	            default:
	                System.out.println("잘못된 선택입니다. 다시 선택해 주세요.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        OutputView.errorPrint("⚠️ 관리자 기능 처리 중 오류가 발생했습니다.");
	    }

	    return true;
	}


	public boolean userProcess(int option) {
		try {
			switch (option) {
			case 1: // 약 조회
				searchMedicine.searchMedicine();
				break;

			case 0: // 종료
				System.out.println("프로그램 종료합니다");
				return false;

			default:
				System.out.println("잘못된 선택입니다. 다시 선택해 주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

	public static String getUserRole(String name) {
		if (name != null && !name.isBlank()) {
			try {
				String role = UserDAO.getUserRole(name);
				return role;
			} catch (SQLException e) {
				e.printStackTrace();
				OutputView.errorPrint("잠시 후 다시 시도해주세요");
				return null;
			}
		} else {
			OutputView.errorPrint("사용자 정보가 없습니다. 사용자명을 확인해주세요");
			return null;
		}
	}
}
