package com.example.demo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {


    private final MedicineRepository medicineRepository;

    public MedicineController(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }


    @Operation(summary = "Save a new medicine", description = "Add a new medicine by providing its content.")
    @PostMapping("/{content}")
    public Medicine saveMedicine(@PathVariable String content) {
        Medicine medicine = new Medicine();
        medicine.setContent(content);
        return medicineRepository.save(medicine); // DB에 저장
    }

    @Operation(summary = "Get all medicines", description = "Retrieve a list of all medicines.")
    // 전체 약물 조회 API
    @GetMapping
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll(); // DB에서 전체 데이터 조회
    }
}
