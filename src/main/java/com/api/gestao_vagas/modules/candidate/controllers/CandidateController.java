package com.api.gestao_vagas.modules.candidate.controllers;

import com.api.gestao_vagas.modules.candidate.CandidateEntity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @GetMapping
    public ResponseEntity<Object> getCandidate() {
        return ResponseEntity.status(HttpStatus.OK).body("Deu bom!!");
    }

    @PostMapping
    public void create(@Valid @RequestBody CandidateEntity candidate) {
        System.out.print("deu erro!");
    }


}
