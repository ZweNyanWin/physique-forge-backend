package net.physiqueForge.ems.mapper;

import net.physiqueForge.ems.dto.trainer.TrainerRequestDTO;
import net.physiqueForge.ems.dto.trainer.TrainerResponseDTO;
import net.physiqueForge.ems.model.Trainer;
import org.springframework.stereotype.Component;

@Component
public class TrainerMapper {

    public TrainerResponseDTO toResponseDTO(Trainer trainer) {
        if (trainer == null) {
            return null;
        }
        TrainerResponseDTO dto = new TrainerResponseDTO();
        dto.setId(trainer.getId());
        dto.setName(trainer.getName());
        dto.setEmail(trainer.getEmail());
        dto.setDateOfBirth(trainer.getDateOfBirth()); // Direct mapping
        dto.setSpecialization(trainer.getSpecialization());
        dto.setExperience(trainer.getExperience());
        dto.setApprovedById(trainer.getApprovedBy() != null ? trainer.getApprovedBy().getId() : null);
        return dto;
    }

    public Trainer toEntity(TrainerRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        Trainer trainer = new Trainer();
        trainer.setName(dto.getName());
        trainer.setEmail(dto.getEmail());
        trainer.setDateOfBirth(dto.getDateOfBirth()); // Ensure valid format before saving
        trainer.setSpecialization(dto.getSpecialization());
        trainer.setExperience(dto.getExperience());
        return trainer;
    }

    public void updateTrainerFromDTO(TrainerRequestDTO dto, Trainer trainer) {
        trainer.setName(dto.getName());
        trainer.setEmail(dto.getEmail());
        trainer.setDateOfBirth(dto.getDateOfBirth());
        trainer.setSpecialization(dto.getSpecialization());
        trainer.setExperience(dto.getExperience());
    }
}