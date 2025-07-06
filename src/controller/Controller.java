package controller;

import java.util.Scanner;

import model.Model;
import view.InputView;
import view.OutputView;
import view.StartView;

public class Controller {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Model model = new Model();

		while (true) {
			String name = "";
			StartView.startView();
			int option = scan.nextInt();

			switch (option) {
			case 1:
				OutputView.printAllMedicines(model.getMedicineList());
				break;
			case 2:
				name = InputView.inputMedicineName();
			case 3:
				name = InputView.inputMedicineName();
				int quantity = InputView.inputMedicineAmount();
				UpdateMedicineStock.updateMedicine(name, quantity);
				break;
			case 4:
				return;
			case 5:
				return;
			case 0:
				System.out.println("프로그램 종료합니다");
				return;
			default:
				System.out.println("잘못된 선택입니다. 다시 선택해 주세요.");
			}
		}
	}

}
