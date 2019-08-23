package br.com.banco.inter.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_DIGITO_UNICO")
public class DigitoUnico {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idDigitoUnico;
	
	@Column
	private BigDecimal numeroDigitado;
	
	@Column
	private BigDecimal digitoUnico;
	
	@Column
	private BigDecimal multiplicador;
	
	@Column
	private BigDecimal resultado;

	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;
	
	
	

	public BigDecimal getNumeroDigitado() {
		return numeroDigitado;
	}

	public void setNumeroDigitado(BigDecimal numeroDigitado) {
		this.numeroDigitado = numeroDigitado;
	}

	public Long getIdDigitoUnico() {
		return idDigitoUnico;
	}

	public void setIdDigitoUnico(Long idDigitoUnico) {
		this.idDigitoUnico = idDigitoUnico;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
