package br.com.banco.inter.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import br.com.banco.inter.converter.UsuarioConverter;
import br.com.banco.inter.dto.UsuarioDTO;
import br.com.banco.inter.entity.Usuario;
import br.com.banco.inter.exception.BancoInterException;
import br.com.banco.inter.repository.UsuarioRepository;
import br.com.banco.inter.service.UsuarioService;

@Component
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioConverter usuarioConverter;

	@Override
	public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) throws BancoInterException {
		
		Usuario usuario = usuarioRepository.findById(usuarioDTO.getIdUsuarioDTO())
				.orElseThrow(() -> new BancoInterException("Usuario não encontrado",HttpStatus.NOT_FOUND));
		
		
		atualizar(usuario,usuarioDTO);
		
		usuarioRepository.save(usuario);
		
		return usuarioConverter.converterUsuarioEntityToDTO(usuario);
	}

	private void atualizar(Usuario usuario,UsuarioDTO usuarioDTO) {
		
		if(!usuario.getEmail().equals(usuarioDTO.getEmail())){
			usuario.setEmail(usuarioDTO.getEmail());
		}
		if(!usuario.getNome().equals(usuarioDTO.getNome())) {
			usuario.setNome(usuarioDTO.getNome());
		}
		
	}

	@Override
	public List<UsuarioDTO> buscarListaUsuario() throws BancoInterException {

		List<Usuario> listaUsuario = usuarioRepository.findAll();

		if (listaUsuario.isEmpty()) {
			throw new BancoInterException("Lista Vazia", HttpStatus.NOT_FOUND);
		}

		return usuarioConverter.converterListaEntityToDTO(listaUsuario);
	}

	@Override
	public UsuarioDTO buscarUsuarioById(Long idUsuario) throws BancoInterException{
		Usuario usuario= usuarioRepository.findById(idUsuario)
				.orElseThrow(()->new BancoInterException("Usuario não encontrado", HttpStatus.NOT_FOUND));
		
		return usuarioConverter.converterUsuarioEntityToDTO(usuario);
	}

	@Override
	public void excluirUsuarioById(Long idUsuario) {
	usuarioRepository.deleteById(idUsuario);
	}

}
