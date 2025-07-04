package controller;

import java.util.HashMap;

import domain.Medicine;
import model.Database;
import model.Model;

public class UpdateMedicineStock {
	
	public static void updateMedicine(String medicineName, int quanity) throws Exception {
		Model model = new Model();
		
		if(model.isExist(medicineName)) {
			HashMap<String, Medicine> list = model.getMedicineList();	
			Medicine med = list.get(medicineName);
			
			int newStock = med.getAmount()+quanity;
			if(newStock <0) {
				throw new Exception("수량이 부족합니다");
			}
			
			med.setAmount(newStock);
		}
	}
}
