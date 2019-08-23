package br.com.banco.inter.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import br.com.banco.inter.converter.DigitoUnicoConverter;
import br.com.banco.inter.dto.DigitoUnicoDTO;
import br.com.banco.inter.entity.DigitoUnico;
import br.com.banco.inter.entity.Usuario;
import br.com.banco.inter.exception.BancoInterException;
import br.com.banco.inter.repository.DigitoUnicoRepository;
import br.com.banco.inter.repository.UsuarioRepository;
import br.com.banco.inter.service.DigitoUnicoService;

@Component
public class DigitoUnicoServiceImpl implements DigitoUnicoService {

	@Autowired
	private DigitoUnicoRepository digitoUnicoRepository;

	@Autowired
	private DigitoUnicoConverter digitoUnicoConverter;
	
	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public DigitoUnicoDTO calculoDigitoUnico(DigitoUnicoDTO digitoUnicoDTO){

		Usuario usuario= UsuarioRepository.findById(digitoUnicoDTO.getIdUsuario())
				.orElseThrow(() -> new BancoInterException("Usuario não encontrado", HttpStatus.NOT_FOUND));
		
		DigitoUnico digitoUnicoEntity = new DigitoUnico();
		
		BigDecimal numeroDigitado = BigDecimal.ZERO;
		
		digitoUnicoEntity.setUsuario(usuario);
		digitoUnicoEntity.setMultiplicador(digitoUnicoDTO.getMultiplicador());
		digitoUnicoEntity.setNumeroDigitado(digitoUnicoDTO.getNumero());
		digitoUnicoEntity
				.setResultado(resultadoConcatenado(digitoUnicoDTO.getNumero(), digitoUnicoDTO.getMultiplicador()));

		numeroDigitado = pegarDigitoUnico(digitoUnicoDTO.getNumero());
		// pegando o valor final com a recursividade
		digitoUnicoEntity.setDigitoUnico(pegarDigitoUnico(numeroDigitado));

		digitoUnicoEntity = digitoUnicoRepository.save(digitoUnicoEntity);

		return digitoUnicoConverter.converterDigitoUnicoEntityToDTO(digitoUnicoEntity);
	}

	private BigDecimal pegarDigitoUnico(BigDecimal numero) {

		String numeroString = numero.toPlainString();

		List<BigDecimal> listaNumeros = new ArrayList<>();
		// quebrando a string em numeros

		for (int i = 0; i < numeroString.length(); i++) {

			listaNumeros.add(new BigDecimal(String.valueOf(numeroString.charAt(i))));
		}
		BigDecimal somaNumeros = listaNumeros.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

		return somaNumeros;
	}

	private BigDecimal resultadoConcatenado(BigDecimal numeroDigitado, BigDecimal repeticoes) {

		BigDecimal resultado = BigDecimal.ZERO;

		StringBuilder concatenar = new StringBuilder();

		for (int i = 0; i < repeticoes.intValue(); i++) {
			concatenar.append(numeroDigitado);
		}
		BigDecimal numeroConcatenado = new BigDecimal(concatenar.toString());

		numeroConcatenado = pegarDigitoUnico(numeroConcatenado);

		resultado = pegarDigitoUnico(numeroConcatenado);

		return resultado;

	}

	@Override
	public List<DigitoUnicoDTO> listaDigitoUnico() {
		List<DigitoUnico> listaDigitos = digitoUnicoRepository.findAll();

		if (listaDigitos.isEmpty()) {
			throw new BancoInterException("Lista de digito Único vazia.", HttpStatus.NOT_FOUND);
		}

		return digitoUnicoConverter.converterListaEntityToDTO(listaDigitos);
	}
	
	@Override
	public List<DigitoUnicoDTO> buscarDigitoUnicoByUser(Long id) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<DigitoUnico> criteria = builder.createQuery(DigitoUnico.class);
		Root<DigitoUnico> root = criteria.from(DigitoUnico .class);
		criteria.select(root);
		criteria.equals(Restrictions.eq("idUsuario", id));
		TypedQuery<DigitoUnico>query = manager.createQuery(criteria);

		List<DigitoUnico> lista = query.getResultList();
		if (lista.isEmpty()) {
			throw new BancoInterException("Nenhum usuario encontrado", HttpStatus.NOT_FOUND);
		}

		return digitoUnicoConverter.converterListaEntityToDTO(lista);

	}
	
	
}
