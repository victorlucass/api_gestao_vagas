package com.api.gestao_vagas.modules.candidate.controllers;

import com.api.gestao_vagas.modules.candidate.CandidateEntity;
import com.api.gestao_vagas.modules.candidate.CandidateRepository;
import com.api.gestao_vagas.modules.candidate.exceptions.UserFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateRepository repository;

    @GetMapping
    public ResponseEntity<List<CandidateEntity>> getCandidate() {
        List<CandidateEntity> list = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping
    public void create(@Valid @RequestBody CandidateEntity candidate) {
        this.repository.findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail()).ifPresent(
                (user) -> {
                    throw new UserFoundException();
                }
        );
        this.repository.save(candidate);
    }


}
