package com.api.gestao_vagas.modules.candidate.controllers;

import com.api.gestao_vagas.modules.candidate.CandidateEntity;
import com.api.gestao_vagas.modules.candidate.exceptions.UserFoundException;
import com.api.gestao_vagas.modules.candidate.services.CandidateService;
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
    private CandidateService service;

    @GetMapping
    public ResponseEntity<List<CandidateEntity>> getCandidate() {
        List<CandidateEntity> list = service.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidate) {
        try {
            CandidateEntity newCandidate = this.service.create(candidate);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCandidate);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
