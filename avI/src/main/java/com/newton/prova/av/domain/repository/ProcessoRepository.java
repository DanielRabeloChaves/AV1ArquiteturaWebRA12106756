package com.newton.prova.av.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.newton.prova.av.domain.entity.Processo;

public interface ProcessoRepository extends MongoRepository<Processo, String>{

}

