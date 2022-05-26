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

import br.com.acolhimento.lgbtq.model.classes.Coordenada;
import br.com.acolhimento.lgbtq.model.classes.Endereco;
import br.com.acolhimento.lgbtq.model.classes.Instituicao;
import br.com.acolhimento.lgbtq.model.repositorios.Fachada;

@RestController
public class InstituicaoRestController {
	
	//IMPLEMENTAR 
	//MÉTODOS PARA 
	//ADICIONAR 
	//COMENTÁRIOS!!

	@PostMapping("/Instituicao")
	public  ResponseEntity<?> inserir(@RequestBody Instituicao instituicao) {
		
		int idCoordenada;
		int idEndereco;
		
		try {
			
			idCoordenada = Fachada.getCurrentInstance().inserir(instituicao.getCoordenada());
			idEndereco = Fachada.getCurrentInstance().inserir(instituicao.getEndereco());
			
			instituicao.getCoordenada().setId(idCoordenada);
			instituicao.getEndereco().setId(idEndereco);
			
			Fachada.getCurrentInstance().inserir(instituicao);		
			
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
	
	@PutMapping("/Instituicao")
	public ResponseEntity<?> alterar(@RequestBody Instituicao instituicao) {
		
		Coordenada coordenada;
		Endereco endereco;
		
		try {
			
			coordenada = Fachada.getCurrentInstance().lerCoordenada(instituicao.getCoordenada().getId());
			
			coordenada.setLatitude(instituicao.getCoordenada().getLatitude());
			coordenada.setLongitude(instituicao.getCoordenada().getLongitude());
			
			Fachada.getCurrentInstance().alterar(coordenada);
			
			endereco = Fachada.getCurrentInstance().lerEndereco(instituicao.getEndereco().getId());
			
			endereco.setLogradouro(instituicao.getEndereco().getLogradouro());
			endereco.setNumero(instituicao.getEndereco().getNumero());
			endereco.setBairro(instituicao.getEndereco().getBairro());
			endereco.setCidade(instituicao.getEndereco().getCidade());
			endereco.setEstado(instituicao.getEndereco().getEstado());
			endereco.setCep(instituicao.getEndereco().getCep());
			
			Fachada.getCurrentInstance().alterar(endereco);
			
			Fachada.getCurrentInstance().alterar(instituicao);
			
//			return "Instituicao alterado.";
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao alterar registro.");
		}
	}
	
	@SuppressWarnings("unused")
	@GetMapping("/Instituicao/{cnpj}")
	public ResponseEntity<Instituicao> ler(@PathVariable("cnpj") String cnpj) {
		
		try {
			Instituicao instituicao = Fachada.getCurrentInstance().lerInstituicao(cnpj);
			
			Coordenada coord = Fachada.getCurrentInstance().lerCoordenada(instituicao.getCoordenada().getId());				
			instituicao.setCoordenada(coord);
			
			Endereco end = Fachada.getCurrentInstance().lerEndereco(instituicao.getEndereco().getId());				
			instituicao.setEndereco(end);
			
			if(instituicao != null) {
				return new ResponseEntity<Instituicao>(instituicao, HttpStatus.OK);	
			}else {
				return new ResponseEntity<Instituicao>(instituicao, HttpStatus.NOT_FOUND);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao ler registro.");
		}
	}
	
	@DeleteMapping("/Instituicao/{cnpj}")
	public ResponseEntity<?> delete(@PathVariable("cnpj") String cnpj) {
		
		Instituicao instituicao;
		
		try {
			instituicao = Fachada.getCurrentInstance().lerInstituicao(cnpj);
			
			System.out.println("Instituicao ID: "+ instituicao.getCnpj());
			
			Fachada.getCurrentInstance().deletarInstituicao(cnpj);
			
			Fachada.getCurrentInstance().deletarCoordenada(instituicao.getCoordenada().getId());
			Fachada.getCurrentInstance().deletarEndereco(instituicao.getEndereco().getId());
			
//			return "Instituicao deletado.";
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao deletar registro.");
		}
	}
	
	@GetMapping("/Instituicoes")
	public ResponseEntity<List<Instituicao>> lerTodos(){
		
		try {
			List<Instituicao> instituicoes = Fachada.getCurrentInstance().lerTodasInstituicoes();
			
			for (Instituicao instituicao : instituicoes) {				
				Coordenada coord = Fachada.getCurrentInstance().lerCoordenada(instituicao.getCoordenada().getId());				
				Endereco end = Fachada.getCurrentInstance().lerEndereco(instituicao.getEndereco().getId());
				instituicao.setCoordenada(coord);
				instituicao.setEndereco(end);
			}
			
			if(instituicoes != null) {
				return new ResponseEntity<List<Instituicao>>(instituicoes, HttpStatus.OK);	
			}else {
				return new ResponseEntity<List<Instituicao>>(instituicoes, HttpStatus.NOT_FOUND);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao ler registros.");
		}
	}

}
