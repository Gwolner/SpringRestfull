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

import br.com.acolhimento.lgbtq.model.classes.Servico;
import br.com.acolhimento.lgbtq.model.repositorios.Fachada;

@RestController
public class ServicoRestController {
	
	@PostMapping("/Servico")
	public  ResponseEntity<?> inserir(@RequestBody Servico servico) {
		
		try {
			Fachada.getCurrentInstance().inserir(servico);
			
//			return "Serviço cadastrado.";
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao inserir registro.");
		}
	}
	
	@PutMapping("/Servico")
	public ResponseEntity<?> alterar(@RequestBody Servico servico) {
		
		try {
			Fachada.getCurrentInstance().alterar(servico);
			
//			return "Serviço alterado.";
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao alterar registro.");
		}
	}
	
	@GetMapping("/Servico/{id}")
	public ResponseEntity<Servico> ler(@PathVariable("id") int id) {
		
		try {
			Servico servico = Fachada.getCurrentInstance().lerServico(id);
			
			if(servico != null) {
				return new ResponseEntity<Servico>(servico, HttpStatus.OK);	
			}else {
				return new ResponseEntity<Servico>(servico, HttpStatus.NOT_FOUND);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao ler registro.");
		}
	}
	
	@DeleteMapping("/Servico/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		
		try {
			Fachada.getCurrentInstance().deletarServico(id);
			
//			return "Servico deletado.";
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao deletar registro.");
		}
	}
	
	@GetMapping("/Servico")
	public ResponseEntity<List<Servico>> lerTodos(){
		
		try {
			List<Servico> servicos = Fachada.getCurrentInstance().lerTodosServicos();
			
			if(servicos != null) {
				return new ResponseEntity<List<Servico>>(servicos, HttpStatus.OK);	
			}else {
				return new ResponseEntity<List<Servico>>(servicos, HttpStatus.NOT_FOUND);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao ler registros.");
		}
	}
}
