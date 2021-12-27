package br.com.novenovejobs.cadastro.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.novenovejobs.cadastro.dto.UsuarioDTO;
import br.com.novenovejobs.cadastro.entity.UsuarioEntity;
import br.com.novenovejobs.cadastro.repository.UsuarioRepository;
import br.com.novenovejobs.cadastro.service.UsuarioService;

@RestController
@RequestMapping("/cadastro")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioEntity cadastrarUsuario(@RequestBody UsuarioEntity usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@GetMapping
	public List<UsuarioEntity> listarTodosUsuarios () {
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{cpf}")
	public ResponseEntity<UsuarioDTO> pegarUsuarioPorCpf(@PathVariable String cpf) throws NotFoundException {
		try {
			return ResponseEntity.ok(usuarioService.retornaUsuarioPorCpf(cpf));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{cpf}")
	@Transactional
	public ResponseEntity<UsuarioDTO> atualizar(@PathVariable String cpf,
								  @RequestBody UsuarioDTO usuarioDTO) throws NotFoundException{
		UsuarioDTO usuarioAtualizado = usuarioService.atualizar(cpf, usuarioDTO);
		return ResponseEntity.ok(usuarioAtualizado);
	}
	
	@DeleteMapping("/{cpf}")
	@Transactional
	public ResponseEntity<UsuarioDTO> deletar(@PathVariable String cpf)
			throws NotFoundException{
		try {
			usuarioService.deletar(cpf);
			return ResponseEntity.ok().build();
		} catch (NotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
		
	}	

}
