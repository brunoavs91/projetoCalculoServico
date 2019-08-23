package br.com.banco.inter.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.banco.inter.dto.DigitoUnicoDTO;
import br.com.banco.inter.dto.UsuarioDTO;
import br.com.banco.inter.entity.DigitoUnico;
import br.com.banco.inter.entity.Usuario;

@Service
public class UsuarioConverter {

	
	
	public UsuarioDTO converterUsuarioEntityToDTO(Usuario usuario) {
		
		UsuarioDTO usuarioDTO = new UsuarioDTO();


		usuarioDTO.setIdUsuarioDTO(usuario.getIdUsuario() != null ? usuario.getIdUsuario() : null);
		usuarioDTO.setNome(usuario.getNome() != null ? usuario.getNome() : null);
		usuarioDTO.setEmail(usuario.getEmail() != null ? usuario.getEmail() : null);
		
		usuarioDTO.setListaDigitoUnico(new ArrayList<>());

		if (usuario.getListaDigitoUnico() != null && 
				!usuario.getListaDigitoUnico().isEmpty()) {

			for (DigitoUnico digito : usuario.getListaDigitoUnico()) {
				DigitoUnicoDTO digitoUnicoDTO= new DigitoUnicoDTO();
				digitoUnicoDTO.setIdDigitoUnicoDTO(digito.getIdDigitoUnico()!= null? digito.getIdDigitoUnico():null);
				digitoUnicoDTO.setDigitoUnico(digito.getDigitoUnico() != null?digito.getDigitoUnico():null);
				digitoUnicoDTO.setMultiplicador(digito.getMultiplicador() != null? digito.getMultiplicador():null);
				digitoUnicoDTO.setResultado(digito.getResultado()!= null? digito.getResultado():null);
				
				usuarioDTO.getListaDigitoUnico().add(digitoUnicoDTO);
				
			}
		}
		return usuarioDTO;
	}
	
	public Usuario converterUsuarioDtoToEntity(UsuarioDTO usuarioDTO) {

		Usuario usuario = new Usuario();

		usuario.setIdUsuario(usuarioDTO.getIdUsuarioDTO() != null ? usuarioDTO.getIdUsuarioDTO() : null);
		usuario.setNome(usuarioDTO.getNome() != null ? usuarioDTO.getNome() : null);
		usuario.setEmail(usuarioDTO.getEmail() != null ? usuarioDTO.getEmail() : null);
		usuario.setListaDigitoUnico(new ArrayList<>());

		if (usuarioDTO.getListaDigitoUnico() != null &&
				!usuarioDTO.getListaDigitoUnico().isEmpty()) {

			for (DigitoUnicoDTO digitoDTO : usuarioDTO.getListaDigitoUnico()) {
				DigitoUnico digitoUnico = new DigitoUnico();

				digitoUnico.setIdDigitoUnico(
						digitoDTO.getIdDigitoUnicoDTO() != null ? digitoDTO.getIdDigitoUnicoDTO() : null);
				digitoUnico.setDigitoUnico(digitoDTO.getDigitoUnico() != null ? digitoDTO.getDigitoUnico() : null);
				digitoUnico
						.setMultiplicador(digitoDTO.getMultiplicador() != null ? digitoDTO.getMultiplicador() : null);
				digitoUnico.setResultado(digitoDTO.getResultado() != null ? digitoDTO.getResultado() : null);

				usuario.getListaDigitoUnico().add(digitoUnico);

			}
		
		}

		return usuario;
	}

	public List<UsuarioDTO> converterListaEntityToDTO(List<Usuario>listaUsuario){
		List<UsuarioDTO>listaDTO= new ArrayList<>();
		
		for(Usuario usuario:listaUsuario) {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setIdUsuarioDTO(usuario.getIdUsuario() != null ? usuario.getIdUsuario() : null);
			usuarioDTO.setNome(usuario.getNome() != null ? usuario.getNome() : null);
			usuarioDTO.setEmail(usuario.getEmail() != null ? usuario.getEmail() : null);
			
			listaDTO.add(usuarioDTO);
		}
		
		return listaDTO;
	}
}
