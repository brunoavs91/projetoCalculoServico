package br.com.banco.inter.dto;

import java.util.List;

public class UsuarioDTO {

	private Long idUsuarioDTO;

	private String nome;

	private String email;

	private List<DigitoUnicoDTO> listaDigitoUnico;

	public UsuarioDTO() {
	}

	public Long getIdUsuarioDTO() {
		return idUsuarioDTO;
	}

	public void setIdUsuarioDTO(Long idUsuarioDTO) {
		this.idUsuarioDTO = idUsuarioDTO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<DigitoUnicoDTO> getListaDigitoUnico() {
		return listaDigitoUnico;
	}

	public void setListaDigitoUnico(List<DigitoUnicoDTO> listaDigitoUnico) {
		this.listaDigitoUnico = listaDigitoUnico;
	}

}
