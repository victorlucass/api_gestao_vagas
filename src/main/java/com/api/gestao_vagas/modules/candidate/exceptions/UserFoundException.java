package com.api.gestao_vagas.modules.candidate.exceptions;

import com.api.gestao_vagas.modules.candidate.CandidateEntity;

public class UserFoundException extends RuntimeException{
    public UserFoundException(CandidateEntity candidate) {
        super("username ou email já cadastrado");
    }
}
