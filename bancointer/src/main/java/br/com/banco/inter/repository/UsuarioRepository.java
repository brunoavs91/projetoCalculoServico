package br.com.banco.inter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.banco.inter.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

}
