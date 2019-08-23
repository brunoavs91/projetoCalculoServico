package br.com.banco.inter.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idUsuario;
	
	@NotNull
	@Column
	private String nome;
	
	@NotNull
	@Column
	private String email;
	
	@OneToMany(mappedBy = "usuario", targetEntity = DigitoUnico.class, fetch =
			FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DigitoUnico> listaDigitoUnico;
	
	

	public Long getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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

	public List<DigitoUnico> getListaDigitoUnico() {
		return listaDigitoUnico;
	}

	public void setListaDigitoUnico(List<DigitoUnico> listaDigitoUnico) {
		this.listaDigitoUnico = listaDigitoUnico;
	}
	
}