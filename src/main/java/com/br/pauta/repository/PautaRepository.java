package com.br.pauta.repository;

import com.br.pauta.document.Pauta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository  extends MongoRepository<Pauta, String> {
}
