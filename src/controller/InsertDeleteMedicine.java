package controller;

import domain.Medicine;
import model.Service;
import view.InsertDeleteView;
import view.OutputView;

public class InsertDeleteMedicine {

	public void insertMedicine() {
		Medicine medicine = InsertDeleteView.inputInsertMedicineInfo();
		try {
			if (Service.isExist(medicine.getName())) {
				throw new Exception("존재하는 약 입니다.");
			}
			Service.insertMedicine(medicine);
			OutputView.printInsertSuccess(medicine);

		} catch (Exception e) {
			OutputView.errorPrint(e.getMessage());
			e.printStackTrace();
		}

	}

	public void deleteMedicine() {
		String name = InsertDeleteView.inputDeleteMedicineName();
		try {
			if (!Service.isExist(name)) {
				throw new Exception("존재하지 않는 약 입니다.");
			}
			Service.deleteMedicine(name);
			OutputView.printDeleteSuccess(name);
		} catch (Exception e) {
			OutputView.errorPrint(e.getMessage());
		}
	}

}
