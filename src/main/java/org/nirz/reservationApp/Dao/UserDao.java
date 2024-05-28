package org.nirz.reservationApp.Dao;


import java.util.Optional;

import org.nirz.reservationApp.model.User;
import org.nirz.reservationApp.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}

	public Optional<User> verify(long phone, String password) {
		return userRepository.findByPhoneAndPassword(phone, password);
	}

	public Optional<User> verify(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public void delete(int id) {
		userRepository.deleteById(id);
	}
}