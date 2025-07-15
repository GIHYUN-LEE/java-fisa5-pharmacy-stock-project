package controller;

import java.util.HashMap;

import domain.Medicine;
import model.Service;
import view.InputView;
import view.OutputView;

public class UpdateMedicineStock {

	public void updateMedicine() {
	    try {
	        String name = InputView.inputMedicineName();
	        int quantity = InputView.inputMedicineAmount();

	        if (!Service.isExist(name)) {
	            throw new IllegalArgumentException("약이 존재하지 않습니다.");
	        }

	        HashMap<String, Medicine> list = Service.getMedicineList();
	        Medicine med = list.get(name);
	        int newStock = med.getAmount() + quantity;

	        if (newStock < 0) {
	            throw new IllegalStateException("재고 수량보다 많이 감소시킬 수 없습니다. (현재 재고: " + med.getAmount() + ")");
	        }

	        // DB에 반영
	        Service.updateMedicine(name, quantity);

	        if (newStock == 0) {
	            Service.deleteMedicine(name);
	            OutputView.printDeleteSuccess(name);
	        } else {
	            OutputView.printUpdateSuccess(new Medicine(name, med.getPrice(), newStock)); // 혹은 Service.getNameMedicine(name)
	        }

	    } catch (IllegalArgumentException | IllegalStateException e) {
	        OutputView.errorPrint(e.getMessage());
	    } catch (Exception e) {
	        OutputView.errorPrint("알 수 없는 오류가 발생했습니다: " + e.getMessage());
	    }
	}

}
