package org.nirz.reservationApp.respository;

import org.nirz.reservationApp.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
