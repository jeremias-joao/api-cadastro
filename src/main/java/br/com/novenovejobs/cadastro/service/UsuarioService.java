package br.com.novenovejobs.cadastro.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.novenovejobs.cadastro.dto.UsuarioDTO;
import br.com.novenovejobs.cadastro.entity.UsuarioEntity;
import br.com.novenovejobs.cadastro.repository.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UsuarioDTO retornaUsuarioPorCpf(String cpf) throws NotFoundException {
		UsuarioEntity usuario =  usuarioRepository.findByCpf(cpf); 
		UsuarioDTO usuarioDTO = converterParaDto(usuario);
		if (usuarioDTO == null) {
			throw new NotFoundException();
		}
		return usuarioDTO;
	}
	
	public UsuarioDTO salvarAutorDTO(UsuarioDTO usuarioDTO) {
		try {
			UsuarioEntity usuario = usuarioRepository.save(converParaEntity(usuarioDTO));
			UsuarioDTO autorDtoSalvo = converterParaDto(usuario);
			return autorDtoSalvo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public UsuarioDTO atualizar(String cpf, UsuarioDTO usuarioDTO) throws NotFoundException {
		
		UsuarioEntity usuario = usuarioRepository.findByCpf(cpf);
			
		UsuarioDTO autorDtoAntigo = converterParaDto(usuario);
			
		BeanUtils.copyProperties(usuarioDTO, autorDtoAntigo, "cpf");
		UsuarioEntity convertEntity = converParaEntity(usuarioDTO);
			
		convertEntity.setId(usuario.getId());
		UsuarioEntity usuarioAtualizado  = usuarioRepository.save(convertEntity);
		
		return converterParaDto(usuarioAtualizado);
	}
	
	
	public void deletar(String cpf) throws NotFoundException {
		try {
			UsuarioDTO usuarioDTO = retornaUsuarioPorCpf(cpf);
			if(usuarioDTO == null) {
				throw new NotFoundException();
			}
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		usuarioRepository.deleteByCpf(cpf);
	}
	
	
	private UsuarioDTO converterParaDto(UsuarioEntity usuario) {
		return modelMapper.map(usuario, UsuarioDTO.class);
	}
	
	
	private UsuarioEntity converParaEntity(UsuarioDTO usuarioDTO) {
		return modelMapper.map(usuarioDTO, UsuarioEntity.class);
	}
	
	

}
