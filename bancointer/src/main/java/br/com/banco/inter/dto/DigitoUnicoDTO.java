package br.com.banco.inter.dto;

import java.math.BigDecimal;

public class DigitoUnicoDTO {


	private Long idDigitoUnicoDTO;
	
	private BigDecimal numero;
	
	private BigDecimal digitoUnico;
	
	private BigDecimal multiplicador;
	
	private BigDecimal resultado;
	
	private Long idUsuario;
	
	public DigitoUnicoDTO() {}
	

	public Long getIdDigitoUnicoDTO() {
		return idDigitoUnicoDTO;
	}

	public void setIdDigitoUnicoDTO(Long idDigitoUnicoDTO) {
		this.idDigitoUnicoDTO = idDigitoUnicoDTO;
	}


	public BigDecimal getDigitoUnico() {
		return digitoUnico;
	}


	public void setDigitoUnico(BigDecimal digitoUnico) {
		this.digitoUnico = digitoUnico;
	}


	public BigDecimal getMultiplicador() {
		return multiplicador;
	}


	public void setMultiplicador(BigDecimal multiplicador) {
		this.multiplicador = multiplicador;
	}


	public BigDecimal getResultado() {
		return resultado;
	}


	public void setResultado(BigDecimal resultado) {
		this.resultado = resultado;
	}


	public Long getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}


	public BigDecimal getNumero() {
		return numero;
	}


	public void setNumero(BigDecimal numero) {
		this.numero = numero;
	}

	
}
