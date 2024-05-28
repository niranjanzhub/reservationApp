package org.nirz.reservationApp.Dao;





import org.nirz.reservationApp.model.Bus;
import org.nirz.reservationApp.respository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BusDao {
	@Autowired
	private BusRepository busRepository;

	public Bus saveBus(Bus bus) {
		return busRepository.save(bus);
	}
}