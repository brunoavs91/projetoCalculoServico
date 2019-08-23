package br.com.banco.inter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.banco.inter.entity.DigitoUnico;

@Repository
public interface DigitoUnicoRepository extends JpaRepository<DigitoUnico,Long>{

}
