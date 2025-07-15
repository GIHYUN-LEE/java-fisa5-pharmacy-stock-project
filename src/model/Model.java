package model;
import java.util.HashMap;
import domain.Medicine;
public class Model {
    
    private static Model model = new Model();
    
    private Model() {}
    
    public static HashMap<String, Medicine> getMedicineList() throws Exception {
        return MedicineDAO.getAllMedicines();
    }

    public static boolean isExist(String medicineName) throws Exception {
        HashMap<String, Medicine> medicineList = MedicineDAO.getAllMedicines();
        return medicineList.containsKey(medicineName);
    }


    // 약 삽입
    public static void insertMedicine(Medicine medicine) throws Exception {
        if (medicine.getPrice() <= 0 || medicine.getAmount() < 0) {
            throw new Exception("올바르지 않는 값입니다.");
        }

        // DB에 반영
        boolean success = MedicineDAO.insertMedicine(medicine);
        if (!success) {
            throw new Exception("DB 삽입 실패");
        }
    }

    // 약 삭제
    public static void deleteMedicine(String name) {
        HashMap<String, Medicine> medicineList = MedicineDAO.deleteMedicine(name);
        
      
    }

    // 약 정보 수정
    public static void editMedicine(String oldName, Medicine newMed) throws Exception {

        // 존재 여부 확인
        if (!isExist(oldName)) {
            throw new Exception("존재하지 않는 약 입니다.");
        }

        // 이름 변경 시 중복 방지
        if (!oldName.equals(newMed.getName()) && isExist(newMed.getName())) {
            throw new Exception("이미 존재하는 약 이름입니다.");
        }

    }
}
