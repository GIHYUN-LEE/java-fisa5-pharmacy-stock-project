package controller;

import java.util.HashMap;
import java.util.Scanner;
import domain.Medicine;
import model.Model;
import view.InputView;
import view.OutputView;
import view.SearchView;
import view.StartView;

public class Controller {
	
	Model model = new Model();

	public HashMap<String, Medicine> getMedicineList() {  //데이터 반환하는 메서드
      return model.getMedicineList();
    
	}

	public static void main(String[] args) throws Exception{
		SearchView search=new SearchView();			
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
				
				//updateMedicine(model);
				break;
			case 4:return;
			case 5:search.showMedicine(); 
                   break;	
			case 0:
				System.out.println("프로그램 종료합니다");
				return;
			default:
				System.out.println("잘못된 선택입니다. 다시 선택해 주세요.");

			}
		}
	}

}
