package controller;

import java.util.HashMap;

import domain.Medicine;
import model.Model;
import view.InputView;
import view.OutputView;

public class UpdateMedicineStock {

    public static void updateMedicine(Model model) {
        try {
            String name = InputView.inputMedicineName();
            int quantity = InputView.inputMedicineAmount();

            if (!model.isExist(name)) {
                throw new IllegalArgumentException("약이 존재하지 않습니다.");
            }

            HashMap<String, Medicine> list = model.getMedicineList();
            Medicine med = list.get(name);
            int newStock = med.getAmount() + quantity;

            if (newStock < 0) {
                throw new IllegalStateException("재고 수량보다 많이 감소시킬 수 없습니다. (현재 재고: " + med.getAmount() + ")");
            }

            med.setAmount(newStock);
            OutputView.printUpdateSuccess(med);

        } catch (IllegalArgumentException | IllegalStateException e) {
            OutputView.errorPrint(e.getMessage());
        } catch (Exception e) {
            OutputView.errorPrint("알 수 없는 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
