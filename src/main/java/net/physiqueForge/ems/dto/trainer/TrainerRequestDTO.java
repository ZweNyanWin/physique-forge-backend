package net.physiqueForge.ems.dto.trainer;

import jakarta.validation.constraints.Email;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class TrainerRequestDTO {
        @NotBlank(message = "Name is required")
        private String name;

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        private String email;

        @NotBlank(message = "Date of Birth is required")
        private String dateOfBirth; // String format to be parsed later

        @NotBlank(message = "Specialization is required")
        private String specialization;

        @NotNull(message = "Experience cannot be null")
        private Long experience;

        private Long approvedById;
    }
