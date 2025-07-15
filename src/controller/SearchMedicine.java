package controller;

import java.util.HashMap;
import domain.Medicine;
import model.Service;
import view.InputView;
import view.SearchView;

public class SearchMedicine {

	public void searchMedicine() throws Exception {
		HashMap<String, Medicine> list = Service.getMedicineList();
		String name= InputView.inputMedicineName();

		if (list.containsKey(name)) {
			SearchView.showMedicine(list.get(name));
		} else {
			SearchView.showMedicine(null);
		}
	}

}
