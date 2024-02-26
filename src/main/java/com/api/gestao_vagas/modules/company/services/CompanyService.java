package com.api.gestao_vagas.modules.company.services;

import com.api.gestao_vagas.modules.candidate.exceptions.UserFoundException;
import com.api.gestao_vagas.modules.company.entities.CompanyEntity;
import com.api.gestao_vagas.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository repository;

    public CompanyEntity create(CompanyEntity company){
        this.repository.findByUsernameOrEmail(company.getUsername(), company.getEmail())
                .ifPresent(
                        (user) -> {
                            throw new UserFoundException();
                        }
                );
        return this.repository.save(company);
    };
}
