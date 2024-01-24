package com.api.gestao_vagas.modules.candidate.services;

import com.api.gestao_vagas.modules.candidate.CandidateEntity;
import com.api.gestao_vagas.modules.candidate.CandidateRepository;
import com.api.gestao_vagas.modules.candidate.exceptions.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository repository;

    public List<CandidateEntity> listAll() {
        return this.repository.findAll();
    }
    public CandidateEntity create(CandidateEntity candidate) {
        this.repository.findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail()).ifPresent(
                (user) -> {
                    throw new UserFoundException(user);
                }
        );
        return this.repository.save(candidate);
    }
}
