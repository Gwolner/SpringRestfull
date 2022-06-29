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
//import br.com.acolhimento.lgbtq.model.classes.Descricao;
//import br.com.acolhimento.lgbtq.model.classes.Instituicao;
//import br.com.acolhimento.lgbtq.model.classes.Servico;
//import br.com.acolhimento.lgbtq.model.repositorios.Fachada;
//
//@RestController
//public class DescricaoRestController {
//
//	@PostMapping("/Descricao/{cnpj}/{id}")
//	public ResponseEntity<?> inserir(
//			@RequestBody Descricao descricao, @PathVariable("cnpj") String cnpj, @PathVariable("id") int id) {
//
//		int idDescricao;
//		Instituicao instituicao;
//		Servico servico;
//		
//		try {			
//			instituicao = Fachada.getCurrentInstance().lerInstituicao(cnpj);
//			servico = Fachada.getCurrentInstance().lerServico(id);			
//			
//			descricao.setInstituicao(instituicao);
//			descricao.setServico(servico);
//			
//			idDescricao = Fachada.getCurrentInstance().inserir(descricao);
//
//			return new ResponseEntity<>(idDescricao, HttpStatus.OK);
//		} catch (SQLException e) {
//			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao inserir registro.");
//		}
//		// Para outros casos de exceção --- Pesquisar quais!
////		catch (SQLException e) {
////			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao inserir registro.");
////		}
//	}
//
//	@PutMapping("/Descricao")
//	public ResponseEntity<?> alterar(@RequestBody Descricao descricao) {
//
//		try {
//			Fachada.getCurrentInstance().alterar(descricao);
//
//			return new ResponseEntity<>(HttpStatus.OK);
//		} catch (SQLException e) {
//			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao alterar registro.");
//		}
//	}
//
//	@GetMapping("/Descricao/{id}")
//	public ResponseEntity<Descricao> ler(@PathVariable("id") int id) {
//
//		try {
//			Descricao descricao = Fachada.getCurrentInstance().lerDescricaoServico(id);
//			
//			if(descricao != null) {
//				return new ResponseEntity<Descricao>(descricao, HttpStatus.OK);	
//			}else {
//				return new ResponseEntity<Descricao>(descricao, HttpStatus.NOT_FOUND);	
//			}
//
//		} catch (SQLException e) {
//			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao ler registro.");
//		}
//	}
//
//	@DeleteMapping("/Descricao/{id}")
//	public ResponseEntity<?> delete(@PathVariable("id") int id) {
//
//		try {
//			Fachada.getCurrentInstance().deletarDescricaoServico(id);
//
//			return new ResponseEntity<>(HttpStatus.OK);
//		} catch (SQLException e) {
//			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao deletar registro.");
//		}
//	}
//
//	@GetMapping("/Descricoes")
//	public ResponseEntity<List<Descricao>> lerTodos() {
//
//		try {
//			List<Descricao> comentarios = Fachada.getCurrentInstance().lerTodasDescricoeServicos();
//			
//			if(comentarios != null) {
//				return new ResponseEntity<List<Descricao>>(comentarios, HttpStatus.OK);	
//			}else {
//				return new ResponseEntity<List<Descricao>>(comentarios, HttpStatus.NOT_FOUND);	
//			}
//		} catch (SQLException e) {
//			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao ler registros.");
//		}
//	}
//
//}
