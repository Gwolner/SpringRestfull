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
import br.com.acolhimento.lgbtq.model.classes.Coordenada;
import br.com.acolhimento.lgbtq.model.repositorios.Fachada;

@RestController
public class AcolhidoRestController  {
	
	@PostMapping("/Acolhido")
	public  ResponseEntity<?> inserir(@RequestBody Acolhido acolhido) {
		
		int idCoordenada;
		
		try {
			idCoordenada = Fachada.getCurrentInstance().inserir(acolhido.getCoordenada());
			
			acolhido.getCoordenada().setId(idCoordenada);
			
			Fachada.getCurrentInstance().inserir(acolhido);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao inserir registro.");
		}
		//Para outros casos de exceção  --- Pesquisar quais!
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
//			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao inserir registro.");
//		}
	}
	
	@PutMapping("/Acolhido")
	public ResponseEntity<?> alterar(@RequestBody Acolhido acolhido) {

		Coordenada coordenada;
		
		try {
			
			coordenada = Fachada.getCurrentInstance().lerCoordenada(acolhido.getCoordenada().getId());
			
			coordenada.setLatitude(acolhido.getCoordenada().getLatitude());
			coordenada.setLongitude(acolhido.getCoordenada().getLongitude());
			
			Fachada.getCurrentInstance().alterar(coordenada);
			
			Fachada.getCurrentInstance().alterar(acolhido);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@SuppressWarnings("unused")
	@GetMapping("/Acolhido/{cpf}")
	public ResponseEntity<Acolhido> ler(@PathVariable("cpf") String cpf) {
		
		try {
			Acolhido acolhido = Fachada.getCurrentInstance().lerAcolhido(cpf);
			
			Coordenada coord = Fachada.getCurrentInstance().lerCoordenada(acolhido.getCoordenada().getId());				
			acolhido.setCoordenada(coord);
			
			if(acolhido != null) {
				return new ResponseEntity<Acolhido>(acolhido, HttpStatus.OK);	
			}else {
				return new ResponseEntity<Acolhido>(acolhido, HttpStatus.NOT_FOUND);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao ler registro.");
		}
	}
	
	@DeleteMapping("/Acolhido/{cpf}")
	public ResponseEntity<?> delete(@PathVariable("cpf") String cpf) {
		
		//"Quem chama (acolhido) some primeiro (do que quem é chamado)"
		Acolhido acolhido;
		
		try {
			//Recupera e salva o Acolhido
			acolhido = Fachada.getCurrentInstance().lerAcolhido(cpf);
			
			//Deleta o acolhido antes da Coordenada
			Fachada.getCurrentInstance().deletarAcolhido(cpf);
			
			//Faz uso da FK de Acolhido para excluir registro na tabela de Coordenada				
			Fachada.getCurrentInstance().deletarCoordenada(acolhido.getCoordenada().getId());
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao deletar registro.");
		}
	}
	
	@GetMapping("/Acolhidos")
	public ResponseEntity<List<Acolhido>> lerTodos(){
		
		try {
			List<Acolhido> acolhidos = Fachada.getCurrentInstance().lerTodosAcolhidos();		
			
			for (Acolhido acolhido : acolhidos) {				
				Coordenada coord = Fachada.getCurrentInstance().lerCoordenada(acolhido.getCoordenada().getId());				
				acolhido.setCoordenada(coord);
			}
			
			if(acolhidos != null) {
				return new ResponseEntity<List<Acolhido>>(acolhidos, HttpStatus.OK);	
			}else {
				return new ResponseEntity<List<Acolhido>>(acolhidos, HttpStatus.NOT_FOUND);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao ler registros.");
		}
	}
}
