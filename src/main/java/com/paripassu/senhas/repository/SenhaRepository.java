package com.paripassu.senhas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.paripassu.senhas.models.Senha;

public interface SenhaRepository extends JpaRepository<Senha, Long> {
	@Modifying
	@Transactional
	@Query(value = "ALTER SEQUENCE hibernate_sequence RESTART WITH 1", nativeQuery = true)
	void resetKey();
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE senha SET status = 1 WHERE senha.id = :id", nativeQuery = true)
	void alterarStatus(@Param("id") long id);
	
	@Query(value = "SELECT * FROM senha WHERE senha.status = 1", nativeQuery = true)
	Senha findByStatus();
	
	@Query(value = "SELECT * FROM senha WHERE senha.status = 0 ORDER BY senha.tipo_senha_id ASC, senha.id ASC", nativeQuery = true)
	List<Senha> findProximasSenha();
}
