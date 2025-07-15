package controller;

import domain.Medicine;
import model.Service;
import view.EditInfoView;
import view.OutputView;

public class EditMedicineInfo {

	public void editMedicine() {

		String targetName = EditInfoView.inputTargetMedicineName();

		try {
			if (!Service.isExist(targetName)) {
				throw new Exception("존재하지 않는 약 입니다.\n이전 메뉴로 돌아갑니다.");
			}

			Medicine oldMed = Service.getMedicineList().get(targetName);

			int newPriceInput = EditInfoView.inputNewMedicinePrice();
			int newAmountInput = EditInfoView.inputNewMedicineAmount();

			int finalPrice = (newPriceInput == 0) ? oldMed.getPrice()
					: (newPriceInput < 0) ? oldMed.getPrice() : newPriceInput;
			int finalAmount = (newAmountInput == 0) ? oldMed.getAmount()
					: (newAmountInput < 0) ? oldMed.getAmount() : newAmountInput;

			Medicine updatedMed = new Medicine(targetName, finalPrice, finalAmount);
			Service.editMedicine(targetName, finalPrice, finalAmount);

			OutputView.printEditSuccess(updatedMed);

		} catch (Exception e) {
			OutputView.errorPrint(e.getMessage());
		}
	}
}
