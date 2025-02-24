package net.physiqueForge.ems.controller;

import lombok.RequiredArgsConstructor;
import net.physiqueForge.ems.dto.trainer.TrainerRequestDTO;
import net.physiqueForge.ems.dto.trainer.TrainerResponseDTO;
import net.physiqueForge.ems.service.TrainerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainers")
@RequiredArgsConstructor
public class TrainerController {

    private final TrainerService trainerService;

    @GetMapping
    public ResponseEntity<List<TrainerResponseDTO>> getAllTrainers() {
        return ResponseEntity.ok(trainerService.getAllTrainers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainerResponseDTO> getTrainerById(@PathVariable Long id) {
        return ResponseEntity.ok(trainerService.getTrainerById(id));
    }

    @PostMapping
    public ResponseEntity<TrainerResponseDTO> createTrainer(@RequestBody TrainerRequestDTO trainerDTO) {
        return ResponseEntity.ok(trainerService.createTrainer(trainerDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainerResponseDTO> updateTrainer(@PathVariable Long id, @RequestBody TrainerRequestDTO trainerDTO) {
        return ResponseEntity.ok(trainerService.updateTrainer(id, trainerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainer(@PathVariable Long id) {
        trainerService.deleteTrainer(id);
        return ResponseEntity.noContent().build();
    }
}