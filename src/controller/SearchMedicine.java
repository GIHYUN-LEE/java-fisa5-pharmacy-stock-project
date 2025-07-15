package controller;

import java.util.HashMap;
import domain.Medicine;
import model.Model;
import view.InputView;
import view.SearchView;

public class SearchMedicine {

	public void searchMedicine() {
		HashMap<String, Medicine> list = Model.getMedicineList();
		String name= InputView.inputMedicineName();

		if (list.containsKey(name)) {
			SearchView.showMedicine(list.get(name));
		} else {
			SearchView.showMedicine(null);
		}
	}

}
