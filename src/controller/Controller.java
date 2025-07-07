package controller;

import java.util.Scanner;

import model.Model;
import view.InputView;
import view.OutputView;
import view.StartView;

public class Controller {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Model model = Model.getModel();
		InsertDeleteMedicine insertDelete = new InsertDeleteMedicine();


		while (true) {
			String name = "";
			StartView.startView();
			int option = scan.nextInt();

			switch (option) {
			case 1: //삽입
				insertDelete.insertMedicine(model);
				break;
			case 2: //삭제
				insertDelete.deleteMedicine(model);
				break;
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
