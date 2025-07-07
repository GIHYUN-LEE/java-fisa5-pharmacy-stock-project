package controller;

import domain.Medicine;
import model.Model;
import view.EditInfoView;
import view.OutputView;

public class EditMedicineInfo {

    /** 약 정보 수정 메뉴 */
    public void editMedicine(Model model) {

        /* 1) 수정 대상 이름 */
        String targetName = EditInfoView.inputTargetMedicineName();

        try {
            /* 2) 존재 여부 확인 */
            if (!model.isExist(targetName)) {
                throw new Exception("존재하지 않는 약 입니다.\n이전 메뉴로 돌아갑니다.");
            }

            /* 3) 기존 Medicine 조회 */
            Medicine oldMed = model.getMedicineList().get(targetName);

            /* 4) 새 이름 입력 (엔터면 유지) */
            String newNameInput = EditInfoView.inputNewMedicineName();
            String finalName    = (newNameInput == null || newNameInput.trim().isEmpty())
                                  ? oldMed.getName()
                                  : newNameInput.trim();

            /* 4-1) 이름 중복 즉시 확인 */
            if (!finalName.equals(oldMed.getName()) && model.isExist(finalName)) {
                OutputView.errorPrint("이미 존재하는 약 이름입니다.");
                return;
            }

            /* 5) 새 가격·수량 입력 (0 = 유지) */
            int newPriceInput  = EditInfoView.inputNewMedicinePrice();
            int newAmountInput = EditInfoView.inputNewMedicineAmount();

            /* 6) 최종 값 확정 */
            int finalPrice  = (newPriceInput  == 0) ? oldMed.getPrice()  :
                              (newPriceInput  < 0) ? oldMed.getPrice()  : newPriceInput;

            int finalAmount = (newAmountInput == 0) ? oldMed.getAmount() :
                              (newAmountInput < 0) ? oldMed.getAmount() : newAmountInput;

            /* 7) 수정된 Medicine 생성 */
            Medicine updatedMed = new Medicine(finalName, finalPrice, finalAmount);

            /* 8) Model 반영 */
            model.editMedicine(targetName, updatedMed);

            /* 9) 성공 메시지 */
            OutputView.printEditSuccess(updatedMed);

        } catch (Exception e) {
            OutputView.errorPrint(e.getMessage());
        }
    }
}
