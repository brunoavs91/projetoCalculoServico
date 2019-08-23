package br.com.banco.inter.controller;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.inter.dto.DigitoUnicoDTO;
import br.com.banco.inter.repository.DigitoUnicoRepository;
import br.com.banco.inter.service.DigitoUnicoService;

@RestController
@RequestMapping(value="/digitounico")
public class DigitoUnicoController {

	
	@Autowired
	private DigitoUnicoRepository digitoUnicoRepository;

	@Autowired
	private DigitoUnicoService digitoUnicoService;

	@PostMapping("/calcularesultado")
	public ResponseEntity<DigitoUnicoDTO> calcularDigitoUnico(@RequestBody DigitoUnicoDTO digitoUnicoDTO) {

		DigitoUnicoDTO digitoCalculado = digitoUnicoService.calculoDigitoUnico(digitoUnicoDTO);
		return ResponseEntity.status(HttpStatus.OK).body(digitoCalculado);
	}

	@GetMapping("/buscartodosdigitos")
	public ResponseEntity<List<DigitoUnicoDTO>> listaDigitoUnico() {
		List<DigitoUnicoDTO> listaDigitoUnico = digitoUnicoService.listaDigitoUnico();
		return ResponseEntity.status(HttpStatus.OK).body(listaDigitoUnico);
	}

	@GetMapping("/buscardigitousuario/{id}")
	public ResponseEntity<List<DigitoUnicoDTO>> listaDigitoUnicoById(@PathVariable Long id) {

		List<DigitoUnicoDTO> listaDigitoUnico = digitoUnicoService.buscarDigitoUnicoByUser(id);

		return ResponseEntity.status(HttpStatus.OK).body(listaDigitoUnico);
	}
}
