package SoulCode.ProjetoRedis.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SoulCode.ProjetoModels.Produto;
import SoulCode.ProjetoRedis.Repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Produto> mostrarTodos() {
		return (List<Produto>) produtoRepository.findAll(); //Entre parênteses() suprime a necessidade de instanciar o objeto
		
	}
	
	public Produto mostrarUmProduto(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.orElseThrow();
	}
	
	public Produto inserirProduto (Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public void excluirProduto(Integer id) {
		produtoRepository.deleteById(id);
	}
	
	public Produto editarProduto(Produto produto) {
		mostrarUmProduto(produto.getId());
		return produtoRepository.save(produto);
	}
	
	
}
