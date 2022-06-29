package br.com.acolhimento.lgbtq.controller;

import java.sql.SQLException;
import java.util.ArrayList;
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
import br.com.acolhimento.lgbtq.model.classes.Coordenada;
import br.com.acolhimento.lgbtq.model.classes.Descricao;
import br.com.acolhimento.lgbtq.model.classes.Endereco;
import br.com.acolhimento.lgbtq.model.classes.Instituicao;
import br.com.acolhimento.lgbtq.model.classes.Servico;
import br.com.acolhimento.lgbtq.model.repositorios.Fachada;

@RestController
public class InstituicaoRestController {

	@PostMapping("/Instituicao")
	public ResponseEntity<?> inserir(@RequestBody Instituicao instituicao) {

		int idCoordenada;
		int idEndereco;

		try {

			idCoordenada = Fachada.getCurrentInstance().inserir(instituicao.getCoordenada());
			idEndereco = Fachada.getCurrentInstance().inserir(instituicao.getEndereco());

			instituicao.getCoordenada().setId(idCoordenada);
			instituicao.getEndereco().setId(idEndereco);

			Fachada.getCurrentInstance().inserir(instituicao);

			return new ResponseEntity<>(instituicao.getCnpj(), HttpStatus.OK);
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao inserir registro.");
		}
		// Para outros casos de exceção --- Pesquisar quais!
//		catch (SQLException e) {
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

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao alterar registro.");
		}
	}

	@SuppressWarnings("unused")
	@GetMapping("/Instituicao/{cnpj}")
	public ResponseEntity<Instituicao> ler(@PathVariable("cnpj") String cnpj) {

		Instituicao instituicao;
		Coordenada coord;
		Endereco end;
		ArrayList<ComentarioInstituicao> comentarios;
		ArrayList<Descricao> descricoes;
		
		try {
			instituicao = Fachada.getCurrentInstance().lerInstituicao(cnpj);

			coord = Fachada.getCurrentInstance().lerCoordenada(instituicao.getCoordenada().getId());
			instituicao.setCoordenada(coord);

			end = Fachada.getCurrentInstance().lerEndereco(instituicao.getEndereco().getId());
			instituicao.setEndereco(end);
			
			comentarios = Fachada.getCurrentInstance().lerComentarioPorCnpjInstituicao(instituicao.getCnpj());
			instituicao.setComentarios(comentarios);
			
			descricoes = Fachada.getCurrentInstance().lerDescricaoPorCnpjInstituicao(instituicao.getCnpj());			
			instituicao.setDescricoes(descricoes);

			if (instituicao != null) {
				return new ResponseEntity<Instituicao>(instituicao, HttpStatus.OK);
			} else {
				return new ResponseEntity<Instituicao>(instituicao, HttpStatus.NOT_FOUND);
			}

		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao ler registro.");
		}
	}

	@DeleteMapping("/Instituicao/{cnpj}")
	public ResponseEntity<?> delete(@PathVariable("cnpj") String cnpj) {

		Instituicao instituicao;

		try {
			instituicao = Fachada.getCurrentInstance().lerInstituicao(cnpj);

			System.out.println("Instituicao ID: " + instituicao.getCnpj());

			Fachada.getCurrentInstance().deletarInstituicao(cnpj);

			Fachada.getCurrentInstance().deletarCoordenada(instituicao.getCoordenada().getId());
			Fachada.getCurrentInstance().deletarEndereco(instituicao.getEndereco().getId());

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao deletar registro.");
		}
	}

	@GetMapping("/Instituicoes")
	public ResponseEntity<List<Instituicao>> lerTodasInstituicoes() {

		List<Instituicao> instituicoes;
		Coordenada coord;
		Endereco end;
		ArrayList<ComentarioInstituicao> comentarios;
		
		try {
			instituicoes = Fachada.getCurrentInstance().lerTodasInstituicoes();

			for (Instituicao instituicao : instituicoes) {
				coord = Fachada.getCurrentInstance().lerCoordenada(instituicao.getCoordenada().getId());
				end = Fachada.getCurrentInstance().lerEndereco(instituicao.getEndereco().getId());
				comentarios = Fachada.getCurrentInstance().lerComentarioPorCnpjInstituicao(instituicao.getCnpj());
				instituicao.setCoordenada(coord);
				instituicao.setEndereco(end);
				instituicao.setComentarios(comentarios);
			}

			if (instituicoes != null) {
				return new ResponseEntity<List<Instituicao>>(instituicoes, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<Instituicao>>(instituicoes, HttpStatus.NOT_FOUND);
			}
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao ler registros.");
		}
	}

	// ###################################### COMENTÁRIOS ######################################

	// CREATE
	@PostMapping("/Instituicao/Comentar")
	public ResponseEntity<?> inserirComentario(@RequestBody ComentarioInstituicao comentario) {

		try {
			Fachada.getCurrentInstance().inserir(comentario);

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao inserir registro.");
		}
	}

	// READ
	// Ocorre ao ler uma Instituicao

	// UPDATE
	@PutMapping("/Instituicao/Comentar")
	public ResponseEntity<?> atualizarComentario(@RequestBody ComentarioInstituicao comentario) {

		try {
			Fachada.getCurrentInstance().alterar(comentario);

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao alterar registro.");
		}
	}

	// DELETE
	@DeleteMapping("/Instituicao/Comentar/{id}")
	public ResponseEntity<?> deletarComentario(@PathVariable("id") int id) {

		try {
			Fachada.getCurrentInstance().deletarComentarioInstituicao(id);

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao deletar registro.");
		}
	}
	
	// ###################################### DESCRICAO ######################################

	// CREATE
	@PostMapping("Instituicao/Descricao/{cnpj}/{id}")
	public ResponseEntity<?> inserir(
			@RequestBody Descricao descricao, @PathVariable("cnpj") String cnpj, @PathVariable("id") int id) {

		int idDescricao;
		Instituicao instituicao;
		Servico servico;
		
		try {			
			instituicao = Fachada.getCurrentInstance().lerInstituicao(cnpj);
			servico = Fachada.getCurrentInstance().lerServico(id);			
			
			descricao.setInstituicao(instituicao);
			descricao.setServico(servico);
			
			idDescricao = Fachada.getCurrentInstance().inserir(descricao);

			return new ResponseEntity<>(idDescricao, HttpStatus.OK);
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao inserir registro.");
		}
		// Para outros casos de exceção --- Pesquisar quais!
//		catch (SQLException e) {
//			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao inserir registro.");
//		}
	}
	
	// READ
	// Ocorre ao ler uma Instituicao
	
	// UPDATE
	@PutMapping("/Instituicao/Descricao")
	public ResponseEntity<?> alterar(@RequestBody Descricao descricao) {

		try {
			Fachada.getCurrentInstance().alterar(descricao);

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao alterar registro.");
		}
	}
	
	// DELETE
	@DeleteMapping("/Instituicao/Descricao/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {

		try {
			Fachada.getCurrentInstance().deletarDescricaoServico(id);

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao deletar registro.");
		}
	}
	
	//READ - ALL
	@GetMapping("/Instituicao/Descricoes")
	public ResponseEntity<List<Descricao>> lerTodasDescricoes() {

		try {
			List<Descricao> comentarios = Fachada.getCurrentInstance().lerTodasDescricoeServicos();
			
			if(comentarios != null) {
				return new ResponseEntity<List<Descricao>>(comentarios, HttpStatus.OK);	
			}else {
				return new ResponseEntity<List<Descricao>>(comentarios, HttpStatus.NOT_FOUND);	
			}
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao ler registros.");
		}
	}
}
