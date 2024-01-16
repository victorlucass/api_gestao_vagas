package com.api.gestao_vagas.modules.candidate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class CandidateEntity {
    private UUID id;
    private String name;

    @Pattern(regexp = "^(?!\\s*$).+", message = "o campo [username] não deve ter espaços em branco")
    private String username;

    @Email(message = "o campo [email] está inválido")
    private String email;

    @Length(min = 10, max = 100)
    private String password;
    private String description;
    private String curriculum;
}
