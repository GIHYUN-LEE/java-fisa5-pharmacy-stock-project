package model;

import java.util.HashMap;
import domain.Medicine;

public class Model {
    
    private static Database db = new Database();
    private static Model model = new Model();
    
    private Model() {}
    
    public static HashMap<String, Medicine> getMedicineList() {
        return db.getMedicine();
    }

    public static boolean isExist(String medicineName) {
        HashMap<String, Medicine> medicineList = model.getMedicineList();
        return medicineList.containsKey(medicineName);
    }

    public static Model getModel() {
        return model;
    }

    // 약 삽입
    public static void insertMedicine(Medicine medicine) throws Exception {
        HashMap<String, Medicine> medicineList = model.getMedicineList();
        if (medicine.getPrice() <= 0 || medicine.getAmount() < 0) {
            throw new Exception("올바르지 않는 값입니다.");
        }
        medicineList.put(medicine.getName(), medicine);
    }

    // 약 삭제
    public static void deleteMedicine(String name) {
        HashMap<String, Medicine> medicineList = model.getMedicineList();
        medicineList.remove(name);
    }

    // 약 정보 수정
    public static void editMedicine(String oldName, Medicine newMed) throws Exception {
        HashMap<String, Medicine> medicineList = model.getMedicineList();

        // 존재 여부 확인
        if (!model.isExist(oldName)) {
            throw new Exception("존재하지 않는 약 입니다.");
        }

        // 이름 변경 시 중복 방지
        if (!oldName.equals(newMed.getName()) && model.isExist(newMed.getName())) {
            throw new Exception("이미 존재하는 약 이름입니다.");
        }

        // 수정 반영
        medicineList.remove(oldName);
        medicineList.put(newMed.getName(), newMed);
    }
}
