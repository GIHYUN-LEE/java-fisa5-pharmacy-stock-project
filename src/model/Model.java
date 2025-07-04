package model;

import java.util.HashMap;

import domain.Medicine;

public class Model {
	private Database db = new Database();
	
	private static Model model = new Model();
	
	public HashMap<String, Medicine> getMedicineList() {
		return db.getMedicine();
	}
	
	public boolean isExist(String medicineName){
		HashMap<String, Medicine> medicineList = model.getMedicineList();
		if(!medicineList.containsKey(medicineName)) {
			return false;
		} 
		return true;
	}
	
	public static Model getModel() {
		return model;
	}
	
}
