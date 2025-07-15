package view;

import domain.Medicine;

public class InsertDeleteView {
	
	public static Medicine inputInsertMedicineInfo() {
		System.out.println("삽입할 약품 정보를 입력하세요");
		return new Medicine(InputView.inputMedicineName(), 
							InputView.inputMedicinePrice(), 
							InputView.inputMedicineAmount());
	}
	
	public static String inputDeleteMedicineName() {
		System.out.println("삭제할 약품 정보를 입력하세요");
		String name = InputView.inputMedicineName();
		
		return name;
	}

}
