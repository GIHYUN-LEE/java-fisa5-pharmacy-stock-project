package controller;

import java.util.Scanner;

import view.InputView;
import view.StartView;

public class Controller {

	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			StartView.startView();
			int option = scan.nextInt();
			
			switch (option) {
			case 1: return;
			case 2: return;
			case 3: return;
			case 4: return;
			case 5: 
				String name = InputView.inputMedicineName();
				int quantity = InputView.inputMedicineAmount();
				UpdateMedicineStock.updateMedicine(name, quantity);
				break;
			case 6: System.out.println("프로그램 종료합니다");
					return;
			default: System.out.println("잘못된 선택입니다. 다시 선택해 주세요.");
			}
		}
	}

}
