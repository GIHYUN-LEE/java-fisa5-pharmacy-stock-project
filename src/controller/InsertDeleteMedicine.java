package controller;

import java.util.HashMap;

import domain.Medicine;
import model.InsertDeleteModel;
import model.Model;
import view.InsertDeleteView;

public class InsertDeleteMedicine {
	
	public static void insertMedicine(Model model) {
		Medicine medicine = InsertDeleteView.inputMedicineInfo();
		try {
			if(model.isExist(medicine.getName())) {
				throw Exception("존재하는 약 입니다.");
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
			if(!model.isExist(medicine.getName())) {
				throw Exception("존재하지 않는 약 입니다.");
			} 
			model.deleteMedicine(name);
			OutputView.printDeleteSuccess(name);
		}catch (Exception e) {
			OutputView.errorPrint(e.getMessage());
		}
	}

}
