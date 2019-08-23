package br.com.banco.inter.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.banco.inter.dto.DigitoUnicoDTO;
import br.com.banco.inter.dto.UsuarioDTO;
import br.com.banco.inter.entity.DigitoUnico;
import br.com.banco.inter.entity.Usuario;
import br.com.banco.inter.exception.BancoInterException;
import br.com.banco.inter.repository.UsuarioRepository;

@Service
public class DigitoUnicoConverter {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public DigitoUnicoDTO converterDigitoUnicoEntityToDTO(DigitoUnico digitoUnico) {
		
		DigitoUnicoDTO digitoUnicoDTO= new DigitoUnicoDTO();
		
		digitoUnicoDTO.setNumero(digitoUnico.getNumeroDigitado() != null?digitoUnico.getNumeroDigitado(): null);
		digitoUnicoDTO.setIdDigitoUnicoDTO(digitoUnico.getIdDigitoUnico() != null ?digitoUnico.getIdDigitoUnico():null);
		digitoUnicoDTO.setDigitoUnico(digitoUnico.getDigitoUnico() != null ? digitoUnico.getDigitoUnico():null);
		digitoUnicoDTO.setMultiplicador(digitoUnico.getMultiplicador() != null? digitoUnico.getMultiplicador() : null);
		digitoUnicoDTO.setResultado(digitoUnico.getResultado() != null ? digitoUnico.getResultado():null);
		digitoUnicoDTO.setIdUsuario(digitoUnico.getUsuario().getIdUsuario() 
				!=null?digitoUnico.getUsuario().getIdUsuario():null);
		
		return digitoUnicoDTO;
	}

	public DigitoUnico converterDigitoUnicoDtoToEntity(DigitoUnicoDTO digitoUnicoDTO) {
		
		DigitoUnico digitoUnico= new DigitoUnico();
		
		digitoUnico.setNumeroDigitado(digitoUnicoDTO.getNumero()!= null? digitoUnicoDTO.getNumero():null);
		digitoUnico.setIdDigitoUnico(digitoUnicoDTO.getIdDigitoUnicoDTO() != null ? digitoUnicoDTO.getIdDigitoUnicoDTO():null);;
		digitoUnico.setDigitoUnico(digitoUnicoDTO.getDigitoUnico() != null ? digitoUnicoDTO.getDigitoUnico(): null);
		digitoUnico.setMultiplicador(digitoUnicoDTO.getMultiplicador() != null ? digitoUnicoDTO.getMultiplicador():null);
		digitoUnico.setResultado(digitoUnicoDTO.getResultado()!= null? digitoUnicoDTO.getResultado() : null);
		
		if(digitoUnicoDTO.getIdUsuario() != null) {
			digitoUnico.setUsuario(buscarUsuarioPeloID(digitoUnicoDTO.getIdUsuario()));
		}
		
		return digitoUnico;
		
	}
	public Usuario buscarUsuarioPeloID(Long id) {
		//Criar exceçao da aplicaçao
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new BancoInterException("Erro ao encontrar Usuario",HttpStatus.NOT_FOUND));
	}
	
	public List<DigitoUnicoDTO> converterListaEntityToDTO(List<DigitoUnico> listaDigitoUnico) {
		List<DigitoUnicoDTO> listaDTO = new ArrayList<>();

		for (DigitoUnico digitoUnico : listaDigitoUnico) {
			DigitoUnicoDTO digitoUnicoDTO = new DigitoUnicoDTO();
			digitoUnicoDTO.setNumero(digitoUnico.getNumeroDigitado() != null ? digitoUnico.getNumeroDigitado() : null);
			digitoUnicoDTO.setIdDigitoUnicoDTO(
					digitoUnico.getIdDigitoUnico() != null ? digitoUnico.getIdDigitoUnico() : null);
			digitoUnicoDTO.setDigitoUnico(digitoUnico.getDigitoUnico() != null ? digitoUnico.getDigitoUnico() : null);
			digitoUnicoDTO
					.setMultiplicador(digitoUnico.getMultiplicador() != null ? digitoUnico.getMultiplicador() : null);
			digitoUnicoDTO.setResultado(digitoUnico.getResultado() != null ? digitoUnico.getResultado() : null);
			digitoUnicoDTO.setIdUsuario(
					digitoUnico.getUsuario().getIdUsuario() != null ? digitoUnico.getUsuario().getIdUsuario() : null);

			listaDTO.add(digitoUnicoDTO);
		}

		return listaDTO;
	}
}
