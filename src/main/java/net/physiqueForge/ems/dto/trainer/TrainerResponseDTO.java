package net.physiqueForge.ems.dto.trainer;

import lombok.Data;

@Data
public class TrainerResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String dateOfBirth;
    private String specialization;
    private long experience;
    private Long approvedById;
}