package br.com.fatecsenai.projetoSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatecsenai.projetoSpringBoot.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
