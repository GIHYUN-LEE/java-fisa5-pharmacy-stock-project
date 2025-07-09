package view;

import domain.Medicine;

public class SearchView {
	public static void showMedicine(Medicine m) {
		if (m == null) {
			System.out.println("리스트에 없는 약 이름 입니다.");
		} else {
			System.out.println("약 이름 : " + m.getName() + "  |  " + "약 가격 : " + m.getPrice() + "  |  " + "약 재고 수량 : "
					+ m.getAmount());
		}
	}

}
