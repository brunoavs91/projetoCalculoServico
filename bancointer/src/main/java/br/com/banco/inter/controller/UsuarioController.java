package br.com.banco.inter.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.inter.converter.UsuarioConverter;
import br.com.banco.inter.dto.UsuarioDTO;
import br.com.banco.inter.entity.Usuario;
import br.com.banco.inter.exception.BancoInterException;
import br.com.banco.inter.repository.UsuarioRepository;
import br.com.banco.inter.service.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {


	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioConverter usuarioConverter;

	@Autowired
	private UsuarioService usuarioService;

	

	@PostMapping("/salvar")
	public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioConverter.converterUsuarioDtoToEntity(usuarioDTO);
		usuario = usuarioRepository.save(usuario);

		UsuarioDTO usuarioSalvo = usuarioConverter.converterUsuarioEntityToDTO(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}

	@PutMapping("atualizar/{id}")
	public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
		try {
			UsuarioDTO usuario = usuarioService.atualizarUsuario(usuarioDTO);
			return ResponseEntity.status(HttpStatus.OK).body(usuario);
		} catch (BancoInterException e) {
			return ResponseEntity.status(e.getStatus()).build();
		}
	}

	@DeleteMapping("excluir/{id}")
	public ResponseEntity<?> excluirUsuario(@PathVariable Long id) {
		try {
			usuarioService.excluirUsuarioById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (BancoInterException e) {

			return ResponseEntity.status(e.getStatus()).build();
		}

	}

	@GetMapping("/buscarusuario/{id}")
	public ResponseEntity<UsuarioDTO> buscaUsuarioPeloCodigo(@PathVariable Long id) {
		
		try {
			
			UsuarioDTO usuarioDTO=usuarioService.buscarUsuarioById(id);
			
			return ResponseEntity.status(HttpStatus.OK).body(usuarioDTO);
			
		}catch (BancoInterException e) {
			
			return ResponseEntity.status(e.getStatus()).build();
		}
	}

	@GetMapping("/listausuario")
	public ResponseEntity<List<UsuarioDTO>> buscarListaUsuario() {

		try {
			List<UsuarioDTO> listaUsuarioDTO = usuarioService.buscarListaUsuario();

			return ResponseEntity.status(HttpStatus.OK).body(listaUsuarioDTO);
		} catch (BancoInterException e) {

			return ResponseEntity.status(e.getStatus()).build();
		}
	}
}
