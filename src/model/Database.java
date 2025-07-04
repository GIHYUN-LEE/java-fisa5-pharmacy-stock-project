package model;

import java.util.HashMap;

import domain.Medicine;

public class Database {

	static HashMap<String, Medicine> medicineList = new HashMap<>();
    
	static {
		 medicineList.put("타이레놀", new Medicine("타이레놀", 5000, 20));
	        medicineList.put("펜잘", new Medicine("펜잘", 4500, 15));
	        medicineList.put("게보린", new Medicine("게보린", 5200, 30));
	        medicineList.put("베아제", new Medicine("베아제", 3000, 40));
	        medicineList.put("판콜에이", new Medicine("판콜에이", 6000, 25));
	        medicineList.put("신일해열제", new Medicine("신일해열제", 3800, 18));
	        medicineList.put("지르텍", new Medicine("지르텍", 8000, 10));
	        medicineList.put("알러지캡슐", new Medicine("알러지캡슐", 7500, 12));
	        medicineList.put("활명수", new Medicine("활명수", 4200, 35));
	        medicineList.put("비타민C", new Medicine("비타민C", 9000, 50));
	}

	HashMap<String, Medicine> getMedicine() {
		return medicineList; 
	}
}
