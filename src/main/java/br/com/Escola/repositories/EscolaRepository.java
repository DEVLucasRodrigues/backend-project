package br.com.Escola.repositories;

import br.com.Escola.model.EscolaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscolaRepository extends JpaRepository<EscolaModel, Integer> {
    public Page<EscolaModel> findAll(Pageable pageable);

    public Page<EscolaModel> findByNameStartsWithIgnoreCase(String name, Pageable pageable);
}
