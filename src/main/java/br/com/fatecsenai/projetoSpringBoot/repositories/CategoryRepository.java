package br.com.fatecsenai.projetoSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatecsenai.projetoSpringBoot.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
