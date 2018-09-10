package br.com.linoox.udemy.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.linoox.udemy.domain.Categoria;
import br.com.linoox.udemy.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Produto> search(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);

	// Fazendo a mesma consulta com o nomes de métodos do Spring (dispensa as anotações @Query e @Param)
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	// Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome,
	// List<Categoria> categorias, Pageable pageRequest);
}
