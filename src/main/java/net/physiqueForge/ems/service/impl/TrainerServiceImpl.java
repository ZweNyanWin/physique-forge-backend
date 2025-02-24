package net.physiqueForge.ems.service.impl;

import lombok.RequiredArgsConstructor;
import net.physiqueForge.ems.dto.trainer.TrainerRequestDTO;
import net.physiqueForge.ems.dto.trainer.TrainerResponseDTO;
import net.physiqueForge.ems.mapper.TrainerMapper;
import net.physiqueForge.ems.model.Trainer;
import net.physiqueForge.ems.repository.TrainerRepository;
import net.physiqueForge.ems.service.TrainerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainerServiceImpl implements TrainerService {

    private final TrainerRepository trainerRepository;
    private final TrainerMapper trainerMapper;

    @Override
    public List<TrainerResponseDTO> getAllTrainers() {
        return trainerRepository.findAll()
                .stream()
                .map(trainerMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TrainerResponseDTO getTrainerById(Long id) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
        return trainerMapper.toResponseDTO(trainer);
    }

    @Override
    public TrainerResponseDTO createTrainer(TrainerRequestDTO trainerDTO) {
        Trainer trainer = trainerMapper.toEntity(trainerDTO);
        trainer = trainerRepository.save(trainer);
        return trainerMapper.toResponseDTO(trainer);
    }

    @Override
    public TrainerResponseDTO updateTrainer(Long id, TrainerRequestDTO trainerDTO) {
        Trainer existingTrainer = trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));

        trainerMapper.updateTrainerFromDTO(trainerDTO, existingTrainer);
        Trainer updatedTrainer = trainerRepository.save(existingTrainer);
        return trainerMapper.toResponseDTO(updatedTrainer);
    }

    @Override
    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }
}