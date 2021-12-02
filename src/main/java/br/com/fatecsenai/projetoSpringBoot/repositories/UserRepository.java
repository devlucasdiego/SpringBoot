package br.com.fatecsenai.projetoSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatecsenai.projetoSpringBoot.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
