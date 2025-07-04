package controller;
import domain.Medicine;
import view.InputView;

public class SearchMedicine {
	
	public void searchMedicine() {
		Controller control = new Controller();
		String name=InputView.inputMedicineName();
		if(control.getMedicineList().containsKey(name)){
				Medicine m = control.getMedicineList().get(name); 
					System.out.println("약 이름 : " + m.getName() + "  |  " + "약 가격 : " + m.getPrice() + "  |  "+ "약 재고 수량 : " + m.getAmount());
			}
		else {
			System.out.println("리스트에 없는 약 이름 입니다.");
		}
	}
}

