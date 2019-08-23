package br.com.banco.inter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.banco.inter.dto.DigitoUnicoDTO;
import br.com.banco.inter.exception.BancoInterException;

@Service
public interface DigitoUnicoService {

	/**
	 * Calculo do digito unico
	 * @param digitoUnicoDTO
	 * @return
	 */
	public DigitoUnicoDTO calculoDigitoUnico(DigitoUnicoDTO digitoUnicoDTO) throws BancoInterException;
	
	public List<DigitoUnicoDTO>listaDigitoUnico();
	
	public List<DigitoUnicoDTO> buscarDigitoUnicoByUser(Long id);
}