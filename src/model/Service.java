package model;

import java.util.HashMap;
import domain.Medicine;

public class Service {

	private Service() {
	}

	public static HashMap<String, Medicine> getMedicineList() throws Exception {
		return MedicineDAO.getAllMedicines();
	}

	public static boolean isExist(String medicineName) throws Exception {
		return MedicineDAO.getAllMedicines().containsKey(medicineName);
	}

	// 약 삽입
	public static void insertMedicine(Medicine medicine) throws Exception {
		if (medicine.getPrice() <= 0 || medicine.getAmount() < 0) {
			throw new Exception("올바르지 않는 값입니다.");
		}

		// DB에 반영
		boolean success = MedicineDAO.insertMedicine(medicine);
		if (!success) {
			throw new Exception("DB 삽입 실패");
		}
	}

	// 약 삭제
	public static void deleteMedicine(String name) throws Exception {
		boolean success = MedicineDAO.deleteMedicine(name);
		if (!success) {
			throw new Exception("DB 삭제 실패");
		}
	}

	// 약 정보 수정
	public static void editMedicine(String oldName, int newPrice, int newAmount) throws Exception {
		// 존재 여부 확인
		if (!isExist(oldName)) {
			throw new Exception("존재하지 않는 약 입니다.");
		}

		boolean success = MedicineDAO.updatePriceAmountMedicine(oldName, newPrice, newAmount);
		if (!success) {
			throw new Exception("약 정보 수정 실패");
		}

	}

	public static void updateMedicine(String name, int newAmount) throws Exception {
		// 약 존재 여부 확인
		if (!isExist(name)) {
			throw new Exception("해당 약이 존재하지 않습니다.");
		}

		// 약 객체 가져오기
		Medicine medicine = MedicineDAO.getAllMedicines().get(name);

		// 수량 유효성 검사 및 수량 업데이트
		if (medicine.getAmount() + newAmount < 0) {
			throw new Exception("수량은 음수가 될 수 없습니다.");
		} else {
			medicine.setAmount(medicine.getAmount() + newAmount);
		}

		// DB 반영 (선택적으로 DAO 호출 가능)
		boolean success = MedicineDAO.updateAmountMedicine(name, newAmount);
		if (!success) {
			throw new Exception("DB 수량 수정 실패");
		}
	}

}
