package net.physiqueForge.ems.service;

import net.physiqueForge.ems.dto.trainer.TrainerRequestDTO;
import net.physiqueForge.ems.dto.trainer.TrainerResponseDTO;
import java.util.List;

public interface TrainerService {
    List<TrainerResponseDTO> getAllTrainers();
    TrainerResponseDTO getTrainerById(Long id);
    TrainerResponseDTO createTrainer(TrainerRequestDTO trainerDTO);
    TrainerResponseDTO updateTrainer(Long id, TrainerRequestDTO trainerDTO);
    void deleteTrainer(Long id);
}