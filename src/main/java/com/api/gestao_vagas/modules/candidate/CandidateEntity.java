package com.api.gestao_vagas.modules.candidate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "candidate")
// isso defini que todos os campos serão nomeado no banco no mesmo modelo.
// Para mudar basta mapear com @Column(name = [nome])
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    // Sempre que houver um novo dado no banco, irá criar um valor automaticamente.
    private UUID id;
    private String name;
    @Pattern(regexp = "\\S+", message = "o campo [username] não deve ter espaços em branco")
    private String username;
    @Email(message = "o campo [email] está inválido")
    private String email;
    @Length(min = 10, max = 100)
    private String password;
    private String description;
    private String curriculum;

    @CreationTimestamp
    // Seta o horário que é criado a entidade.
    private LocalDateTime createdAt;
}
