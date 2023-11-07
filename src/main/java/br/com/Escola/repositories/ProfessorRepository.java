package br.com.Escola.repositories;

import br.com.Escola.model.ProfessorModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorModel, Integer> {
    public Page<ProfessorModel> findAll(Pageable pageable);

    public Page<ProfessorModel> findByNameStartsWithIgnoreCase(String name, Pageable pageable);
}
