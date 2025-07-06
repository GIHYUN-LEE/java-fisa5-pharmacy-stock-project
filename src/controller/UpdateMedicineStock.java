package controller;

import java.util.HashMap;

import domain.Medicine;
import model.Database;
import model.Model;
import view.OutputView;

public class UpdateMedicineStock {
	
	public static void updateMedicine(String medicineName, int quanity) {
		Model model = new Model();
		
		if(model.isExist(medicineName)) {
			HashMap<String, Medicine> list = model.getMedicineList();	
			Medicine med = list.get(medicineName);
			
			int newStock = med.getAmount()+quanity;
			if(newStock <0) {
				OutputView.errorPrint("수량이 부족합니다");
				return;
			}
			
			med.setAmount(newStock);
			OutputView.printUpdateSuccess(med);
		} else {
			OutputView.errorPrint("약이 존재하지 않습니다.");
		}
	}
}
