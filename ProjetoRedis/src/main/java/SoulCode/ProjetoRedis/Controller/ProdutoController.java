
package SoulCode.ProjetoRedis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SoulCode.ProjetoModels.Produto;
import SoulCode.ProjetoRedis.Services.ProdutoService;

@RestController
@RequestMapping("/apiRedis")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtorService;
	
	@GetMapping("/produto")
	public ResponseEntity<List<Produto>> mostrarTodos(){
		return ResponseEntity.ok(produtorService.mostrarTodos());
	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> mostrarUmProduto(@PathVariable Integer id){
		Produto produto = produtorService.mostrarUmProduto(id);
		return ResponseEntity.ok().body(produto);
			
	}
	
	
	@PostMapping("/produto")
	public ResponseEntity<Produto> inserirProduto (@RequestBody Produto produto){
		return ResponseEntity.ok(produtorService.inserirProduto(produto));
		
	}
	@DeleteMapping("/produto/{id}")
	public ResponseEntity<Void> excluirProduto(@PathVariable Integer id){
		produtorService.excluirProduto(id);
		return ResponseEntity.noContent().build(); // Vai dar uma resposta sem devolver nada "noContent". Já o BUILD é para fazer
	}
	
	@PutMapping("produto/{id}")
	public ResponseEntity<Produto> editarProduto(@PathVariable Integer id, @RequestBody Produto produto){
		produto = produtorService.editarProduto(produto);
		return ResponseEntity.noContent().build();
	}
	
	
}
