package view;

import java.util.HashMap;

import domain.Medicine;

public class OutputView {

	public static void printInsertSuccess(Medicine med) {
		System.out.println("약 등록 완료: " + med.getName() + " " + med.getAmount() +"개 " + med.getPrice() + "원");
	}
	
	public static void printUpdateSuccess(Medicine med) {
		System.out.println("약 업데이트 완료: " + med.getName() +" " + med.getAmount()+"개 " + med.getPrice() + "원");
	}
	
	public static void printDeleteSuccess(Medicine med) {
		System.out.println(med.getName() +" 삭제 완료");
	}
	
	public static void errorPrint(String errorMessage) {
		System.out.println(errorMessage);
	}
	
	public static void printAllMedicines(HashMap<String, Medicine> medicineList) {
		System.out.println("----전체 재고 목록 ----");
		System.out.printf("%-15s %-10s %-10s\n", "약 이름", "수량", "가격(원)");
	    System.out.println("=".repeat(37));  // 구분선

	    // 데이터 출력
	    for (Medicine med : medicineList.values()) {
	        System.out.printf("%-15s %-10d %-10d\n",
	                med.getName(), med.getAmount(), med.getPrice());
	    }
	}
	


}
