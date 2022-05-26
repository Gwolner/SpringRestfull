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

import br.com.acolhimento.lgbtq.model.classes.ComentarioLocal;
import br.com.acolhimento.lgbtq.model.classes.Coordenada;
import br.com.acolhimento.lgbtq.model.classes.Endereco;
import br.com.acolhimento.lgbtq.model.classes.Local;
import br.com.acolhimento.lgbtq.model.repositorios.Fachada;

@RestController
public class LocalRestController {
	
	//IMPLEMENTAR 
	//MÉTODOS PARA 
	//ADICIONAR 
	//COMENTÁRIOS!!

	@PostMapping("/Local")
	public  ResponseEntity<?> inserir(@RequestBody Local local) {
		
		int idCoordenada;
		int idEndereco;
		
		try {
			
			idCoordenada = Fachada.getCurrentInstance().inserir(local.getCoordenada());
			idEndereco = Fachada.getCurrentInstance().inserir(local.getEndereco());
			
			local.getCoordenada().setId(idCoordenada);
			local.getEndereco().setId(idEndereco);
			
			Fachada.getCurrentInstance().inserir(local);		
			
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
	
	@PutMapping("/Local")
	public ResponseEntity<?> alterar(@RequestBody Local local) {
		
		Coordenada coordenada;
		Endereco endereco;
		
		try {
			
			coordenada = Fachada.getCurrentInstance().lerCoordenada(local.getCoordenada().getId());
			
			coordenada.setLatitude(local.getCoordenada().getLatitude());
			coordenada.setLongitude(local.getCoordenada().getLongitude());
			
			Fachada.getCurrentInstance().alterar(coordenada);
			
			endereco = Fachada.getCurrentInstance().lerEndereco(local.getEndereco().getId());
			
			endereco.setLogradouro(local.getEndereco().getLogradouro());
			endereco.setNumero(local.getEndereco().getNumero());
			endereco.setBairro(local.getEndereco().getBairro());
			endereco.setCidade(local.getEndereco().getCidade());
			endereco.setEstado(local.getEndereco().getEstado());
			endereco.setCep(local.getEndereco().getCep());
			
			Fachada.getCurrentInstance().alterar(endereco);
			
			Fachada.getCurrentInstance().alterar(local);
			
//			return "Local alterado.";
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao alterar registro.");
		}
	}
	
	@SuppressWarnings("unused")
	@GetMapping("/Local/{id}")
	public ResponseEntity<Local> ler(@PathVariable("id") int id) {
		
		try {
			Local local = Fachada.getCurrentInstance().lerLocal(id);
			
			Coordenada coord = Fachada.getCurrentInstance().lerCoordenada(local.getCoordenada().getId());				
			local.setCoordenada(coord);
			
			Endereco end = Fachada.getCurrentInstance().lerEndereco(local.getEndereco().getId());				
			local.setEndereco(end);
			
			if(local != null) {
				return new ResponseEntity<Local>(local, HttpStatus.OK);	
			}else {
				return new ResponseEntity<Local>(local, HttpStatus.NOT_FOUND);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao ler registro.");
		}
	}
	
	@DeleteMapping("/Local/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		
		Local local;
		
		try {
			local = Fachada.getCurrentInstance().lerLocal(id);
			
			System.out.println("Local ID: "+ local.getId());
			
			Fachada.getCurrentInstance().deletarLocal(id);
			
			Fachada.getCurrentInstance().deletarCoordenada(local.getCoordenada().getId());
			Fachada.getCurrentInstance().deletarEndereco(local.getEndereco().getId());
			
//			return "Local deletado.";
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao deletar registro.");
		}
	}
	
	@GetMapping("/Locais")
	public ResponseEntity<List<Local>> lerTodos(){
		
		try {
			List<Local> locais = Fachada.getCurrentInstance().lerTodosLocais();
			
			for (Local local : locais) {				
				Coordenada coord = Fachada.getCurrentInstance().lerCoordenada(local.getCoordenada().getId());				
				Endereco end = Fachada.getCurrentInstance().lerEndereco(local.getEndereco().getId());
				local.setCoordenada(coord);
				local.setEndereco(end);
			}
			
			if(locais != null) {
				return new ResponseEntity<List<Local>>(locais, HttpStatus.OK);	
			}else {
				return new ResponseEntity<List<Local>>(locais, HttpStatus.NOT_FOUND);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao ler registros.");
		}
	}
	
	// COMENTÁRIOS
	@PutMapping("/Local")
	public ResponseEntity<?> comentar(@RequestBody ComentarioLocal local) {
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
