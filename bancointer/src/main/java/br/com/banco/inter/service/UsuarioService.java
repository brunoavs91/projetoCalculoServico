package br.com.banco.inter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.banco.inter.dto.UsuarioDTO;
import br.com.banco.inter.exception.BancoInterException;

@Service
public interface UsuarioService {

	/**
	 * 
	 * @param usuarioDTO
	 * @return
	 * @throws BancoInterException
	 */
	public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) throws BancoInterException;
	
	/**
	 * 
	 * @return
	 */
	public List<UsuarioDTO> buscarListaUsuario()throws BancoInterException;
	
	/**
	 * 
	 * @param idUsuario
	 * @return
	 */
	public UsuarioDTO buscarUsuarioById(Long idUsuario);
	
	/**
	 * 
	 * @param idUsuario
	 */
	public void excluirUsuarioById(Long idUsuario);
}