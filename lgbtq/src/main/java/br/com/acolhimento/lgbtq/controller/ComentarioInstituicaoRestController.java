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

import br.com.acolhimento.lgbtq.model.classes.ComentarioInstituicao;
import br.com.acolhimento.lgbtq.model.repositorios.Fachada;

@RestController
public class ComentarioInstituicaoRestController {
	
	@PostMapping("/ComentarioInstituicao")
	public  ResponseEntity<?> inserir(@RequestBody ComentarioInstituicao comentario) {
		
		try {
			Fachada.getCurrentInstance().inserir(comentario);
			
//			return "Comentario cadastrado.";
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao inserir registro.");
		}
	}
	
	@PutMapping("/ComentarioInstituicao")
	public ResponseEntity<?> alterar(@RequestBody ComentarioInstituicao comentario) {
		
		try {
			Fachada.getCurrentInstance().alterar(comentario);
			
//			return "Comentario alterado.";
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao alterar registro.");
		}
	}
	
	@GetMapping("/ComentarioInstituicao/{id}")
	public ResponseEntity<ComentarioInstituicao> ler(@PathVariable("id") int id) {
		
		try {
			ComentarioInstituicao comentario = Fachada.getCurrentInstance().lerComentarioInstituicao(id);
			
			if(comentario != null) {
				return new ResponseEntity<ComentarioInstituicao>(comentario, HttpStatus.OK);	
			}else {
				return new ResponseEntity<ComentarioInstituicao>(comentario, HttpStatus.NOT_FOUND);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao ler registro.");
		}
	}
	
	@DeleteMapping("/ComentarioInstituicao/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		
		try {
			Fachada.getCurrentInstance().deletarComentarioInstituicao(id);
			
//			return "Comentario deletado.";
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao deletar registro.");
		}
	}
	
	@GetMapping("/ComentarioInstituicao")
	public ResponseEntity<List<ComentarioInstituicao>> lerTodos(){
		
		try {
			List<ComentarioInstituicao> comentarios = Fachada.getCurrentInstance().lerTodosComentariosInstituicao();
			
			if(comentarios != null) {
				return new ResponseEntity<List<ComentarioInstituicao>>(comentarios, HttpStatus.OK);	
			}else {
				return new ResponseEntity<List<ComentarioInstituicao>>(comentarios, HttpStatus.NOT_FOUND);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao ler registros.");
		}
	}
}
