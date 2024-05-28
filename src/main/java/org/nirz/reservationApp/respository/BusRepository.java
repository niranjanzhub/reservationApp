package org.nirz.reservationApp.respository;



import org.nirz.reservationApp.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Integer>{

}