package model;

import java.util.HashMap;

import domain.Medicine;

public class Model {
	private Database db = new Database();
	
	private static Model model = new Model();
	
	public HashMap<String, Medicine> getMedicineList() {
		return db.getMedicine();
	}
	
	public boolean isExist(String medicineName) throws Exception {
		HashMap<String, Medicine> medicineList = model.getMedicineList();
		if(!medicineList.containsKey(medicineName)) {
			throw new Exception("존재하지 않는 약입니다.");
		} 
		return true;
	}
	
}
