package controller;

import domain.Medicine;
import model.Model;
import view.InsertDeleteView;
import view.OutputView;

public class InsertDeleteMedicine {
	
	public void insertMedicine() {
		Medicine medicine = InsertDeleteView.inputInsertMedicineInfo();
		try {
			if(Model.isExist(medicine.getName())) {
				throw new Exception("존재하는 약 입니다.");
			} 
			Model.insertMedicine(medicine);
			OutputView.printInsertSuccess(medicine);
			
		}catch(Exception e) {
			OutputView.errorPrint(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void deleteMedicine() {
		String name = InsertDeleteView.inputDeleteMedicineName();
		try {
			if(!Model.isExist(name)) {
				throw new Exception("존재하지 않는 약 입니다.");
			} 
			Model.deleteMedicine(name);
			OutputView.printDeleteSuccess(name);
		}catch (Exception e) {
			OutputView.errorPrint(e.getMessage());
		}
	}

}
