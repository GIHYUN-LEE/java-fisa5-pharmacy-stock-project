package controller;

import java.util.HashMap;
import domain.Medicine;
import model.Model;
import view.SearchView;

public class SearchMedicine {

	public void searchMedicine(String name) {
		HashMap<String, Medicine> list = Model.getMedicineList();

		if (list.containsKey(name)) {
			SearchView.showMedicine(list.get(name));
		} else {
			SearchView.showMedicine(null);
		}
	}

}
