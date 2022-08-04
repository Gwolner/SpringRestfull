package br.com.acolhimento.lgbtq.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.acolhimento.lgbtq.model.classes.Acolhido;
import br.com.acolhimento.lgbtq.model.classes.Alerta;
import br.com.acolhimento.lgbtq.model.classes.Instituicao;
import br.com.acolhimento.lgbtq.model.repositorios.Fachada;

@RestController
public class AlertaRestController {

	@PostMapping("/Alerta/{cpf}/{cnpj}")
	public ResponseEntity<?> inserir(
			@RequestBody Alerta alerta, @PathVariable("cpf") String cpf, @PathVariable("cnpj") String cnpj) {

		int idAlerta;
		Acolhido acolhido;
		Instituicao instituicao;
		
		try {
			
			acolhido = Fachada.getCurrentInstance().lerAcolhido(cpf);
			instituicao = Fachada.getCurrentInstance().lerInstituicao(cnpj);
			
			alerta.setAcolhido(acolhido);
			alerta.setInstituicao(instituicao);
			
			idAlerta = Fachada.getCurrentInstance().inserir(alerta);

			return new ResponseEntity<>(idAlerta, HttpStatus.OK);
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao inserir registro.");
		}
		// Para outros casos de exceção --- Pesquisar quais!
//		catch (SQLException e) {
//			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao inserir registro.");
//		}
	}

	@PutMapping("/Alerta")
	public ResponseEntity<?> alterar(@RequestBody Alerta alerta) {

		try {
			Fachada.getCurrentInstance().alterar(alerta);

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao alterar registro.");
		}
	}

	@GetMapping("/Alerta/{id}")
	public ResponseEntity<Alerta> ler(@PathVariable("id") int id) {

		try {
			Alerta alerta = Fachada.getCurrentInstance().lerAlerta(id);
			
			if(alerta != null) {
				return new ResponseEntity<Alerta>(alerta, HttpStatus.OK);	
			}else {
				return new ResponseEntity<Alerta>(alerta, HttpStatus.NOT_FOUND);	
			}

		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao ler registro.");
		}
	}

	@DeleteMapping("/Alerta/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {

		try {
			Fachada.getCurrentInstance().deletarAlerta(id);

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao deletar registro.");
		}
	}

	@GetMapping("/Alertas")
	public ResponseEntity<List<Alerta>> lerTodos() {

		try {
			List<Alerta> comentarios = Fachada.getCurrentInstance().lerTodosAlertas();
			
			if(comentarios != null) {
				return new ResponseEntity<List<Alerta>>(comentarios, HttpStatus.OK);	
			}else {
				return new ResponseEntity<List<Alerta>>(comentarios, HttpStatus.NOT_FOUND);	
			}
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao ler registros.");
		}
	}
}
