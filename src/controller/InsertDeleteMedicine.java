package controller;

import java.util.HashMap;

import domain.Medicine;
import model.Model;
import view.InsertDeleteView;
import view.OutputView;

public class InsertDeleteMedicine {
	
	public void insertMedicine(Model model) {
		Medicine medicine = InsertDeleteView.inputInsertMedicineInfo();
		try {
			if(model.isExist(medicine.getName())) {
				throw new Exception("존재하는 약 입니다.");
			} 
			model.insertMedicine(medicine);
			OutputView.printInsertSuccess(medicine);
			
		}catch(Exception e) {
			OutputView.errorPrint(e.getMessage());
		}
		
	}
	
	public static void deleteMedicine(Model model) {
		String name = InsertDeleteView.inputDeleteMedicineName();
		try {
			if(!model.isExist(name)) {
				throw new Exception("존재하지 않는 약 입니다.");
			} 
			model.deleteMedicine(name);
			OutputView.printDeleteSuccess(name);
		}catch (Exception e) {
			OutputView.errorPrint(e.getMessage());
		}
	}

}
