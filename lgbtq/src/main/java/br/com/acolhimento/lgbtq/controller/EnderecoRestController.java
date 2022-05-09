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

import br.com.acolhimento.lgbtq.model.classes.Endereco;
import br.com.acolhimento.lgbtq.model.repositorios.Fachada;

@RestController
public class EnderecoRestController {

	@PostMapping("/Endereco")
	public  ResponseEntity<?> inserir(@RequestBody Endereco endereco) {
		
		try {
			Fachada.getCurrentInstance().inserir(endereco);
			
//			return "Endereco cadastrado.";
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao inserir registro.");
		}
	}
	
	@PutMapping("/Endereco")
	public ResponseEntity<?> alterar(@RequestBody Endereco endereco) {
		
		try {
			Fachada.getCurrentInstance().alterar(endereco);
			
//			return "Endereco alterado.";
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao alterar registro.");
		}
	}
	
	@GetMapping("/Endereco/{id}")
	public ResponseEntity<Endereco> ler(@PathVariable("id") int id) {
		
		try {
			Endereco endereco = Fachada.getCurrentInstance().lerEndereco(id);
			
			if(endereco != null) {
				return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);	
			}else {
				return new ResponseEntity<Endereco>(endereco, HttpStatus.NOT_FOUND);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao ler registro.");
		}
	}
	
	@DeleteMapping("/Endereco/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		
		try {
			Fachada.getCurrentInstance().deletarEndereco(id);
			
//			return "Endereco deletado.";
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao deletar registro.");
		}
	}
	
	@GetMapping("/Endereco")
	public ResponseEntity<List<Endereco>> lerTodos(){
		
		try {
			List<Endereco> enderecos = Fachada.getCurrentInstance().lerTodosEnderecos();
			
			if(enderecos != null) {
				return new ResponseEntity<List<Endereco>>(enderecos, HttpStatus.OK);	
			}else {
				return new ResponseEntity<List<Endereco>>(enderecos, HttpStatus.NOT_FOUND);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao ler registros.");
		}
	}
}
