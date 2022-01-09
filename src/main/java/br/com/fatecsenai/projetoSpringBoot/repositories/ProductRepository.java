package br.com.fatecsenai.projetoSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatecsenai.projetoSpringBoot.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
