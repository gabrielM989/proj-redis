package SoulCode.ProjetoRedis.Repository;

import org.springframework.data.repository.CrudRepository;

import SoulCode.ProjetoModels.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
	

}
