package br.com.awebmeu.sistema_aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.awebmeu.sistema_aluno.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    
}
