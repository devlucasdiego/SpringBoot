package br.com.fatecsenai.projetoSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatecsenai.projetoSpringBoot.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
