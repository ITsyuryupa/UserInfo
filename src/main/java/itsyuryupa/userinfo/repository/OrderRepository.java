package itsyuryupa.userinfo.repository;

import itsyuryupa.userinfo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}