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
	
	 public static void insertMedicine(Medicine medicine) throws Exception{
	      HashMap<String, Medicine> medicineList = model.getMedicineList();
	      if(medicine.getPrice() <= 0 || medicine.getAmount() < 0) {
	         throw new Exception("올바르지 않는 값입니다.");
	      }
	      medicineList.put(medicine.getName(), medicine);
	   }
	   
	   public static void deleteMedicine(String name) {
	      HashMap<String, Medicine> medicineList = model.getMedicineList();
	      medicineList.remove(name);
	   }

}
