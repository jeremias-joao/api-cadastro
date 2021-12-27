package br.com.novenovejobs.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.novenovejobs.cadastro.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends  JpaRepository<UsuarioEntity, Long> {

	void deleteByCpf(String cpf);

	UsuarioEntity findByCpf(String cpf);


}
