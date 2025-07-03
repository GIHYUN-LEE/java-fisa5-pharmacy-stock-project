package model;

import java.util.ArrayList;

import domain.Medicine;

public class Database {

	static ArrayList<Medicine> medicineList = new ArrayList<>();
    
	static {
	    medicineList.add(new Medicine("타이레놀", 5000, 20));
	    medicineList.add(new Medicine("펜잘", 4500, 15));
	    medicineList.add(new Medicine("게보린", 5200, 30));
	    medicineList.add(new Medicine("베아제", 3000, 40));
	    medicineList.add(new Medicine("판콜에이", 6000, 25));
	    medicineList.add(new Medicine("신일해열제", 3800, 18));
	    medicineList.add(new Medicine("지르텍", 8000, 10));
	    medicineList.add(new Medicine("알러지캡슐", 7500, 12));
	    medicineList.add(new Medicine("활명수", 4200, 35));
	    medicineList.add(new Medicine("비타민C", 9000, 50));
	}

	public static ArrayList<Medicine> getMedicine() {
		return medicineList; 
	}
}
