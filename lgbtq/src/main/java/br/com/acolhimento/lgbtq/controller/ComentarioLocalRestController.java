//package br.com.acolhimento.lgbtq.controller;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;
//
//import br.com.acolhimento.lgbtq.model.classes.ComentarioLocal;
//import br.com.acolhimento.lgbtq.model.repositorios.Fachada;
//
//@RestController
//public class ComentarioLocalRestController {
//
//	@PostMapping("/ComentarioLocal")
//	public  ResponseEntity<?> inserir(@RequestBody ComentarioLocal comentario) {
//		
//		try {
//			Fachada.getCurrentInstance().inserir(comentario);
//			
//			return new ResponseEntity<>(HttpStatus.OK);
//		} catch (SQLException e) {
//			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao inserir registro.");
//		}
//	}
//	
//	@PutMapping("/ComentarioLocal")
//	public ResponseEntity<?> alterar(@RequestBody ComentarioLocal comentario) {
//		
//		try {
//			Fachada.getCurrentInstance().alterar(comentario);
//			
//			return new ResponseEntity<>(HttpStatus.OK);
//		} catch (SQLException e) {
//			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao alterar registro.");
//		}
//	}
//	
//	@GetMapping("/ComentarioLocal/{id}")
//	public ResponseEntity<ComentarioLocal> ler(@PathVariable("id") int id) {
//		
//		try {
//			ComentarioLocal comentario = Fachada.getCurrentInstance().lerComentarioLocal(id);
//			
//			if(comentario != null) {
//				return new ResponseEntity<ComentarioLocal>(comentario, HttpStatus.OK);	
//			}else {
//				return new ResponseEntity<ComentarioLocal>(comentario, HttpStatus.NOT_FOUND);	
//			}
//			
//		} catch (SQLException e) {
//			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao ler registro.");
//		}
//	}
//	
//	@DeleteMapping("/ComentarioLocal/{id}")
//	public ResponseEntity<?> delete(@PathVariable("id") int id) {
//		
//		try {
//			Fachada.getCurrentInstance().deletarComentarioLocal(id);
//			
//			return new ResponseEntity<>(HttpStatus.OK);
//		} catch (SQLException e) {
//			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao deletar registro.");
//		}
//	}
//	
//	@GetMapping("/ComentarioLocal")
//	public ResponseEntity<List<ComentarioLocal>> lerTodos(){
//		
//		try {
//			List<ComentarioLocal> comentarios = Fachada.getCurrentInstance().lerTodosComentariosLocal();
//			
//			if(comentarios != null) {
//				return new ResponseEntity<List<ComentarioLocal>>(comentarios, HttpStatus.OK);	
//			}else {
//				return new ResponseEntity<List<ComentarioLocal>>(comentarios, HttpStatus.NOT_FOUND);	
//			}
//		} catch (SQLException e) {
//			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao ler registros.");
//		}
//	}
//}
