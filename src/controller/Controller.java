package controller;

import java.util.HashMap;
import java.util.Scanner;
import domain.Medicine;
import model.Model;
import view.InputView;
import view.StartView;

public class Controller {
	
	Model model = new Model();

	public HashMap<String, Medicine> getMedicineList() {  //데이터 반환하는 메서드
      return model.getMedicineList();
    
	}

	public static void main(String[] args) throws Exception{
		SearchMedicine search=new SearchMedicine();			
		Scanner scan = new Scanner(System.in);
		String name="";
		
		while(true) {
			StartView.startView();
			int option = scan.nextInt();
			
			switch (option) {
			case 1: return;
			case 2: return;
			case 3: return;
			case 4: name = InputView.inputMedicineName();
				    int quantity = InputView.inputMedicineAmount();
				    UpdateMedicineStock.updateMedicine(name, quantity);
				    break;
			case 5: search.searchMedicine();   //case5는 조회용이라서 기존 line33~36을 case4로 옮겼어요
		            break;	
			case 6: System.out.println("프로그램 종료합니다");
					break;
			default: System.out.println("잘못된 선택입니다. 다시 선택해 주세요.");
			}
		}
	}

}
