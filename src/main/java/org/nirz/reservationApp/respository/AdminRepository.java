package org.nirz.reservationApp.respository;

import java.util.Optional;

import org.nirz.reservationApp.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
@Query("SELECT a FROM Admin a WHERE a.email = :email AND a.password = :password")
	Optional<Admin> verifyAdmin(@Param("email") String email, @Param("password") String password);
@Query("SELECT a FROM Admin a WHERE a.phone = :phone AND a.password = :password")
Optional<Admin> verifyAdmin(@Param("phone") long phone, @Param("password") String password);

}
